import java.util.ArrayList;
import java.util.List;

public class AIPlayer implements Player {

    private String name;

    public AIPlayer(String name) {
        this.name = name;
    }

    public List<Board> getAllMoves(Board board, int player) {
        List<Board> moves = new ArrayList<>();
        for(int i = 0;  i < 6; i++) {
            if(board.getPit(player, i).getRocks() != 0) {
                Board newBoard = board.copy();
                newBoard.setExtra(false);
                boolean extra = newBoard.moveRocks(i, player);
                newBoard.setHeuristic(newBoard.heuristic(player));
                if(extra) {
                    newBoard.setExtra(true);
                    newBoard.setHeuristic(newBoard.getHeuristic() + 30);
                } 
                moves.add(newBoard);
            }
        }
        return moves;
    } 

    public int minimax(Board board, int maximizer, int depth) {
        if(depth == 0 || board.finished()) {
            return board.getHeuristic();
        }
        if(maximizer == 1) {
            int max = Integer.MIN_VALUE;
            List<Board> posibleMoves = getAllMoves(board, 1);
            for(Board b : posibleMoves) {
                int val;
                if(b.getExtra()) {
                    val = minimax(b, 1, depth - 1);
                } else {
                    val = minimax(b, 0, depth - 1);
                }
                if(val > max) {
                    max = val;
                }
            }
            return max;
        } else {
            int min = Integer.MAX_VALUE;
            List<Board> posibleMoves = getAllMoves(board, 0);
            for(Board b : posibleMoves) {
                int val;
                if(b.getExtra()) {
                    val = minimax(b, 0, depth - 1);
                } else {
                    val = minimax(b, 1, depth - 1);
                }
                if(val < min) {
                    min = val;
                }
            }
            return min;
        }
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
            newBoard.setHeuristic(newBoard.heuristic(player));
            if (extra) {
                newBoard.setHeuristic(newBoard.getHeuristic() + 10);
            }
            int nextPlayer = (extra) ? player : 1 - player;
            int value = minimax(newBoard, nextPlayer, depth - 1);
            if (value > bestValue) {
                bestValue = value;
                bestMove = i;
            }
        }

        return bestMove + 1;
    }

}
