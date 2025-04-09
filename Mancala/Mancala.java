import java.util.Scanner;

public class Mancala {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public Mancala() {
        this.board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player(0);
        this.players[1] = new Player(1);
        this.currentPlayerIndex = 0;
    }

    public void gameMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    startGame();
                    break;
                case 2:
                    playing = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    public void startGame() {
        System.out.println("El juego Mancala ha comenzado.");
        while(!board.finished()) {
            board.showBoard();    
        }
        
    }

    public static void main(String[] args) {
        Mancala game = new Mancala();
        game.gameMenu();
    }
}
