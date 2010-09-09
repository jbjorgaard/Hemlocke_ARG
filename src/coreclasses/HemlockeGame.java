package coreclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HemlockeGame {
	
	public void login() {
		System.out.println("Please enter your username and password: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String playerLogin = null;
		
		try {
			playerLogin = br.readLine();
		} catch (IOException ioe) {
			System.out.println("There was an error trying to read your command.");
			System.exit(1);
		}
		
		ReadPlayerLogin rpc = new ReadPlayerLogin();
		rpc.readLogin(playerLogin);
		
	}
	
	public void startPlaying() {
		GetPlayerCommand get = new GetPlayerCommand();
		get.enterCommand();
	}
	
	public static void main(String[] args) {
		HemlockeGame game = new HemlockeGame();
		game.login();
		game.startPlaying();
	}



}
