package LabOop.Lab3.BoardGame;

public class main {
    public static void main(String[] args) {
        board b = new board();
        b.boardDisplay();
        b.move("b", "a3");
        b.boardDisplay();
        b.move("b", "d2");
        b.boardDisplay();
        b.move("b", "e3");
        b.boardDisplay();
        b.move("b", "c1");
        b.boardDisplay();
        b.move("b", "b2");
        b.boardDisplay();
        b.move("b", "a1");
        b.boardDisplay();

    }
}
