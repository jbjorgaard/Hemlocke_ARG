package userCommands;

import coreclasses.GetPlayerCommand;

public class CharacterLook {

	public void look(String playerCommand) {
		String command[] = null;
		command = playerCommand.split(" ");
		
		String secondWord = command[1];
		
		System.out.println("You are looking " + secondWord + ".");

		GetPlayerCommand gpc = new GetPlayerCommand();
		gpc.enterCommand();
	}

}