package hello.presentation;

public class GreedBrain extends Brain {
	
	@Override
	public void receiveCommand(Drop drop) {
		Get g;
		g = (Get) g1.getCommand("get").copy(owner);
		g.runCommand(drop.item);		
	}

	@Override
	public void receiveCommand(Empty empty) {
		
	}

	@Override
	public void receiveCommand(Error error) {
		
	}

	@Override
	public void receiveCommand(Get get) {
		
	}

	@Override
	public void receiveCommand(Go go) {
		
	}

	@Override
	public void receiveCommand(Look look) {
		
	}
}
