package nl.Steffion.SeaBattle.shiptypes;

import nl.Steffion.SeaBattle.Ship;

public class AircraftCarrier extends Ship {
    public AircraftCarrier(boolean goesHorizontal) {
        super(goesHorizontal);
        setLength(5);
    }

    public char getTypeShip() {
        return 'A';
    }
}
