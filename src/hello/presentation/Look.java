package hello.presentation;

import java.util.HashSet;

import hello.domain.Thing;

public class Look extends Command{
	Thing target;
	HashSet<Thing> targetContents;
	
	@Override
	public Command parse(String[] s) {
		if(s.length == 2) {
			target = g1.character.getLocation().idTarget(s[1]);
			if(target == null) {
				return new Error(g1,  "There was no " + s[1] + " to look at.", actor);
			}
		} else {
			target = g1.character.getLocation();
		}
		return this;
	}
	@Override
	public Command process() {
		return this;
	}
	@Override
	public void output(Thing thing) {
		if(thing == g1.character) {
			g1.uComm.add("You look at [" + target.getName() + "] and see: ");
			g1.uComm.add(target.describe());			
		} else {
			g1.uComm.add(thing.describe() + "looked at " + target.describe());
		}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void runCommand(Thing i) {
		
	}
}
