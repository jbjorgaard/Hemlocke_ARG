package hello.presentation;


import hello.domain.Thing;

public abstract class Command{
	Thing actor;
	
	public abstract Command process();
	public abstract void output(String[] s);
	public abstract Command parse(Thing a, String[] s);
	public abstract Command generate();
}
