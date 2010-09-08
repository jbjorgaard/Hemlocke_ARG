package userCommands;

import coreclasses.GetPlayerCommand;

public class PlayerHelp {

	public void help() {
		System.out.println("");
		System.out.println("LIST OF AVAILABLE COMMANDS");
		System.out.println("look <left, right, up, down, forward, back>");
		System.out.println("go <forward, left, right, back>");
		System.out.println("get <itemname>");
		System.out.println("drop <itemname>");
		System.out.println("");
		GetPlayerCommand gpc = new GetPlayerCommand();
		gpc.enterCommand();
		
	}

}
