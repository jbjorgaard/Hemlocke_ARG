package userCommands;


public class CharacterGet {

	public void cGet(String playerCommand) {
		String command[] = null;
		command = playerCommand.split(" ");
		
		String secondWord = command[1];
		
		System.out.println("You are getting the " + secondWord + ".");
		
	}
	
}
