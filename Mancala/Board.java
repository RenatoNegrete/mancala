/************************************************************
 * Pontificia Universidad Javeriana
 * Analisis de algoritmos
 * Autores: Sergio Cuellar, Diego Villabon y Renaro Negrete
*************************************************************/

public class Board {
    private Pit[][] pits;
    private int heuristic;
    private boolean extra = false;

    public boolean getExtra() {
        return this.extra;
    }

    public void setExtra(boolean n) {
        this.extra = n;
    }

    public int getHeuristic() {
        return this.heuristic;
    }

    public void setHeuristic(int n) {
        this.heuristic = n;
    }

    public Board() {
        this.pits = new Pit[2][7];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 6) {
                    pits[i][j] = new Pit(0, true);
                } else {
                    pits[i][j] = new Pit(4, false);
                }
            }
        }
    }

    public Pit getPit(int row, int col) {
        return pits[row][col];
    }
    

    public boolean finished() {
        boolean player1Empty = true;
        boolean player2Empty = true;
    
        for (int i = 0; i < 6; i++) {
            if (pits[0][i].getRocks() != 0) {
                player1Empty = false;
            }
            if (pits[1][i].getRocks() != 0) {
                player2Empty = false;
            }
        }
    
        return player1Empty || player2Empty;
    }
    

    public void showBoard(String p1, String p2) {
        System.out.println("");
        System.out.println("");
        System.out.println("Player " + p2);
        System.out.println("      6   5   4   3   2   1");
        System.out.println("|---|------------------------|---|");
        System.out.print("|   ");
        for (int i = 5; i >= 0; i--) {
            System.out.print("| " + pits[0][i].getRocks() + " ");
        }
        System.out.print(" |   |");
        System.out.println();
        System.out.println("| " + pits[0][6].getRocks() +" |------------------------| " + pits[1][6].getRocks() + " |");
        System.out.print("|   ");
        for (int i = 0; i < 6; i++) {
            System.out.print("| " + pits[1][i].getRocks() + " ");
        }
        System.out.print(" |   |");
        System.out.println();
        System.out.println("|---|------------------------|---|");
        System.out.println("      1   2   3   4   5   6");
        System.out.println("Player " + p1);
        System.out.println("");
    }

    public int getWinner() {
        if(this.pits[0][6].getRocks() > this.pits[1][6].getRocks()) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean moveRocks(int pitIndex, int player) {
        int rocks = pits[player][pitIndex].getRocks();
        pits[player][pitIndex].clearPit();
    
        int currentSide = player;
        int currentIndex = pitIndex;
        boolean extraTurn = false;
    
        while (rocks > 0) {
            currentIndex++;
    
            if (currentIndex > 6) {
                currentIndex = 0;
                currentSide = 1 - currentSide;
            }
    
            if (currentIndex == 6 && currentSide != player) {
                continue;
            }
    
            pits[currentSide][currentIndex].addRock(1);
            rocks--;
        }
    
        if (currentSide == player && currentIndex == 6) {
            extraTurn = true;
        }
    
        if (currentSide == player && currentIndex >= 0 && currentIndex < 6 &&
            pits[currentSide][currentIndex].getRocks() == 1) {
    
            int oppositeIndex = 5 - currentIndex;
            int captured = pits[1 - player][oppositeIndex].getRocks();
            
            if (captured > 0) {
                pits[1 - player][oppositeIndex].clearPit();
                pits[player][6].addRock(captured);
            }
        }
    
        return extraTurn;
    }

    public int heuristic(int player) {
        int h = 0;
        int rival = (player == 0) ? 1 : 0;
        h += 5 * (this.pits[player][6].getRocks() - this.pits[rival][6].getRocks());
        int sumP = 0, sumR = 0;
        for(int i = 0; i < 6; i++) {
            sumP += this.pits[player][i].getRocks();
            sumR += this.pits[rival][i].getRocks();
        }
        h += 1 * (sumP - sumR);
        return h;
    }

    public Board copy() {
        Board newBoard = new Board();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                int rocks = this.pits[i][j].getRocks();
                boolean isStore = this.pits[i][j].isStorage();
                newBoard.pits[i][j] = new Pit(rocks, isStore);
            }
        }
        newBoard.setHeuristic(this.heuristic);
        return newBoard;
    }

}
