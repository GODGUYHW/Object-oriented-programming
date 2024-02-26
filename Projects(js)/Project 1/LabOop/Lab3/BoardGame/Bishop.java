package LabOop.Lab3.BoardGame;

public class Bishop extends figure {

    public Bishop(String name, String color, int row, int columns) {
        super(name, color, row, columns);
    }

    @Override
    public boolean moveCondition(figure a, String locations, board board) {
        int moveRow = 0;
        int moveColumns = 0;

        // turn first string into int
        char toInt = locations.charAt(0);
        if (toInt >= 'a' && toInt <= 'h') {
            moveColumns = moveColumns * 16 + (toInt - 'a' + 1) - 1;
        } else {
            return false;
        }

        // turn second character into int
        toInt = locations.charAt(1);
        if (toInt >= '0' && toInt <= '8') {
            moveRow = moveRow * 16 + (toInt - '0') - 1;
        } else {
            return false;
        }
        if (a != null && this.getColor() == a.getColor()) {
            return false;
        } else if (Math.abs(this.row - moveRow) != Math.abs(this.columns - moveColumns)) {
            return false;
        } else {
            return true;
        }

    }

}
