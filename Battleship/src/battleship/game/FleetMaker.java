package battleship.game;

import battleship.game.ships.*;

import java.util.ArrayList;

public class FleetMaker extends ArrayList<Ship> {

    static ArrayList<Ship> boats;

    public FleetMaker(){
        boats = new ArrayList<>();
        createBoats();
    }

    private void createBoats() {
        AircraftCarrier aircraft = new AircraftCarrier();
        BattleShip battleShip = new BattleShip();
        Ship cruiser = new Cruiser();
        Ship destroyer = new Destroyer();
        Ship submarine = new Submarine();

        boats.add(aircraft);
        boats.add(battleShip);
        boats.add(submarine);
        boats.add(cruiser);
        boats.add(destroyer);
    }

    ArrayList<Ship> getInstance(){
        return boats;
    }
}
