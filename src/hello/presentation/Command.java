package hello.presentation;

import hello.domain.Events;
import hello.domain.Thing;

public abstract class Command implements Events, Cloneable {
	Thing actor;
	
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
		
		copy.actor = actor;
		return copy;
	}
	protected Game getGame() {
		return Game.currentGame;
	}
}
