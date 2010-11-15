package hello.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hello.presentation.Game;

public class Console {
	static Game game = new Game();
	static BufferedReader rl = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		game.initializeGame();
		runGame();
	}
	public static void runGame() {
		game.printLoginPrompt();
		while(game.running) {
				try {
					game.processInput(rl.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
				game.printOutput();
			}
	}
}
