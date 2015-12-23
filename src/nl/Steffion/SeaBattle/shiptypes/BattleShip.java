package nl.Steffion.SeaBattle.shiptypes;

import nl.Steffion.SeaBattle.Ship;

public class BattleShip  extends Ship {
	public BattleShip(boolean goesHorizontal) {
		super(goesHorizontal);
		setLength(4);
	}
	
	public char getTypeShip() {
		return 'B';
	}
}
