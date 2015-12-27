package nl.Steffion.SeaBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {
	BufferedReader br;

	public ConsoleIO() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String readInput() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
}