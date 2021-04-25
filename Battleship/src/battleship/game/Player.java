package battleship.game;

import battleship.game.ships.Ship;

import java.util.ArrayList;

public class Player {

    private final ArrayList<Ship> boats;
    private final String name;
    private final Board board;
    private int boatsLeft;
    Boolean winner = false;

    public Player(String name){
        this.boats = new FleetMaker().getInstance();
        this.name = name;
        this.board = createBoard();
        this.boatsLeft = boats.size();
    }

    public Board createBoard() {
        return new Board();
    }

    public ArrayList<Ship> getBoats() {
        return boats;
    }

    public Board.Symbol[][] getPlayerBoard(){
        return board.getBoard();
    }

    public void printPlayerBoard() {
        board.printBoard();
    }

    public void printOpponentBoard() {
        board.printOpponentView();
    }

    public String getName() {
        return name;
    }

    public void setWinner() {
        winner = true;
    }

    public Boolean getWinner() {
        return winner;
    }

    public int getBoatsLeft() { return boatsLeft; }

    public void removeBoat() {
        boatsLeft -= 1;
    }
}
