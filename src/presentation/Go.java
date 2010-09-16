package presentation;

import domain.Thing;


public class Go extends Command{
	Game g1;
	
	@Override
	public Go process(Thing a, String[] s) {
		return null;
	}
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public void output() {
		// TODO Auto-generated method stub
		
	}
}
