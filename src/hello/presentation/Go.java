package hello.presentation;

import hello.domain.Thing;

public class Go extends Command{
	Game g1;
	Thing location;
	Thing character;
	String[] command;
	Thing target;
	String desc;
	Go go = new Go();
	String[] userInput;
	Thing actor;
	
	@Override
	public Command parse(Thing a, String[] s) {
		actor = a;
		userInput = s;
		return go;		
	}
	@Override
	public Go process() {
		go.g1 = g1;
		
		actor.moveTo(actor, userInput);
		return go;
	}
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command generate() {
		return go;
	}
	@Override
	public void output(String[] s) {
		g1.uComm.add("You have gone " + s[1] + ".");
	}
}
