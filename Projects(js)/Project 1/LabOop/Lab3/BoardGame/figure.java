package LabOop.Lab3.BoardGame;

public class figure {
    String name;
    int row, columns;
    int BLACK = 0;
    int WHITE = 0;
    String color;

    public figure(String name, String color, int row, int columns) {
        this.name = name;
        this.row = row;
        this.columns = columns;
        this.color = color;
        if (color.toLowerCase() == "white") {
            WHITE = 1;
        } else if (color.toLowerCase() == "black") {
            BLACK = 1;
        } else if (color.toLowerCase() != "white" || color.toLowerCase() != "black") {
            System.out.println("Enter only white or black");
            System.exit(0);
        }
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
        if (WHITE == 1) {
            return true;
        } else {
            return false;
        }
    }

}
