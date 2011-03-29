package hello.presentation;

import hello.domain.Thing;

public class Go extends Command{
	Thing target;
	String v1;
	
	@Override
	public Command parse(String[] s) {
		v1 = s[1];		
		target = g1.character.getLocation().getLink(s[1]);
		return this;
	}
	@Override
	public Command process(Thing t) {
		actor = t;
		if(target != null){
			actor.getLocation().removeContent(actor);
			actor.setLocation(target);
			target.addContent(actor);
			return this;
		} else {
			Error e1 = new Error();
			e1.g1 = g1;
			e1.errorMessage = "You cannot go " + v1 + ".";
			return e1;
		}
	}
	@Override
	public void output() {
			g1.uComm.add("You have gone to " + target);
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
}
