/************************************************************
 * Pontificia Universidad Javeriana
 * Analisis de algoritmos
 * Autores: Sergio Cuellar, Diego Villabon y Renaro Negrete
*************************************************************/

import java.util.Scanner;

public class HumanPlayer implements Player {

    private String name;
    private Scanner scanner;

    public HumanPlayer(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int chooseMove(Board board, int player, int depth) {
        int pit;
        System.out.println("Choose a pit (1-6): ");
        pit = scanner.nextInt();
        return pit;
    }

}
