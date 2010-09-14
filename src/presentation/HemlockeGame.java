package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import domain.Player;





public class HemlockeGame {
	Player p1;
	Player p2;
	HashMap<String, Player> mapLogin;
	HashMap<String, Command> mapCommand;
	Look look;
	Go go;
	
	public static void main(String[] args) {
		HemlockeGame game = new HemlockeGame();
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
		getUserCommand();
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
	}
	public void loginPlayer() {
		String playerLogin = null;
		String playerPassword = null;
		String password = null;
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
			password = mapLogin.get(playerLogin).getPassword();
			if(playerPassword.equals(password)) {
				System.out.println("You have sucessfully logged in.");
				loggedOut = false;
			} else {
				System.out.println("Please try again.");
			}
		}
	}

	public void initializeGame() {
		p1 = new Player();
		p2 = new Player();
		mapLogin = new HashMap<String, Player>();
		mapCommand = new HashMap<String, Command>();
		look = new Look();
		go = new Go();
		
		
		p1.setPassword("peartree");
		p2.setPassword("plumtree");	
		mapLogin.put("jeremiah", p1);
		mapLogin.put("bill", p2);
		mapCommand.put("look", look);
		mapCommand.put("go", go);
	}
	
	/*public boolean gameRunning = true;
	public void login() {
		
		Player p1 = new Player();
		p1.setInfo("peartree", "Hemlocke", "a particularly sadistic Fairest with a fondness of poisons");
		Player p2 = new Player();
		p2.setInfo("sugarplum", "Nightshade", "an emotionally unstable Darkling with control over the dream world");
		
		boolean loggedOut = true;
		
		while(loggedOut) {
			
			System.out.println("Please enter your username: ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String playerLogin = null;
			
			try {
				playerLogin = br.readLine();
			} catch (IOException ioe) {
				System.out.println("There was an error trying to read your command.");
				System.exit(1);
			}
			
			HashMap<String, Player> hm = new HashMap<String, Player>();
			hm.put("jeremiah", p1);
			hm.put("jonathan", p2);
		
					
			System.out.println("Please enter your password: ");
			
			BufferedReader brpwd = new BufferedReader(new InputStreamReader(System.in));
			
			String playerPwd = null;
			String password = hm.get(playerLogin).getPassword();
			
			try {
				playerPwd = brpwd.readLine();
			} catch (IOException ioe) {
				System.out.println("There was an error trying to read your command.");
				System.exit(1);
			}
			
			if(playerPwd.equals(password)) {
				System.out.println("You have sucessfully logged in.");
				System.out.println("You are playing " + hm.get(playerLogin).getName() + ",");
				System.out.println(hm.get(playerLogin).getDescription());
				loggedOut = false;
			} else {
				System.out.println("Please try again.");
			}
		}
		
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
	}*/



}
