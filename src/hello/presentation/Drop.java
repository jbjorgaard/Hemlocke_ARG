package hello.presentation;

import hello.domain.Thing;

public class Drop extends Command {
	Thing item;
	boolean succeeded = false;
	
	@Override
	public Command parse(String[] s) {
		item = g1.character.idTarget(s[1]);
		return this;
	}
	@Override
	public Command process(Thing t) {
		actor = t;
		succeeded = item != null;
		if(succeeded) {
			actor.removeContent(item);
			item.setLocation(actor.getLocation());
			actor.getLocation().addContent(item);
			return this;
		} else {
			return new Error(g1, "You do not have [" + item + "] to drop.");
		}
	}
	
	
	@Override
	public void output() {
			g1.uComm.add("You dropped [" + item + "]");
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
}
