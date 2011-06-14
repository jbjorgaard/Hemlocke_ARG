package hello.presentation;

import hello.domain.Thing;

public class Drop extends Command {
	Thing item;
	boolean succeeded = false;
	
	@Override
	public Command parse(String[] s) {
		item = g1.character.idTarget(s[1]);
		succeeded = item != null;
		if(!succeeded) {
			return new Error(g1, "You do not have [" + s[1] + "] to drop.", actor);
		} else {
			return this;
		}
	}
	@Override
	public Command process() {
		actor.removeContent(item);
		item.setLocation(actor.getLocation());
		actor.getLocation().addContent(item.getId());
		return this;
	}
	
	
	@Override
	public void output(Thing thing) {
		if(thing == g1.character) {
			g1.uComm.add("You dropped [" + item + "]");			
		} else {
			g1.uComm.add(thing.describe() + " dropped [" + item + "]");
		}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void runCommand(Thing i) {
		
	}
}