package userCommands;


public class CharacterDrop {

	public void drop(String playerCommand) {
		String command[] = null;
		command = playerCommand.split(" ");
		
		String secondWord = command[1];
		
		System.out.println("You are dropping the " + secondWord + ".");
	
	}

}
