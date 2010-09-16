package presentation;

import domain.Thing;

public class Look extends Command{
	Game g1;
	Thing location;
	Thing character;
	String[] command;
	String desc;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command create(Thing a, String[] s) {
		Look l1 = new Look();
		l1.g1 = g1;
		l1.character = a;
		l1.command = s;
		return l1;		
	}
	@Override
	public void processCommand() {
		System.out.println("this shit is printed");
	}
}
