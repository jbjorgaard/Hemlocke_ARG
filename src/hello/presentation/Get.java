package hello.presentation;

import hello.domain.Thing;

public class Get extends Command {
	Game g1;
	Get get = new Get();
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
		
		return get;		
	}
	@Override
	public Command process() {
		get.g1 = g1;
		
		if(actor.getLocation().idTarget(userInput[1]) != null) {
			item = actor.getLocation().idTarget(userInput[1]);
			actor.getLocation().removeContent(item);
			item.setLocation(actor);
			actor.addContent(item);
		}
		return get;
	}
	@Override
	public Command generate() {
		return get;
	}
	@Override
	public void output(String[] s) {
		g1.uComm.add("You picked up " + s[1] + ".");
	}

}
