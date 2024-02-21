package LabOop.Lab3.BoardGame;

public class figure {
    String name;
    int row, columns;
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

    public void setNewLocation(int newRow, int newColumn) {
        this.row = newRow;
        this.columns = newColumn;
    }

    public boolean getColor() {
        if (WHITE == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean freeMove(figure a, String locations, board board) {
        int moveRow = 0;
        int moveColumns = 0;

        // turn first string into int
        char toInt = locations.charAt(0);
        if (toInt >= 'a' && toInt <= 'h') {
            moveColumns = moveColumns * 16 + (toInt - 'a' + 1);
        } else {
            System.out.println("Invalid character: " + toInt + "!!!");
            return false;
        }

        // turn second character into int
        toInt = locations.charAt(1);
        if (toInt >= '0' && toInt <= '8') {
            moveRow = moveRow * 16 + (toInt - '0');
        } else {
            System.out.println("Invalid character: " + toInt + "!!!");
            return false;
        }
        if (this.getColor() == a.getColor()) {
            System.out.println("Can not move to this place");
            return false;
        } else if (!board.validatePosition(moveRow, moveColumns)) {
            return false;
        } else {
            return true;
        }

    }

}
