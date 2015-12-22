package nl.Steffion.SeaBattle.shiptypes;

import nl.Steffion.SeaBattle.Ship;

public class Destroyer extends Ship {
	public Destroyer() {
		setLength(3);
	}
	
	public char getTypeShip() {
		return 'D';
	}
}
