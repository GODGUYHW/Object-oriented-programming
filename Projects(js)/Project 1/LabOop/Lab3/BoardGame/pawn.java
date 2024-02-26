package LabOop.Lab3.BoardGame;

public class pawn extends figure {

    public pawn(String name, String color, int row, int columns) {
        super(name, color, row, columns);
    }

    @Override
    public boolean moveCondition(figure a, String locations, board board) {
        return false;
    }

}
