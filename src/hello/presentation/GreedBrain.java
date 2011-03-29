package hello.presentation;

public class GreedBrain extends Brain {
	
	@Override
	public void receiveCommand(Drop drop) {
//		g1.uComm.add("GreedBrain: You just dropped something.");
		Get g;
		g = (Get) g1.getCommand("get");
		g.setItem(drop.item);
		g.runCommand(g, this.owner);
	}

	@Override
	public void receiveCommand(Empty empty) {
		g1.uComm.add("GreedBrain: You just emptied something.");
	}

	@Override
	public void receiveCommand(Error error) {
		g1.uComm.add("GreedBrain: You just made an error.");
	}

	@Override
	public void receiveCommand(Get get) {
		g1.uComm.add("GreedBrain: You just got something.");
	}

	@Override
	public void receiveCommand(Go go) {
		g1.uComm.add("GreedBrain: You just went somewhere.");
	}

	@Override
	public void receiveCommand(Look look) {
		g1.uComm.add("GreedBrain: You just looked at something.");
	}
}
