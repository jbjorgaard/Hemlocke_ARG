package hello.presentation;

public class GreedBrain extends Brain {
	Game game;
	
	public void setGame(Game g) {
		game = g;
	}

	@Override
	public void receiveCommand(Drop drop) {
		game.uComm.add("GreedBrain: You just dropped something.");
	}

	@Override
	public void receiveCommand(Empty empty) {
		game.uComm.add("GreedBrain: You just emptied something.");
	}

	@Override
	public void receiveCommand(Error error) {
		game.uComm.add("GreedBrain: You just made an error.");
	}

	@Override
	public void receiveCommand(Get get) {
		game.uComm.add("GreedBrain: You just got something.");
	}

	@Override
	public void receiveCommand(Go go) {
		game.uComm.add("GreedBrain: You just went somewhere.");
	}

	@Override
	public void receiveCommand(Look look) {
		game.uComm.add("GreedBrain: You just looked at something.");
	}
}
