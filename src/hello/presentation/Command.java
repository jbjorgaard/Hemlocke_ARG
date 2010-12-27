package hello.presentation;

import java.util.HashSet;

import hello.domain.Events;
import hello.domain.Thing;

public abstract class Command implements Events {
	Thing actor;
	
	public abstract Command process();
	public abstract void output(String[] s);
	public abstract Command parse(Thing a, String[] s);
	public abstract Command generate();
}
