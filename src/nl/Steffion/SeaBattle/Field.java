package nl.Steffion.SeaBattle;

import java.util.HashMap;

public class Field {
	private HashMap<String, Square> grid;

	public Field() {
		grid = new HashMap<String, Square>();
		for (char horizontal = 'A'; horizontal <= 'J'; horizontal++) {
			for (int vertical = 10; vertical >= 0; vertical--) {
				grid.put(horizontal + vertical + "", new Square());
			}
		}
	}
	
	public void print() {
		
	}
	
	public void fired() {
		
	}
	
	public void allShipsSunk() {

	public void print() {
		// TODO print field
		for (int vertical = 10; vertical >= 1; vertical--) {
			if (vertical == 10) {
				System.out.print(vertical);
			} else {
				System.out.print(vertical + " ");
			}
			
			for (char horizontal = 'A'; horizontal <= 'J'; horizontal++) {
				if (grid.get(horizontal + vertical + "").getShip() != null) {
					System.out.print(" " + grid.get(horizontal + vertical + "").getShip().getTypeShip());
				} else {
					System.out.print(" .");
				}
			}
			
			System.out.println();
		}
		
		System.out.println("   A B C D E F G H I J");
	}
}
