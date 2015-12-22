package nl.Steffion.SeaBattle;

public abstract class Ship {
	private int	hits;
	private int	length;

	public Ship() {
		hits = 0;
	}
	
	public abstract char getTypeShip();
	
	public boolean hasSank() {
		if (hits >= length) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setLength(int length) {
		this.length = length;
	}
}
