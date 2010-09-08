package userCommands;

import coreclasses.GetPlayerCommand;

public class PlayerLogout {

	public void logoutCharacter() {
		
		System.out.println("You are logging out of the system.");

		GetPlayerCommand gpc = new GetPlayerCommand();
		gpc.enterCommand();
		
	}

}
