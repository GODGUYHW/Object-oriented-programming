package LabOop.Lab3.BoardGame;

public class main {
    public static void main(String[] args) {
        figure player1 = new figure("Queen", "white", 2, 4);
        figure player2 = new figure("Pawn", "white", 4, 1);
        figure player3 = new figure("King", "black", 2, 8);
        board b = new board();
        b.boardDisplay();
        b.addFigure(player1);
        b.addFigure(player2);
        b.addFigure(player3);
        b.boardDisplay();
        b.freeMove(player1, "a2");
        b.freeMove(player2, "a2");
        b.freeMove(player3, "a2");
    }
}
