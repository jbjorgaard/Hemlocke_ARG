package hello.presentation;

import hello.domain.Thing;

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
		g.g1 = g1;
		t.moveTo(t, s);
		return g;
	}
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public void output(String[] s) {
		g1.uComm.add("You have gone " + s[1] + ".");
//		System.out.println("You have gone " + s[1] + ".");
	}
}
