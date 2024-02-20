package LabOop.Lab3.BoardGame;

public class main {
    public static void main(String[] args) {
        board b = new board();
        figure player1 = new figure("Queen", "white", 2, 4, b);
        figure player2 = new figure("Pawn", "white", 4, 1, b);
        figure player3 = new figure("King", "black", 2, 8, b);
        b.boardDisplay();
        b.addFigure(player1);
        b.addFigure(player2);
        b.addFigure(player3);
        b.boardDisplay();
        player2.freeMove("h7");
        player1.freeMove("h7");
        player3.freeMove("h7");
    }
}
