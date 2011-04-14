package hello.presentation;

import hello.domain.Events;
import hello.domain.Thing;

public abstract class Command implements Events, Cloneable {
	Thing actor;
	protected Game g1;
	
	public abstract Command process();
	public abstract Command parse(String[] s);
	public abstract void output(Thing thing);
	public abstract void notifyBrain(Brain brain);
	public abstract void runCommand(Thing i);
	public void setItem(Thing i){}
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {}
		return null;
	}
	public Command copy(Thing actor) {
		Command copy = (Command)clone();
		
		copy.g1 = g1;
		copy.actor = actor;
		return copy;
	}
	public void setGame(Game game) {
		g1 = game;
	}
}
