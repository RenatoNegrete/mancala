/************************************************************
 * Pontificia Universidad Javeriana
 * Analisis de algoritmos
 * Autores: Sergio Cuellar y Renaro Negrete
*************************************************************/

import java.util.ArrayList;
import java.util.List;
public class AIPlayer implements Player {

    private String name;

    public AIPlayer(String name) {
        this.name = name;
    }

    public List<Board> getAllMoves(Board board, int player) {
        List<Board> moves = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (board.getPit(player, i).getRocks() != 0) {
                Board newBoard = board.copy();
                newBoard.setExtra(false);
                boolean extra = newBoard.moveRocks(i, player);
                int h = newBoard.heuristic(player);
                if (extra) {
                    newBoard.setExtra(true);
                }
                newBoard.setHeuristic(h);
                moves.add(newBoard);
            }
        }
        return moves;
    }

    public int minimax(Board board, int player, int depth, int alpha, int beta) {
        if (depth == 0 || board.finished()) {
            return board.heuristic(player);
        }
        boolean isMax = (player == 1);
        int best = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (board.getPit(player, i).getRocks() == 0) continue;
            Board newBoard = board.copy();
            boolean extra = newBoard.moveRocks(i, player);
            int val;
            if (extra) {
                val = minimax(newBoard, player, depth - 1, alpha, beta);
            } else {
                val = minimax(newBoard, 1 - player, depth - 1, alpha, beta);
            }
            if (isMax) {
                best = Math.max(best, val);
                alpha = Math.max(alpha, best);
                if (beta <= alpha) break;
            } else {
                best = Math.min(best, val);
                beta = Math.min(beta, best);
                if (beta <= alpha) break;
            }
        }
        return best;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int chooseMove(Board board, int player, int depth) {
        int bestMove = -1;
        int bestValue = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            if (board.getPit(player, i).getRocks() == 0) continue;
            Board newBoard = board.copy();
            boolean extra = newBoard.moveRocks(i, player);
            int val;
            if (extra) {
                val = minimax(newBoard, player, depth - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
                val += 30;
            } else {
                val = minimax(newBoard, 1 - player, depth - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
            if (val > bestValue) {
                bestValue = val;
                bestMove = i;
            }
        }
        return bestMove + 1;
    }

}
