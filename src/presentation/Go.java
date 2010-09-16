package presentation;

import domain.Thing;


public class Go extends Command{
	Game g1;
	
	@Override
	public Go create(Thing a, String[] s) {
		return null;
	}
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public void processCommand() {
		// TODO Auto-generated method stub
		
	}
}
