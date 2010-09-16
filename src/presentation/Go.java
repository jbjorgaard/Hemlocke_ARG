package presentation;

import domain.GameObject;


public class Go extends Command{
	HemlockeGame g1;
	
	@Override
	public Go create(GameObject g) {
		return null;
	}
	public void setGame(HemlockeGame game) {
		g1 = game;
	}
	@Override
	public void processCommand() {
		// TODO Auto-generated method stub
		
	}
}
