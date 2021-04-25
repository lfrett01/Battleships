package battleship.game.ships;

import java.util.ArrayList;

public class Submarine implements battleship.game.ships.Ship {
    private final ArrayList<int[]> coordinates;
    private int lives;
    private final int size;
    private final String name;

    public Submarine() {
        this.name = "Submarine";
        this.size = 3;
        this.coordinates = new ArrayList<>();
        this.lives = 3;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCoordinates(int[] coordinate) { coordinates.add(coordinate); }

    @Override
    public ArrayList<int[]> getCoordinates() { return coordinates; }

    @Override
    public void loseLife() { lives -= 1; }

    @Override
    public void removeCoordinate(int[] coordinate) { coordinates.remove(coordinate); }

    @Override
    public int getLives() { return lives; }
}
