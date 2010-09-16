package presentation;

import domain.Events;

public abstract class Command implements Events {
	public abstract Command create();

	public abstract void processCommand();
}
