package battleship.game.ships;

import java.util.ArrayList;

public interface Ship {

    public int getSize();
    public String getName();
    public void setCoordinates(int[] coordinate);
    public ArrayList<int[]> getCoordinates();
    public void loseLife();
    public void removeCoordinate(int[] coordinate);
    public int getLives();
}
