package presentation;

import domain.Events;
import domain.GameObject;


public abstract class Command implements Events {
	public abstract Command create(GameObject g);

	public abstract void processCommand();
}
