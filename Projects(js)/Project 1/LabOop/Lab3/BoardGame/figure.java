package LabOop.Lab3.BoardGame;

public class figure {
    String name;
    int row, columns;
    int BLACK = 0;
    int WHITE = 1;
    int color;

    public figure(String name, int color, int row, int columns) {
        this.name = name;
        this.row = row;
        this.columns = columns;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getColumns() {
        return columns;
    }

    public boolean getColor() {
        if (color == WHITE) {
            return true;
        } else {
            return false;
        }
    }

}
