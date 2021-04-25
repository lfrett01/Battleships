package battleship.game.ships;

import java.util.ArrayList;

public class AircraftCarrier implements Ship {

    private final ArrayList<int[]> coordinates;
    private int lives;
    private final int size;
    private final String name;

    public AircraftCarrier() {
        this.name = "Aircraft Carrier";
        this.size = 5;
        this.coordinates = new ArrayList<>();
        this.lives = 5;
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
