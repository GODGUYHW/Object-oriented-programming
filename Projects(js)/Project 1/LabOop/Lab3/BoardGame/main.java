package LabOop.Lab3.BoardGame;

public class main {
    // Black = 0 , White = 1
    public static void main(String[] args) {
        figure[] figures = new figure[2];
        figures[0] = new figure("GUY", 0, 2, 4);
        figures[1] = new figure("BUY", 1, 4, 1);
        board b = new board();
        b.setBoard(figures[0], figures[1]);
        b.freeMove(figures[0], "b8");
        b.freeMove(figures[0], "h1");
    }
}
