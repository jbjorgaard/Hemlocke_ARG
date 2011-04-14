package hello.presentation;

import hello.domain.Thing;

public class Empty extends Command {
	Thing container;

	@Override
	public Command parse(String[] s) {
		container = g1.character.idTarget(s[1]);
		if (container == null) {
			return new Error(g1, "There is no [" + s[1] + "] to empty.", actor);
		}
		return this;
	}
	@Override
	public Command process() {
		for(Thing thing : container.getContents()) {
			container.removeContent(thing);
			thing.setLocation(actor.getLocation());
			actor.getLocation().addContent(thing);
		}
		return this;
	}
	@Override
	public void output(Thing thing) {
		if(thing == g1.character) {
			g1.uComm.add("You emptied " + container + ".");			
		} else {
			g1.uComm.add(thing.describe() + " emptied " + container + ".");
		}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void runCommand(Thing i) {
		
	}
}
