package nl.Steffion.SeaBattle;

public class Square {
	private Ship	ship;
	private boolean	shot;

	public Square() {
		ship = null;
		shot = false;
	}

	public Ship getShip() {
		return ship;
	}

	public boolean isShot() {
		return shot;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public void setShot(boolean shot) {
		this.shot = shot;
	}
}
