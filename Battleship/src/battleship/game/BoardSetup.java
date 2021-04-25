package battleship.game;

import battleship.game.ships.Ship;

public class BoardSetup {

    static void startGame(Player player) {

        player.printPlayerBoard();

        for (Ship s : player.getBoats()) {
            System.out.println("\nEnter the coordinates of the " + s.getName() + " (" + s.getSize() + " cells):");
            int[] moves = getPlacement(s, player.getPlayerBoard());
            placeShip(moves, player.getPlayerBoard(), s);
            player.printPlayerBoard();
        }
    }

    private static int[] getPlacement(Ship s, Board.Symbol[][] board) {

        String move1 = GetMove.getMove();
        String move2 = GetMove.getMove();

        int boatSize = s.getSize();
        int row1 = (int) move1.charAt(0) - 65;
        int row2 = (int) move2.charAt(0) - 65;
        int column1 = Integer.parseInt(move1.substring(1)) - 1;
        int column2 = Integer.parseInt(move2.substring(1)) - 1;

        if (checkValidPlacement(row1, column1, row2, column2, boatSize, board, s.getName())) {
            return new int[]{row1, column1, row2, column2};
        } else {
            return getPlacement(s, board);
        }
    }

    private static void placeShip(int[] moves, Board.Symbol[][] board, Ship s) {
        if (moves[0] == moves[2]) {
            for (int i = Math.min(moves[1], moves[3]); i < Math.max(moves[1], moves[3]) + 1; i++) {
                board[moves[0]][i] = Board.Symbol.BOAT;

                int[] coordinates = {moves[0], i};
                s.setCoordinates(coordinates);
            }
        }
        if (moves[1] == moves[3]) {
            for (int i = Math.min(moves[0], moves[2]); i < Math.max(moves[0], moves[2]) + 1; i++) {
                board[i][moves[1]] = Board.Symbol.BOAT;

                int[] coordinates = {i, moves[1]};
                s.setCoordinates(coordinates);
            }
        }
    }

    private static boolean checkValidPlacement(int row1, int column1, int row2, int column2, int boatSize, Board.Symbol[][] board, String name) {
        if (row1 != row2 && column1 != column2) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        if (Math.abs(row1 - row2) != boatSize - 1 && Math.abs(column1 - column2) != boatSize - 1) {
            System.out.println("Error! Wrong length of the " + name + "! Try again:");
            return false;
        }
        if (column1 == column2) {

            int small = Math.min(row1, row2);
            int big = Math.max(row1, row2);

            // check square above boat is free
            if (small - 1 >= 0) {
                if (board[small - 1][column1].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                }
            }
            // check square below boat is free
            if (big + 1 < 10) {
                if (board[big + 1][column1].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                }
            }
            // checks squares on either side and where boat to be placed are free
            for (int i = small; i < big + 1; i++) {

                if (board[i][column1].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                } else if (board[i][Math.max(column1 - 1, 0)].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                } else if (board[i][Math.min(column1 + 1, 9)].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                }
            }
        }

        if (row1 == row2) {

            int small = Math.min(column1, column2);
            int big = Math.max(column1, column2);

            // check square above boat is free
            if (small - 1 >= 0) {
                if (board[row1][small - 1].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                }
            }
            // check square below boat is free
            if (big + 1 < 10) {
                if (board[row1][big + 1].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                }
            }
            // checks squares on either side and where boat to be placed are free
            for (int i = small; i < big + 1; i++) {

                if (board[row1][i].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                } else if (board[Math.max(row1 - 1, 0)][i].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                } else if (board[Math.min(row1 + 1, 9)][i].getSymbol().equals("O")) {
                    System.out.println("Error! You placed it too close to another one. Try again: \n");
                    return false;
                }
            }
        }
        return true;
    }
}
