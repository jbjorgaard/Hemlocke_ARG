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
		
		while(loggedIn) {
			getUserCommand();
		}
	}
	private void getUserCommand() {
		String playerInput = null;
		String playerCommand[] = null;
		Command command;
		
		System.out.println("What would you like to do?");
		BufferedReader guc = new BufferedReader(new InputStreamReader(System.in));
		try {
			playerInput = guc.readLine();
		} catch (IOException ioe) {
			System.out.println("There was an error trying to read your command.");
			System.exit(1);
		}
		playerCommand = playerInput.split(" ");
		if(mapCommand.containsKey(playerCommand[0])) {
			command = mapCommand.get(playerCommand[0]).process(character, playerCommand);
			command.output(playerCommand);
		} else {
			System.out.println("That command is not recognized.");
		}
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
			if(mapLogin.containsKey(playerLogin)) {
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
					System.out.println(character.getName() + " is " + character.getDescription());
					System.out.println("You find yourself " + character.getLocation().getDescription());
					loggedOut = false;
				} else {
					System.out.println("Password not recognized.  Please try again.");
				}
			} else {
				System.out.println("User not recognized.");
			}
		}
	}
	public void initializeGame() {
		Player p1 = new Player();
		Player p2 = new Player();
		Look look = new Look();
		Go go = new Go();
		Get get = new Get();
		Thing m1r1 = new Thing();
		Thing m1r2 = new Thing();
		Thing c1 = new Thing();
		Thing c2 = new Thing();
		Thing m1 = new Thing();
		Thing m2 = new Thing();
		Thing i1 = new Thing();
		Thing i2 = new Thing();
		world = new Thing();
		
		c1.setInfo(m1r1, "a short, slender young woman who appears to be in her twenties.\nDressed in a black body glove, she wears a black backpack covered in pockets.", ", a young woman", "Nightshade", "character");
		c2.setInfo(m1r2, "a grim, pale-skinned man standing about five and a half feet tall; dressed in all black including trenchcoat and fedora hat.", ", a man in black", "Hemlocke", "character");
		m1r1.setInfo(m1, "in an archway covered in years of unkept brambles.", " that is almost hidden", "an archway", "room");
		m1r1.addLink("north", m1r2);
		m1r2.setInfo(m1, "in a clearing, in a very strange woods.", "", "forest clearing", "room");
		m1r2.addLink("south", m1r1);
		m1.setLocation(world);
		m2.setLocation(world);
		i1.setInfo(i2, "an ornate curved knife.", " ", "knife", "item");
		i2.setInfo(m1r1, "a plain looking box.", " ", "box", "item");
		p1.setInfo("peartree", c1);
		p2.setInfo("plumtree", c2);
		world.addContent(m1);
		world.addContent(m2);
		mapLogin.put("jeremiah", p1);
		mapLogin.put("bill", p2);
		mapCommand.put("look", look);
		mapCommand.put("go", go);
		mapCommand.put("get", get);
		look.setGame(this);
		go.setGame(this);
	}
}
