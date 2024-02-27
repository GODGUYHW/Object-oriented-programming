package LabOop.Lab3.BoardGame;

public class board {
    int rows = 8, columns = 8;
    figure[][] setFigures;
    char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

    public board() {
        this.setFigures = new figure[rows][columns];
        setFigures[1][1] = new pawn("P", "black", 1, 1);
        setFigures[3][5] = new pawn("Queen", "white", 1, 3);
        setFigures[0][2] = new Bishop("b", "white", 0, 2);
    }

    // add figure
    public void addFigure(figure figure) {
        int setRow = figure.getRow() - 1;
        int setColumn = figure.getColumns() - 1;
        if (!validatePosition(setRow, setColumn)) {
            if (setFigures[setRow][setColumn] != null) {
                System.out.println("Can't add figure to occupied position.");
                return;
            }
        } else {
            setFigures[setRow][setColumn] = figure;
        }

    }

    Object getPiece(int row, int column) {
        if (setFigures[row][column] == null) {
            return null;
        } else {
            return 1;
        }
    }

    public boolean validatePosition(int row, int column) {
        return row > 0 && row <= rows && column > 0 && column <= columns;
    }

    public void move(String figureName, String locations) {
        int moveRow = 0;
        int moveColumns = 0;

        // turn first string into int
        char toInt = locations.charAt(0);
        if (toInt >= 'a' && toInt <= 'h') {
            moveColumns = moveColumns * 16 + (toInt - 'a' + 1);
        } else {
            System.out.println("Invalid character: " + toInt + "!!!");
            return;
        }

        // turn second character into int
        toInt = locations.charAt(1);
        if (toInt >= '0' && toInt <= '8') {
            moveRow = moveRow * 16 + (toInt - '0');
        } else {
            System.out.println("Invalid character: " + toInt + "!!!");
            return;
        }
        figure destinationFigure = setFigures[moveRow - 1][moveColumns - 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                figure currentFigure = setFigures[i][j];
                if (currentFigure != null && currentFigure.getName().toLowerCase().equals(figureName.toLowerCase())) {
                    if (destinationFigure != null && currentFigure.moveCondition(destinationFigure, locations, this)) {
                        setFigures[i][j] = null;
                        currentFigure.setNewLocation(moveRow - 1, moveColumns - 1);
                        setFigures[moveRow - 1][moveColumns - 1] = currentFigure;
                    } else if (destinationFigure == null
                            && currentFigure.moveCondition(destinationFigure, locations, this)) {
                        setFigures[i][j] = null;
                        currentFigure.setNewLocation(moveRow - 1, moveColumns - 1);
                        setFigures[moveRow - 1][moveColumns - 1] = currentFigure;
                    } else {
                        if (destinationFigure != null
                                && !currentFigure.moveCondition(destinationFigure, locations, this)) {
                            System.out.println("Can not move to the place that has the same color");
                            return;
                        } else {
                            System.out.println("Invalid Move for " + currentFigure.getName());
                            return;
                        }

                    }
                }
            }
        }
    }

    // displayboard
    public void boardDisplay() {
        System.out.print("   ");
        for (int i = 0; i < columns; i++) {
            System.out.print("    ");
            System.out.print(letters[i]);
        }
        System.out.println();
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            System.out.print(" |");
            for (int j = 0; j < columns; j++) {
                System.out.print("   ");
                figure a = setFigures[i][j];
                if (a != null && a.getColor()) {
                    System.out.print("W" + a.getName().charAt(0));
                } else if (a != null && !a.getColor()) {
                    System.out.print("B" + a.getName().charAt(0));
                } else {
                    System.out.print("xx");
                }
            }
            System.out.print(" |");
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
    }
}
