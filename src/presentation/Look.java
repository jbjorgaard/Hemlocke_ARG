package presentation;

import domain.Thing;

public class Look extends Command{
	Game g1;
	Thing currentObject;
	Thing location;
	String desc;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command create() {
		Look l1 = new Look();
		return l1;		
	}
	@Override
	public void processCommand() {
		System.out.println("this shit is printed");
	}
}
