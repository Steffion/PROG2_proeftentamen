package nl.Steffion.SeaBattle;

public abstract class Ship {
	private boolean	goesHorizontal;
	private int		hits;
	private int		length;
					
	public Ship(boolean goesHorizontal) {
		hits = 0;
		this.goesHorizontal = goesHorizontal;
	}

	public int getLength() {
		return length;
	}

	public abstract char getTypeShip();
	
	public boolean goesHorizontal() {
		return goesHorizontal;
	}

	public boolean hasSank() {
		if (hits >= length) {
			return true;
		} else {
			return false;
		}
	}

	public void registerHit() {
		hits++;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
}
