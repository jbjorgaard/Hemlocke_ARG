package hello.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import hello.presentation.Game;

public class Console {
	static BufferedReader rl = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws SQLException {
		Game.currentGame.initializeGame();
		runGame();
	}
	public static void runGame() {
		Game.currentGame.printLoginPrompt();
		while(Game.currentGame.running) {
				try {
					Game.currentGame.processInput(rl.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				Game.currentGame.printOutput();
			}
	}
}
