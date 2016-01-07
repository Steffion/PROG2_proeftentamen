package nl.Steffion.SeaBattle;

import java.util.HashMap;

public class SeaBattle {
	public static boolean	CHEAT	= true;
	private ConsoleIO		io;
	private Player			player1;
	private Player			player2;
	private boolean			player2IsAI;
	private Player			turn;
							
	public SeaBattle() {
		io = new ConsoleIO();

		player1 = new Player();
		player2 = new Player();
		player1.getField().placeShipsRandomly();
		player2.getField().placeShipsRandomly();

		init();
	}
	
	public void finished(Player winner) {
		if (SeaBattle.CHEAT) {
			System.out.println("*** Because of the cheat mode being enabled, the game ended early. ***");
		}

		System.out.println("Congratulations " + winner.getName() + ", you destroyed all the ships of your opponent!");
		System.out.println("You are the winner of this game!");

		System.out.println("Do you want to play this game again? (Y/n)");
		boolean validAnswerGiven = false;
		while (!validAnswerGiven) {
			switch (io.readInput()) {
				case "Y":
					validAnswerGiven = true;
					break;
				case "n":
					System.out.println("Thanks for playing my game of SeaBattle!");
					System.out.println("Hope to see you next time ;-)!");
					System.exit(0);
					validAnswerGiven = true;
					break;
				default:
					System.out.println("*** Please enter a valid answer! (Y/n) ***");
					break;
			}
		}

		player1.setField(new Field());
		player1.getField().placeShipsRandomly();
		player2.setField(new Field());
		player2.getField().placeShipsRandomly();
		System.out.println();
		System.out.println();
		play();
	}

	public void init() {
		System.out.println("Welcome to a game of SeaBattle!");
		System.out.println();
		System.out.println("Try to destroy all the ships of your opponent,");
		System.out.println("before he destorys your ships!");

		System.out.println("With how many players do you want to play? (1/2)");
		boolean validAnswerGiven = false;
		while (!validAnswerGiven) {
			switch (io.readInput()) {
				case "1":
					validAnswerGiven = true;
					player2IsAI = true;
					break;
				case "2":
					validAnswerGiven = true;
					player2IsAI = false;
					break;
				default:
					System.out.println("*** Please enter a valid number! (1/2) ***");
					break;
			}
		}

		System.out.println("Enter name of player 1: ");
		validAnswerGiven = false;
		while (!validAnswerGiven) {
			String answer = io.readInput();
			if ((answer == null) || answer.isEmpty()) {
				System.out.println("*** Please enter something! ***");
			} else {
				player1.setName(answer);
				validAnswerGiven = true;
			}
		}
		
		player2.setName("Computer");
		
		if (!player2IsAI) {
			System.out.println("Enter name of player 2: ");
			validAnswerGiven = false;
			while (!validAnswerGiven) {
				String answer = io.readInput();
				if ((answer == null) || answer.isEmpty()) {
					System.out.println("*** Please enter something! ***");
				} else {
					player2.setName(answer);
					validAnswerGiven = true;
				}
			}
		}
	}

	public void play() {
		turn = player1;
		boolean finished = false;
		while (!finished) {
			if (player2IsAI) {
				System.out.println("*** " + player1.getName() + "'s turn ***");
				player2.getField().print();

				if (SeaBattle.CHEAT) {
					player2.getField().cheatPrint();
				}

				shoot(player1, player2);
			} else {
				if (turn == player1) {
					System.out.println("*** " + player1.getName() + "'s turn ***");
					player2.getField().print();

					shoot(player1, player2);
				} else {
					System.out.println("*** " + player2.getName() + "'s turn ***");
					player1.getField().print();

					shoot(player2, player1);
				}
			}

			if (SeaBattle.CHEAT && player2IsAI) {
				finished = player2.getField().oneShipSunk();
			} else {
				finished = player1.getField().allShipsSunk() || player2.getField().allShipsSunk();
			}
		}

		if (player2IsAI) {
			System.out.println("*** WINNER: " + player1.getName() + " ***");
			player2.getField().print();
			finished(player1);
		} else {
			if (player1.getField().allShipsSunk()) {
				System.out.println("*** WINNER: " + player2.getName() + " ***");
				player1.getField().print();
				finished(player2);
			} else {
				System.out.println("*** WINNER: " + player1.getName() + " ***");
				player2.getField().print();
				finished(player1);
			}
		}
	}
	
	public void shoot(Player player, Player opponent) {
		System.out.println(player.getName() + ", where do you want to shoot a missle at?");
		boolean validAnswerGiven = false;
		while (!validAnswerGiven) {
			String answer = io.readInput();
			HashMap<String, Square> grid = opponent.getField().getGrid();

			if ((answer == null) || answer.isEmpty()) {
				System.out.println("*** Please enter something! ***");
			} else if (!grid.containsKey(answer)) {
				System.out.println("*** Please enter a valid cell! (e.g. E5) ***");
			} else if (grid.get(answer).isShot()) {
				System.out.println("*** You already shot a missle there! Try another cell! ***");
			} else {
				if (grid.get(answer).getShip() == null) {
					turn = opponent;
					System.out.println("Sorry, you didn't hit something.");
				} else {
					System.out.println("Congratulations! You hit a ship.");
					grid.get(answer).getShip().registerHit();

					if (grid.get(answer).getShip().hasSank()) {
						System.out.println("Even better, You destroyed a ship!");
					}
				}
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				grid.get(answer).setShot(true);
				validAnswerGiven = true;
			}
		}
	}
}
