package hello.presentation;

import hello.domain.Events;
import hello.domain.Thing;

public abstract class Command implements Events {
	Thing actor;
	
	public abstract Command process(Thing a, String[] s);
	public abstract Command parse(Thing a, String[] s);
	public abstract String generate(String[] s);
}
