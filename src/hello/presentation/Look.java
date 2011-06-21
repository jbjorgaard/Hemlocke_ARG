package hello.presentation;

import java.util.HashSet;

import hello.domain.Thing;

public class Look extends Command{
	Thing target;
	HashSet<Thing> targetContents;
	
	@Override
	public Command parse(String[] s) {
		if(s.length == 2) {
			target = getGame().character.getLocation().idTarget(s[1]);
			if(target == null) {
				return new Error(getGame(),  "There was no " + s[1] + " to look at.", actor);
			}
		} else {
			target = getGame().character.getLocation();
		}
		return this;
	}
	@Override
	public Command process() {
		return this;
	}
	@Override
	public void output(Thing thing) {
		if(thing == getGame().character) {
			getGame().uComm.add("You look at [" + target.getName() + "] and see: ");
			getGame().uComm.add(target.describe());			
		} else {
			getGame().uComm.add(thing.describe() + "looked at " + target.describe());
		}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void runCommand(Thing i) {
		
	}
}
