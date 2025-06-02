/************************************************************
 * Pontificia Universidad Javeriana
 * Analisis de algoritmos
 * Autores: Sergio Cuellar, Diego Villabon y Renaro Negrete
*************************************************************/

import java.util.Scanner;

public class Mancala {
    private Board board;
    private Player[] players;
    private int playerTurn;

    public Mancala() {
        this.board = new Board();
        this.players = new Player[2];
        this.playerTurn = 1;
    }

    public void gameMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            System.out.println("==================");
            System.out.println("Welcome to MANCALA");
            System.out.println("==================");
            System.out.println("1. Play");
            System.out.println("2. Exit");
            System.out.print("Choose an opcion: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("1. Player vs Player");
                    System.out.println("2. Player vs Computer");
                    System.out.println("Choose a game mode: ");
                    int opt = scanner.nextInt();
                    scanner.nextLine();
                    switch (opt) {
                        case 1:
                            System.out.println("Player 1 enter your name: ");
                            String p1 = scanner.nextLine();
                            System.out.println("Player 2 enter your name: ");
                            String p2 = scanner.nextLine();
                            this.players[0] = new HumanPlayer(p2);
                            this.players[1] = new HumanPlayer(p1);
                            beginGame(0);
                            break;
                        case 2:
                            System.out.println("Player 1 enter yout name: ");
                            String pH = scanner.nextLine();
                            String pR = "Computer";
                            this.players[0] = new AIPlayer(pR);
                            this.players[1] = new HumanPlayer(pH);
                            beginGame(6);
                            break;
                        default:
                            System.out.println("Invalid option, try again");
                            break;
                    }
                    break;
                case 2:
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    break;
            }
        }
        scanner.close();
    }

    public void beginGame(int depth) {
        System.out.println("\n==================");
        System.out.println("The game has begun");
        System.out.println("==================");
    
        while (!board.finished()) {
            board.showBoard(this.players[1].getName(), this.players[0].getName());
    
            System.out.println("It's Player " + this.players[this.playerTurn].getName() + " turn");
            int pitIndex = this.players[this.playerTurn].chooseMove(this.board, this.playerTurn, depth);
            System.out.println("Chosen move: " + pitIndex);

            if(pitIndex < 1 || pitIndex > 6) {
                System.out.println("Invalid position, choose one from 1 to 6");
                continue;
            }
            pitIndex--;
    
            Pit selectedPit = this.board.getPit(this.playerTurn, pitIndex);
            if (selectedPit.getRocks() == 0) {
                System.out.println("The choosen pit is empty, choose anoter one");
                continue;
            }

            boolean extraTurn = this.board.moveRocks(pitIndex, this.playerTurn);
            if(!extraTurn) {
                this.playerTurn = 1 - this.playerTurn;
            }

        }
    
        this.board.showBoard(this.players[1].getName(), this.players[0].getName());
        int winner = this.board.getWinner();
        System.out.println("=======================================");
        System.out.println("The winner is Player " + players[winner].getName());
        System.out.println("=======================================");
    }

    
    public static void main(String[] args) {
        Mancala game = new Mancala();
        game.gameMenu();
    }
}
