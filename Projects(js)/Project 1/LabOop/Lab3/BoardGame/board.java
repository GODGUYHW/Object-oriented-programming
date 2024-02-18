package LabOop.Lab3.BoardGame;

public class board {
    int position1, position2;
    int rows = 8, columns = 8;
    char[][] board = new char[rows][columns];
    figure player1, player2;
    char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };

    public void setBoard(figure player1, figure player2) {
        if (player1.getRow() == player2.getRow() && player1.getColumns() == player2.getColumns()) {
            System.out.print("Can not place 2 figures at the same place");
            System.exit(0);
        } else if (player1.getRow() == 0 || player2.getRow() == 0 || player1.getRow() < 0
                || player2.getRow() < 0) {
            System.out.print("Board Start at 1");
            System.exit(0);
        } else if (player1.getColumns() == 0 || player2.getColumns() == 0 || player1.getColumns() < 0
                || player2.getColumns() < 0) {
            System.out.print("Board Start at 1");
            System.exit(0);
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (player1.getRow() == i && player1.getColumns() == j) {
                        board[i][j] = player1.getName().charAt(0);
                    } else if (player2.getRow() == i && player2.getColumns() == j) {
                        board[i][j] = player2.getName().charAt(0);
                    } else {
                        board[i][j] = '-';
                    }
                }
            }
            System.out.print("   ");
            for (int i = 0; i < columns; i++) {
                System.out.print(" ");
                System.out.print(letters[i]);
            }
            System.out.println();
            System.out.println("----------------------------");
            for (int i = 0; i < rows; i++) {
                System.out.print(i + 1);
                System.out.print(" |");
                for (int j = 0; j < columns; j++) {
                    System.out.print(" ");
                    System.out.print(board[i][j]);
                }
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("----------------------------");
        }
    }

    public void freeMove(figure player, String locations) {
        int moveRow = 0;
        int moveColumns = 0;
        char toInt = locations.charAt(0);
        if (toInt >= 'a' && toInt <= 'h') {
            moveColumns = moveColumns * 16 + (toInt - 'a' + 1);
        } else {
            System.out.println("Invalid character: " + toInt);
            return;
        }

        toInt = locations.charAt(1);
        if (toInt >= '0' && toInt <= '8') {
            moveRow = moveRow * 16 + (toInt - '0');
        } else {
            System.out.println("Invalid character: " + toInt);
            return;
        }
        board[player.getRow()][player.getColumns()] = '-';
        board[moveRow - 1][moveColumns - 1] = player.getName().charAt(0);
        boardDisplay();
    }

    public void boardDisplay() {
        System.out.print("   ");
        for (int i = 0; i < columns; i++) {
            System.out.print(" ");
            System.out.print(letters[i]);
        }
        System.out.println();
        System.out.println("----------------------------");
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            System.out.print(" |");
            for (int j = 0; j < columns; j++) {
                System.out.print(" ");
                System.out.print(board[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("----------------------------");
    }
}
