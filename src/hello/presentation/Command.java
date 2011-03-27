package hello.presentation;

import hello.domain.Events;
import hello.domain.Thing;

public abstract class Command implements Events, Cloneable {
	Thing actor;
	protected Game g1;
	
	public abstract Command process(Thing a);
	public abstract Command parse(String[] s);
	public abstract void output();
	public abstract void notifyBrain(Brain brain);
	
	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {}
		return null;
	}
	public Command copy() {
		Command copy = (Command)clone();
		
		copy.g1 = g1;
		return copy;
	}
	public void setGame(Game game) {
		g1 = game;
	}
}
