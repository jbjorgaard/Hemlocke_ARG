package coreclasses;

public class PlayerLogin {

	public void loginCharacter(String playerCommand) {
		String command[] = null;
		command = playerCommand.split(" ");
		
		String secondWord = command[1];
		
		System.out.println("You are logging into the character: " + secondWord);
		
	}
	
}