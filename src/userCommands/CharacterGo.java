package userCommands;

import coreclasses.GetPlayerCommand;

public class CharacterGo {

	public void go(String playerCommand) {
		String command[] = null;
		command = playerCommand.split(" ");
		
		String secondWord = command[1];
		
		System.out.println("You are going " + secondWord + ".");

		GetPlayerCommand gpc = new GetPlayerCommand();
		gpc.enterCommand();
	}	

}
