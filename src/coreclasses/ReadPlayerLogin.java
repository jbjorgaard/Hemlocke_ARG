package coreclasses;


public class ReadPlayerLogin {
	public String readLogin(String playerLogin) {
		
		String login[] = null;
		login = playerLogin.split(" ");
		
		String userName = login[0];
		String password = login[1];
		
		System.out.println("You have logged in " + userName );
		System.out.println("Your username is [" + userName + "]. Your password is [" + password + "].");
		
		return null;
	}
}
