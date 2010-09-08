package coreclasses;

public class ReadPlayerCommand {
	public String readCommand(String playerCommand) {
		System.out.println("The command you gave is: " + playerCommand);
		
		String command[] = null;
		command = playerCommand.split(" ");
		
		String firstWord = command[0];
		
		if (firstWord.equals("login")) {
			PlayerLogin ul = new PlayerLogin();
			ul.loginCharacter(playerCommand);
		} else if (firstWord.equals("look")) {
			CharacterLook cl = new CharacterLook();
			cl.look(playerCommand);
		} else if (firstWord.equals("go")) {
			CharacterGo cg = new CharacterGo();
			cg.go(playerCommand);
		} else if (firstWord.equals("quit")) {
			PlayerLogout pl = new PlayerLogout();
			pl.logoutCharacter();
		} else {
			System.out.println("Command not recognized.");
		}
		
		/*if (firstWord.equals("login")) {
			System.out.println("Please login with your username.");
		} else if (firstWord.equals("look")) {
			System.out.println("You look around the room");
		} else if (firstWord.equals("go")) {
			System.out.println("You go to the next room");
		} else if (firstWord.equals("quit")) {
			System.out.println("You have logged out.");
		} else {
			System.out.println("Command not recognized.");
		}*/
		
		return null;
	}

}
