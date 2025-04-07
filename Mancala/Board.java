public class Board {
    private Pit[][] pits;
    private int turn;

    public Board() {
        this.pits = new Pit[2][7];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 6) {
                    pits[i][j] = new Pit(true);
                } else {
                    pits[i][j] = new Pit(false);
                }
            }
        }
        this.turn = 0;
    }

    public void showBoard() {
        System.out.println("Player 1: " + pits[0][6].getRocks() + " | Player 2: " + pits[1][6].getRocks());
        for (int i = 0; i < 6; i++) {
            System.out.print(pits[0][i].getRocks() + " ");
        }
        System.out.println();
        for (int i = 5; i >= 0; i--) {
            System.out.print(pits[1][i].getRocks() + " ");
        }
        System.out.println();
    }
}
