package hello.presentation;

public class GreedBrain extends Brain {
	public void receiveCommand(Drop drop) {
		Get g;
		g = (Get) getGame().getCommand("get").copy(getGame().getThing(owner));
		g.runCommand(drop.item);		
	}
	public void receiveCommand(Empty empty) {}
	public void receiveCommand(Error error) {}
	public void receiveCommand(Get get) {}
	public void receiveCommand(Go go) {}
	public void receiveCommand(Look look) {}
}
