package coreclasses;

import java.io.*;

public class GetPlayerCommand {
	
	public String enterCommand() {
	
		System.out.println("Enter a command: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String playerCommand = null;
		
		try {
			playerCommand = br.readLine();
		} catch (IOException ioe) {
			System.out.println("There was an error trying to read your command.");
			System.exit(1);
		}
		
		System.out.println("[Your Character] " + playerCommand + ".");
		
		ReadPlayerCommand rpc = new ReadPlayerCommand();
		rpc.readCommand(playerCommand);
		
		return playerCommand;
	}
	
}
