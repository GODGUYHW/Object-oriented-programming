package LabOop.Lab3.BoardGame;

public class pawn extends figure {

    public pawn(String name, String color, int row, int columns) {
        super(name, color, row, columns);
    }

    private boolean isFirstMove() {
        if (this.color.toLowerCase().equals("white") && this.row == 6) {
            return true;
        } else if (this.color.toLowerCase().equals("black") && this.row == 1) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * public boolean checkPromotion() {
     * if (this.getColor() && this.getRow() == 0) {
     * return true;
     * } else if (!this.getColor() && this.getRow() == 7) {
     * return true;
     * } else {
     * return false;
     * }
     * }
     * 
     * public void promote(String newPieceName, board board) {
     * switch (newPieceName.toLowerCase()) {
     * case "bishop":
     * Bishop newBishop = new Bishop("Bishop", this.getColor() ? "white" : "black",
     * this.row, this.columns);
     * board.setPiece(this.row, this.columns, newBishop);
     * break;
     * default:
     * System.out.println("Invalid piece name for promotion!");
     * break;
     * }
     * }
     */

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

        int distance = Math.abs(moveRow - this.row);
        int distanceCol = Math.abs(moveColumns - this.columns);
        if (this.getColor()) {
            if (isFirstMove() && distance == 2 && board.getPiece(moveRow, moveColumns) == null) {
                return true;
            } else if (distance == 1 && board.getPiece(moveRow, moveColumns) == null && moveRow < this.row) {
                return true;
            } else if (distance == 1 && distanceCol == 1 && board.getPiece(moveRow, moveColumns) != null && a != null
                    && moveRow < this.row) {
                if (this.getColor() && a.getColor()) {
                    return false;
                } else {
                    return true;
                }
            } else if (moveRow == this.row) {
                return false;
            } else {
                return false;
            }
        } else {
            if (isFirstMove() && distance == 2 && board.getPiece(moveRow, moveColumns) == null) {
                return true;
            } else if (distance == 1 && board.getPiece(moveRow, moveColumns) == null && moveRow > this.row) {
                return true;
            } else if (distance == 1 && distanceCol == 1 && board.getPiece(moveRow, moveColumns) != null && a != null
                    && moveRow > this.row) {
                if (this.getColor() == a.getColor()) {
                    return false;
                } else {
                    return true;
                }
            } else if (moveRow == this.row) {
                return false;
            } else {
                return true;
            }
        }
    }
}
