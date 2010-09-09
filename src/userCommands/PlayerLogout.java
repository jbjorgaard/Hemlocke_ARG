package userCommands;

import coreclasses.HemlockeGame;

public class PlayerLogout {
	public void logout() {
		System.out.println("You have logged out.");
		HemlockeGame game = new HemlockeGame();
		game.login();
		game.startPlaying();
	}
}
