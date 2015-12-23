package nl.Steffion.SeaBattle.shiptypes;

import nl.Steffion.SeaBattle.Ship;

public class PatrolBoat extends Ship {
    public PatrolBoat(boolean goesHorizontal) {
        super(goesHorizontal);
        setLength(2);
    }

    public char getTypeShip() {
        return 'P';
    }
}
