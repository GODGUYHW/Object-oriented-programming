package LabOop.Lab3.BoardGame;

import java.util.ArrayList;
import java.util.List;

public class board {
    int rows = 8, columns = 8;
    public String[][] board;
    public List<figure> figures;
    char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

    public board() {
        board = new String[rows][columns];
        figures = new ArrayList<>();
        initializeBoard();
    }

    // set null in board
    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "xx";
            }
        }
    }

    // add figure
    public void addFigure(figure figure) {
        if (validatePosition(figure.getRow(), figure.getColumns())) {
            if (isOccupied(figure.getRow(), figure.getColumns())) {
                System.out.println("Can't add figure to occupied position.");
                return;
            }
            figures.add(figure);
            updateBoard(figure);
        } else {
            System.out.println("Invalid position. Board starts at 1 and is within 1-" + rows + ", 1-" + columns);
        }
    }

    // check the right position
    private boolean validatePosition(int row, int column) {
        return row > 0 && row <= rows && column > 0 && column <= columns;
    }

    // check is empty
    private boolean isOccupied(int row, int column) {
        for (figure figure : figures) {
            if (figure.getRow() == row && figure.getColumns() == column) {
                return true;
            }
        }
        return false;
    }

    public void getMove(figure player, int row, int column) {
        if (player.getColor() == true && board[row - 1][column - 1].charAt(0) == 'W') {
            System.out.println("Can not move to that place");
            return;
        } // check is it black and same color
        else if (player.getColor() == false && board[row - 1][column - 1].charAt(0) == 'B') {
            System.out.println("Can not move to that place");
            return;
        } else if (player.getColor() == true) {
            board[player.getRow() - 1][player.getColumns() - 1] = "xx";
            board[row - 1][column - 1] = "W" + player.getName().substring(0, 1);
            boardDisplay();
        } else if (player.getColor() == false) {
            board[player.getRow() - 1][player.getColumns() - 1] = "xx";
            board[row - 1][column - 1] = "B" + player.getName().substring(0, 1);
            boardDisplay();
        }
    }

    // update board
    private void updateBoard(figure figure) {
        String symbol = figure.getColor() ? "W" + figure.getName().substring(0, 1)
                : "B" + figure.getName().substring(0, 1);
        board[figure.getRow() - 1][figure.getColumns() - 1] = symbol;
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
                System.out.print(board[i][j]);
            }
            System.out.print(" |");
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
    }
}
