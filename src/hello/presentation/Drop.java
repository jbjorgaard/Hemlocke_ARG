package hello.presentation;

import hello.domain.Thing;

public class Drop extends Command {
	String v1;
	Thing item;
	boolean succeeded = false;
	
	@Override
	public Command parse(String[] s) {
		item = g1.character.idTarget(s[1]);
		v1 = s[1];
		return this;
	}
	@Override
	public Command process(Thing a) {
		succeeded = item != null;
		if(succeeded) {
			a.removeContent(item);
			item.setLocation(a.getLocation());
			a.getLocation().addContent(item);
			return this;
		} else {
			return new Error(g1, "You do not have [" + v1 + "] to drop.");
		}
	}
	
	
	@Override
	public void output() {
			g1.uComm.add("You dropped [" + item.getName() + "]");
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
}
