package coreclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import userCommands.CharacterDrop;
import userCommands.CharacterGet;
import userCommands.CharacterGo;
import userCommands.CharacterLook;
import userCommands.PlayerHelp;
import userCommands.PlayerLogout;

public class HemlockeGame {
	
	public boolean gameRunning = true;
	
	public void login() {
		System.out.println("Please enter your username and password: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String playerLogin = null;
		
		try {
			playerLogin = br.readLine();
		} catch (IOException ioe) {
			System.out.println("There was an error trying to read your command.");
			System.exit(1);
		}
		
		readLogin(playerLogin);
		
	}
	
	public String readLogin(String playerLogin) {
		
		String login[] = null;
		login = playerLogin.split(" ");
		
		String userName = login[0];
		String password = login[1];
		
		System.out.println("You have logged in " + userName );
		System.out.println("Your username is [" + userName + "]. Your password is [" + password + "].");
		
		return null;
	}
	
	public String enterCommand() {
		
		System.out.println("Enter a command: \nType 'help' to get a list of commands");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String playerCommand = null;
		
		try {
			playerCommand = br.readLine();
		} catch (IOException ioe) {
			System.out.println("There was an error trying to read your command.");
			System.exit(1);
		}
		
		readCommand(playerCommand);
		
		return playerCommand;
	}
	
	public String readCommand(String playerCommand) {
		
		String command[] = null;
		command = playerCommand.split(" ");
		
		String firstWord = command[0];
		
		if (firstWord.equals("look")) {
			CharacterLook cl = new CharacterLook();
			cl.look(playerCommand);
		} else if (firstWord.equals("go")) {
			CharacterGo cg = new CharacterGo();
			cg.go(playerCommand);
		} else if (firstWord.equals("get")) {
			CharacterGet get = new CharacterGet();
			get.cGet(playerCommand);
		} else if (firstWord.equals("drop")) {
			CharacterDrop cd = new CharacterDrop();
			cd.drop(playerCommand);
		} else if (firstWord.equals("quit")) {
			PlayerLogout pl = new PlayerLogout();
			pl.logout();
		} else if (firstWord.equals("exit")) {
			System.out.println("Thank you for playing Hemlocke_ARG.");
			gameRunning = false;
		}	else if (firstWord.equals("help")) {
			PlayerHelp ph = new PlayerHelp();
			ph.help();
		} else {
			System.out.println("Command not recognized.");
		}
		
		return null;
	}

	public void startPlaying() {
		while(gameRunning) {
			enterCommand();
		}
	}
	
	public static void main(String[] args) {
		HemlockeGame game = new HemlockeGame();
		game.login();
		game.startPlaying();
	}



}
