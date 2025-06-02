public interface Player {

    String getName();
    int chooseMove(Board board, int player, int depth);

}