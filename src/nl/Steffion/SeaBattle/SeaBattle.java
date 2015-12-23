package nl.Steffion.SeaBattle;

public class SeaBattle {
    public static boolean CHEAT = true; // Incase you want to chance CHEAT in the future, removed the final
    private Player player1;
    private Player player2;

    public SeaBattle() {
        this.play();
        player1 = new Player();
        player2 = new Player();
        player1.getField().placeShipsRandomly();
        player2.getField().placeShipsRandomly();

    }

    public void play() {
        player1.getField().print();
    }
}
