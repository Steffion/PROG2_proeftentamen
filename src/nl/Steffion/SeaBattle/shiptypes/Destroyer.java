package nl.Steffion.SeaBattle.shiptypes;

import nl.Steffion.SeaBattle.Ship;

public class Destroyer extends Ship {
	public Destroyer(boolean goesHorizontal) {
		super(goesHorizontal);
		setLength(3);
	}
	
	public char getTypeShip() {
		return 'D';
	}
}
