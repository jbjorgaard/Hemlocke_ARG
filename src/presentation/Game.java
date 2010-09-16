package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import domain.Thing;
import domain.Player;

public class Game {
	HashMap<String, Player> mapLogin = new HashMap<String, Player>();
	HashMap<String, Command> mapCommand = new HashMap<String, Command>();
	Player currentPlayer;
	Thing character;
	Thing world;
	
	public static void main(String[] args) {
		Game game = new Game();
		game.initializeGame();
		game.runGame();
	}
	public void runGame() {
		while(true) {
			loginPlayer();
			startPlaying();
		}
	}
	public void startPlaying() {
		boolean loggedIn = true;
		
		System.out.println("You are in the " + character.getLocation().getName());
		while(loggedIn) {
			getUserCommand();
		}
	}
	private void getUserCommand() {
		String playerInput = null;
		String playerCommand[] = null;
		
		System.out.println("What would you like to do?");
		BufferedReader guc = new BufferedReader(new InputStreamReader(System.in));
		try {
			playerInput = guc.readLine();
		} catch (IOException ioe) {
			System.out.println("There was an error trying to read your command.");
			System.exit(1);
		}
		playerCommand = playerInput.split(" ");
		mapCommand.get(playerCommand[0]).create(character, playerCommand).processCommand();
	}
	public void loginPlayer() {
		String playerLogin = null;
		String playerPassword = null;
		boolean loggedOut = true;
		
		while(loggedOut) {
			System.out.println("Please enter your username: ");
			BufferedReader rl = new BufferedReader(new InputStreamReader(System.in));
			try {
				playerLogin = rl.readLine();
			} catch (IOException ioe) {
				System.out.println("There was an error trying to read your command.");
				System.exit(1);
			}
			System.out.println("Please enter your password: ");
			BufferedReader rp = new BufferedReader(new InputStreamReader(System.in));
			try {
				playerPassword = rp.readLine();
			} catch (IOException ioe) {
				System.out.println("There was an error trying to read your command.");
				System.exit(1);
			}
			currentPlayer = mapLogin.get(playerLogin);
			if(playerPassword.equals(currentPlayer.getPassword())) {
				character = currentPlayer.getCharacter();
				System.out.println("You have sucessfully logged into [" + character.getName() + "]");
				loggedOut = false;
			} else {
				System.out.println("Please try again.");
			}
		}
	}
	public void initializeGame() {
		Player p1 = new Player();
		Player p2 = new Player();
		Look look = new Look();
		Go go = new Go();
		Thing r1 = new Thing();
		Thing r2 = new Thing();
		Thing c1 = new Thing();
		Thing c2 = new Thing();
		
		c1.setInfo("A troubled man in a black trenchcoat", "Hemlocke", "Character");
		c1.setLocation(r1);
		c2.setInfo("An overzealous wizened", "Snerbog", "Character");
		c2.setLocation(r2);
		r1.setInfo("An almost hidden archway, covered in years of unkept brambles.", "entry archway", "room");
		r2.setInfo("In a clearing, in a very strange woods.", "forest clearing", "room");
		p1.setPassword("peartree");
		p2.setPassword("plumtree");
		p1.setCharacter(c1);
		p2.setCharacter(c2);
		mapLogin.put("jeremiah", p1);
		mapLogin.put("bill", p2);
		mapCommand.put("look", look);
		mapCommand.put("go", go);
		look.setGame(this);
		go.setGame(this);
	}
}
