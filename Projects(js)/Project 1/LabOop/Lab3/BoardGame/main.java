package LabOop.Lab3.BoardGame;

public class main {
    public static void main(String[] args) {
        board b = new board();
        b.boardDisplay();
        // b.move("2", "b5");
        b.move("b", "b5");
        b.boardDisplay();
        b.move("b", "b4");
        b.move("b", "b3");
        b.move("b", "a2");
        b.boardDisplay();
        b.move("b", "a1");
        b.boardDisplay();
        b.move("b", "b2");
        b.boardDisplay();
        b.move("b", "h8");
        b.boardDisplay();
    }
}
