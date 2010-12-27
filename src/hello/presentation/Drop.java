package hello.presentation;

import hello.domain.Thing;

public class Drop extends Command {
	Game g1;
	Drop drop = new Drop();
	Thing item = null;
	Thing actor;
	String[] userInput;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(Thing a, String[] s) {
		actor = a;
		userInput = s;
		
		if(a.idTarget(s[1]) != null) {
			item = a.idTarget(s[1]);
		}
		return drop;
	}
	@Override
	public Command process() {
		if(item != null) {
			actor.removeContent(item);
			item.setLocation(actor.getLocation());
			actor.getLocation().addContent(item);
		}
		return drop;
	}
	@Override
	public Command generate() {
		g1.uComm.add("You dropped " + item + ".");		
		return drop;
	}
	@Override
	public void output(String[] s) {
		g1.uComm.add("You dropped " + s[1] + ".");		
	}

}
