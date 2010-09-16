package presentation;

import domain.Events;
import domain.Thing;

public abstract class Command implements Events {
	Thing actor;
	
	public abstract Command process(Thing a, String[] s);
	public abstract void output();
}
