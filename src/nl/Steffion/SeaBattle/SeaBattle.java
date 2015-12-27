package nl.Steffion.SeaBattle;

public class SeaBattle {
	public static final boolean	CHEAT	= true;
	private ConsoleIO			io;
	private Player				player1;
	private Player				player2;

	public SeaBattle() {
		io = new ConsoleIO();
		
		player1 = new Player();
		player2 = new Player();
		player1.getField().placeShipsRandomly();
		player2.getField().placeShipsRandomly();
		
	}

	public void play() {
		player1.getField().print();
	}
}
