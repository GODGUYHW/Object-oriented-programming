package LabOop.Lab3.BoardGame;

public class main {
    // Black = 0 , White = 1
    public static void main(String[] args) {
        figure player1 = new figure("Queen", 0, 2, 4);
        figure player2 = new figure("Pawn", 1, 4, 1);
        figure player3 = new figure("King", 1, 2, 8);
        board b = new board();
        b.addFigure(player1);
        b.addFigure(player2);
        b.addFigure(player3);
        b.boardDisplay();
        b.freeMove(player1, "a2");
        b.freeMove(player2, "a2");
        b.freeMove(player3, "a2");
    }
}
