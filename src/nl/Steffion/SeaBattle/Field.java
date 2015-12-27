package nl.Steffion.SeaBattle;

import java.util.HashMap;
import java.util.Random;

import nl.Steffion.SeaBattle.shiptypes.AircraftCarrier;
import nl.Steffion.SeaBattle.shiptypes.BattleShip;
import nl.Steffion.SeaBattle.shiptypes.Destroyer;
import nl.Steffion.SeaBattle.shiptypes.PatrolBoat;
import nl.Steffion.SeaBattle.shiptypes.Submarine;

public class Field {
	private HashMap<String, Square> grid;
	
	public Field() {
		grid = new HashMap<String, Square>();
		for (Character horizontal = 'A'; horizontal <= 'J'; horizontal++) {
			for (int vertical = 10; vertical >= 0; vertical--) {
				String cell = horizontal.toString() + vertical;
				grid.put(cell, new Square());
			}
		}
	}
	
	public boolean allShipsSunk() {
		for (Square square : grid.values()) {
			if ((square.getShip() != null) && !square.getShip().hasSank()) {
				return false;
			}
		}

		return true;
	}
	
	public boolean oneShipSunk() {
		for (Square square : grid.values()) {
			if ((square.getShip() != null) && square.getShip().hasSank()) {
				return true;
			}
		}
		
		return false;
	}
	public void cheatPrint() {
		for (int vertical = 10; vertical >= 1; vertical--) {
			if (vertical == 10) {
				System.out.print(vertical);
			} else {
				System.out.print(vertical + " ");
			}

			for (Character horizontal = 'A'; horizontal <= 'J'; horizontal++) {
				String cell = horizontal.toString() + vertical;

				if (grid.get(cell).getShip() != null) {
					System.out.print(" " + grid.get(cell).getShip().getTypeShip());
				} else {
					System.out.print(" ~");
				}
			}

			System.out.println();
		}

		System.out.println("   A B C D E F G H I J");
		System.out.println();
	}
	private void drawShipRandomly(Ship ship) {
		Random random = new Random();
		Square sqaure;
		boolean placed = false;
		boolean occupied;
		int horizontal;
		int vertical;

		while (!placed) {
			occupied = false;
			
			if (ship.goesHorizontal()) {
				horizontal = (random.nextInt(10 - ship.getLength()) + 1);
				vertical = random.nextInt(10) + 1;

				for (int cell = horizontal; cell < (ship.getLength() + horizontal); cell++) {
					sqaure = grid.get(intToCharacter(cell).toString() + vertical);

					if (sqaure.getShip() != null) {
						occupied = true;
						break;
					}
				}
				
				if (!occupied) {
					for (int cell = horizontal; cell < (ship.getLength() + horizontal); cell++) {
						sqaure = grid.get(intToCharacter(cell).toString() + vertical);

						sqaure.setShip(ship);
					}
					
					placed = true;
				}
			} else {
				horizontal = random.nextInt(10) + 1;
				vertical = (random.nextInt(10 - ship.getLength()) + 1);

				for (int cell = vertical; cell < (ship.getLength() + vertical); cell++) {
					sqaure = grid.get(intToCharacter(horizontal).toString() + cell);
					
					if (sqaure.getShip() != null) {
						occupied = true;
						break;
					}
				}

				if (!occupied) {
					for (int cell = vertical; cell < (ship.getLength() + vertical); cell++) {
						sqaure = grid.get(intToCharacter(horizontal).toString() + cell);
						
						sqaure.setShip(ship);
					}
					
					placed = true;
				}
			}
		}
	}
	
	public void fired() {
		// TODO register fire
	}
	
	private Character intToCharacter(int integer) {
		switch (integer) {
			case 1:
				return 'A';
			case 2:
				return 'B';
			case 3:
				return 'C';
			case 4:
				return 'D';
			case 5:
				return 'E';
			case 6:
				return 'F';
			case 7:
				return 'G';
			case 8:
				return 'H';
			case 9:
				return 'I';
			case 10:
				return 'J';
			default:
				return 'A';
		}
	}
	
	public void placeShipsRandomly() {
		Random random = new Random();

		/*
		 * AircraftCarrier
		 */
		AircraftCarrier aircraftCarrier = new AircraftCarrier(random.nextBoolean());
		drawShipRandomly(aircraftCarrier);

		/*
		 * Battleship
		 */
		BattleShip battleShip = new BattleShip(random.nextBoolean());
		drawShipRandomly(battleShip);
		
		/*
		 * Submarine
		 */
		Submarine submarine = new Submarine(random.nextBoolean());
		drawShipRandomly(submarine);
		
		/*
		 * Destroyer
		 */
		Destroyer destroyer = new Destroyer(random.nextBoolean());
		drawShipRandomly(destroyer);

		/*
		 * Patrol Boat
		 */
		PatrolBoat patrolBoat = new PatrolBoat(random.nextBoolean());
		drawShipRandomly(patrolBoat);
	}
	
	public void print() {
		for (int vertical = 10; vertical >= 1; vertical--) {
			if (vertical == 10) {
				System.out.print(vertical);
			} else {
				System.out.print(vertical + " ");
			}

			for (Character horizontal = 'A'; horizontal <= 'J'; horizontal++) {
				String cell = horizontal.toString() + vertical;

				if (grid.get(cell).getShip() != null) {
					System.out.print(" " + grid.get(cell).getShip().getTypeShip());
				} else {
					System.out.print(" .");
				}
			}

			System.out.println();
		}

		System.out.println("   A B C D E F G H I J");
	}
}
