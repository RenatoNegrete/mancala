public class Board {
    private Pit[][] pits;
    private int turn;

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
        this.turn = 0;
    }

    public boolean finished() {
        boolean isFinished = true;
        for (int i = 0; i < 6; i++) {
            if (pits[0][i].getRocks() != 0) {
                isFinished = false;
            }
        }
        if (!isFinished) {
            return isFinished;
        }
        for (int i = 0; i < 6; i++) {
            if (pits[1][i].getRocks() != 0) {
                isFinished = false;
            }
        }
        if (!isFinished) {
            return isFinished;
        }
        return false;
    }

    public void showBoard() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Player 2");
        System.out.println("      A   B   C   D   E   F");
        System.out.println("|---|------------------------|---|");
        System.out.print("    ");
        for (int i = 5; i >= 0; i--) {
            System.out.print("| " + pits[0][i].getRocks() + " ");
        }
        System.out.println();
        System.out.println("| " + pits[0][6].getRocks() +" |------------------------| " + pits[1][6].getRocks() + " |");
        System.out.print("    ");
        for (int i = 0; i < 6; i++) {
            System.out.print("| " + pits[0][i].getRocks() + " ");
        }
        System.out.println();
        System.out.println("|---|------------------------|---|");
        System.out.println("      A   B   C   D   E   F");
        System.out.println("Player 1");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
