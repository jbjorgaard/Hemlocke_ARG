package hello.presentation;

public class GreedBrain extends Brain {
	Game game;
	
	public void setGame(Game g) {
		game = g;
	}

	@Override
	public void receiveCommand(Drop drop) {
		game.uComm.add("I want what you just dropped");
	}

	@Override
	public void receiveCommand(Empty empty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCommand(Error error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCommand(Get get) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCommand(Go go) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveCommand(Look look) {
		// TODO Auto-generated method stub
		
	}
	
}
