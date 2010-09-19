package presentation;

import domain.Thing;

public class Go extends Command{
	Game g1;
	Thing location;
	Thing character;
	String[] command;
	Thing target;
	String desc;
	
	@Override
	public Go process(Thing t, String[] s) {
		Go g = new Go();
		g.command = s;
		g.location = t.getLocation();
		g.target = g.location.getLink(g.command[1]);
		g.location.removeContent(t);
		t.setLocation(g.target);
		g.target.addContent(t);
		return g;
	}
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public void output(String[] s) {
		String[] direction = s;
		System.out.println("You have gone " + direction[1] + ".");
	}
}
