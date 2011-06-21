package hello.presentation;

import hello.domain.Thing;

public class Go extends Command{
	Thing target;
	
	@Override
	public Command parse(String[] s) {	
		target = getGame().character.getLocation().getLink(s[1]);
		if(target == null){
			return new Error(getGame(), "You cannot go " + s[1] + ".", actor);
		} else {	
			return this;
		}
	}
	@Override
	public Command process() {
		actor.getLocation().removeContent(actor);
		actor.setLocation(target);
		target.addContent(actor.getId());
		return this;
	}
	@Override
	public void output(Thing thing) {
		if(thing == getGame().character) {
			getGame().uComm.add("You have gone to " + target + ".");	
		} else {
			getGame().uComm.add(thing.describe() + " went to " + target + ".");
		}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void runCommand(Thing i) {
		
	}
}
