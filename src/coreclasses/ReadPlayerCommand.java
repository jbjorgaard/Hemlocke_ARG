package coreclasses;

public class ReadPlayerCommand {
	public String readCommand(String playerCommand) {
		System.out.println("The system is now reading your command.");
		
		String command[] = null;
		command = playerCommand.split(" ");
		
		System.out.println("The first word in the command is: " + command[0]);
		System.out.println("The second word in the command is: " + command[1]);
		
		return null;
	}

}
