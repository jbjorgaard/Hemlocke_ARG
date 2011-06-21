package hello.presentation;

import hello.domain.Thing;

public class Get extends Command {
	private Thing item;
	String v1;
	
	@Override
	public Command parse(String[] s) {
		item = getGame().character.getLocation().idTarget(s[1]);
		if(item == null){
			return new Error(getGame(), "There is no [" + s[1] + "] to get.", actor);
		}
		return this;
	}
	@Override
	public Command process() {
		actor.getLocation().removeContent(item);
		item.setLocation(actor);
		actor.addContent(item.getId());
		return this;
	}
	@Override
	public void output(Thing thing) {
		if(thing == getGame().character) {
			getGame().uComm.add("You got " + item + ".");			
		} else {
			getGame().uComm.add(thing.describe() + " You got [" + item.getName() + "]");
		}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void setItem(Thing i) {
		item = i;
	}
	public void runCommand(Thing i) {
		setItem(i);
		getGame().commandQueue.add(this);
	}
}
