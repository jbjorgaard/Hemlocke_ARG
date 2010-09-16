package presentation;

import domain.Events;
import domain.Thing;

public abstract class Command implements Events {
	Thing actor;
	public abstract Command create(Thing a, String[] s);

	public abstract void processCommand();

	public Command create() {
		// TODO Auto-generated method stub
		return null;
	}
}
