package nl.Steffion.SeaBattle.shiptypes;

import nl.Steffion.SeaBattle.Ship;

public class Submarine extends Ship {
    public Submarine(boolean goesHorizontal) {
        super(goesHorizontal);
        setLength(3);
    }

    public char getTypeShip() {
        return 'S';
    }
}
