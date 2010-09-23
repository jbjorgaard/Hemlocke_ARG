package presentation;

import domain.Thing;

public class Look extends Command{
	Game g1;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command process(Thing a, String[] s) {
		Look l1 = new Look();
		l1.g1 = g1;
		if(s.length > 1) {
			a.getLocation().listContent(s[1]);
		} else {
			a.getLocation().describe();	
		}
		return l1;		
	}
	public void output(String[] s) {		
	}
}
