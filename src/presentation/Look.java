package presentation;

import domain.GameObject;

public class Look extends Command{
	HemlockeGame g1;
	GameObject currentObject;
	GameObject location;
	Look l1;
	String desc;
	
	public void setGame(HemlockeGame game) {
		g1 = game;
	}
	@Override
	public Look create(GameObject g) {
		l1 = new Look();
		currentObject = g;
		location = currentObject.getLocation();
		desc = location.getDescription();
		return l1;
	}
	@Override
	public void processCommand() {
		
	}
}
