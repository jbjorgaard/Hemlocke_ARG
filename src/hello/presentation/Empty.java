package hello.presentation;

import hello.domain.Thing;

public class Empty extends Command {
	Game g1;
	Empty empty = new Empty();
	Thing container = null;
	Thing actor;
	String[] userInput;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(Thing a, String[] s) {
		actor = a;
		userInput = s;
		
		return empty;		
	}
	@Override
	public Command process() {
		empty.g1 = g1;
		if(actor.getLocation().idTarget(userInput[1]) != null) {
			container = actor.getLocation().idTarget(userInput[1]);
			for(Thing thing : container.getContents()) {
				container.removeContent(thing);
				thing.setLocation(container.getLocation());
				container.getLocation().addContent(thing);
			}
		} 
		return empty;
	}

	@Override
	public void output(String[] s) {
		g1.uComm.add("You have emptied " + s[1] + ".");	
	}
	@Override
	public Command generate() {
		return empty;
	}
}
