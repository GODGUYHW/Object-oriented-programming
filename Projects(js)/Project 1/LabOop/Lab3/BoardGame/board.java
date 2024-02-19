package LabOop.Lab3.BoardGame;

public class board {
    int position1, position2;
    int rows = 8, columns = 8;
    String[][] board = new String[rows][columns];
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
                    if (player1.getRow() - 1 == i && player1.getColumns() - 1 == j) {
                        board[i][j] = player1.getColor() ? "W" + player1.getName().substring(0, 1)
                                : "B" + player1.getName().substring(0, 1);
                    } else if (player2.getRow() - 1 == i && player2.getColumns() - 1 == j) {
                        board[i][j] = player2.getColor() ? "W" + player2.getName().substring(0, 1)
                                : "B" + player1.getName().substring(0, 1);
                    } else {
                        board[i][j] = "xx";
                    }
                }
            }
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

    public void freeMove(figure player, String locations) {
        int moveRow = 0;
        int moveColumns = 0;
        int isWhite = 0;
        int isBlack = 0;

        // turn string into int first character
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
        if (player.getColor() == true && board[moveRow - 1][moveColumns - 1].charAt(0) == 'W') {
            System.out.println("Can not move to that place");
            return;
        } else if (player.getColor() == false && board[moveRow - 1][moveColumns - 1].charAt(0) == 'B') {
            System.out.println("Can not move to that place");
            return;
        } else if (player.getColor() == true) {
            board[player.getRow() - 1][player.getColumns() - 1] = "xx";
            board[moveRow - 1][moveColumns - 1] = "W" + player.getName().substring(0, 1);
            boardDisplay();
        } else if (player.getColor() == false) {
            board[player.getRow() - 1][player.getColumns() - 1] = "xx";
            board[moveRow - 1][moveColumns - 1] = "B" + player.getName().substring(0, 1);
            boardDisplay();
        }
    }

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
