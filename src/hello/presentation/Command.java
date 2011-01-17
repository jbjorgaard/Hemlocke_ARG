package hello.presentation;

import hello.domain.Events;
import hello.domain.Thing;

public abstract class Command implements Events {
	Thing actor;
	String v1;
	
	public abstract Command process(Thing a);
	public abstract Command parse(String[] s);
	public abstract void output();
}
