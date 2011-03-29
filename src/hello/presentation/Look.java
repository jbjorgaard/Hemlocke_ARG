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
				return new Error(g1,  "There was no " + s[1] + " to look at.");
			}
		} else {
			target = g1.character.getLocation();
		}
		return this;
	}
	@Override
	public Command process(Thing t) {
		actor = t;
		return this;
	}
	@Override
	public void output() {
			g1.uComm.add("You look at [" + target.getName() + "] and see: ");
			g1.uComm.add(target.describe());
//			for(Thing thing : target.getContents()) {
//				g1.uComm.add("[" + thing.getName() + "]");
//			}
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
}
