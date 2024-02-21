package LabOop.Lab3.BoardGame;

public class main {
    public static void main(String[] args) {
        board b = new board();
        b.boardDisplay();
        b.move("p", "h4");
        b.boardDisplay();

        b.move("Queen", "h4");
        b.boardDisplay();
    }
}
