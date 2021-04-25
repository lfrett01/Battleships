package battleship.game;

import battleship.game.ships.Ship;

import java.io.IOException;
import java.util.ArrayList;

public class Game {


    private final Player[] players;
    private boolean gameOver;
    private int turn;

    public Game(){

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        this.players = new Player[]{player1, player2};
        this.gameOver = false;
        this.turn = 0;

    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playGame(){
        // set up the boards for each player
        for (Player player: players){
            System.out.println(player.getName() + ", place your ships on the game field");
            BoardSetup.startGame(player);
            promptEnterKey();
            System.out.println("...");
        }

        // play the game
        while (!gameOver){
            Player currentPlayer = players[turn];
            Player opponent = players[(turn+1) %2];

            opponent.printOpponentBoard();
            System.out.println("-----------------------------------------");
            currentPlayer.printPlayerBoard();

            System.out.println("\n" + currentPlayer.getName() + ", it's your turn:");

            takeShot(opponent);
            if (opponent.getBoatsLeft() == 0){
                currentPlayer.setWinner();
                gameOver = currentPlayer.getWinner();
                break;
            }
            promptEnterKey();
            turn = (turn + 1) % 2;
        }
        System.out.println("You sank the last ship. You won. \nCongratulations!");
    }


    private static void takeShot(Player opponent) {

        int[] move = getShot();
        int row = move[0];
        int column = move[1];
        Board.Symbol[][] board= opponent.getPlayerBoard();

        if (board[row][column].getSymbol().equals("O") | board[row][column].getSymbol().equals("X")){
            board[row][column] = Board.Symbol.HIT;

            for (Ship s: opponent.getBoats()) {
                ArrayList<int[]> boatCoordinates = s.getCoordinates();
                for (int[] co: boatCoordinates){
                    if (co[0] == row & co[1] == column){

                        s.loseLife();

                        if (s.getLives() == 0){
                            System.out.println("You sank a ship!");
                            opponent.removeBoat();
                            System.out.println(opponent.getBoatsLeft());
                        } else {
                            System.out.println("You hit a ship!");
                        }
                        return;
                    }
                }
            }
        } else {
            board[row][column] = Board.Symbol.MISS;
            System.out.println("You missed!");
        }
    }

    private static int[] getShot() {
        String move = GetMove.getMove();
        int row = (int) move.charAt(0) - 65;
        int column = Integer.parseInt(move.substring(1)) - 1;
        if (row < 0 | column < 0 | row > 9 | column > 9){
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return getShot();
        }
        return new int[]{row, column};
    }
}
