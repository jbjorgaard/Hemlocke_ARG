package hello.presentation;

public abstract class Brain {
	public void receiveCommand(Drop drop){}
	public void receiveCommand(Empty empty){}
	public void receiveCommand(Error error){}
	public void receiveCommand(Get get){}
	public void receiveCommand(Go go){}
	public void receiveCommand(Look look){}
}
