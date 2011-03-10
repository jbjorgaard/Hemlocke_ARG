package hello.presentation;

import hello.domain.Thing;

public class Empty extends Command {
	Game g1;
	String v1;
	int x = 0;
	Thing container;
	
	public void setGame(Game game) {
		g1 = game;
	}	
	@Override
	public Command parse(String[] s) {
		Empty e1 = new Empty();
		e1.g1 = g1;
		e1.v1 = s[1];
		return e1;
	}
	@Override
	public void process(Thing a) {
		if(a.getLocation().idTarget(v1) != null) {
			container = a.getLocation().idTarget(v1);
			for(Thing thing : container.getContents()) {
				container.removeContent(thing);
				thing.setLocation(container.getLocation());
				container.getLocation().addContent(thing);
			}
			x = 1;
		} else {
			x = 0;
		}
	}
	@Override
	public void output() {
		if(x == 1) {
			g1.uComm.add("You emptied " + v1 + ".");
		} else {
			g1.uComm.add("You do not have a [" + v1 + "] to empty.");
		}	
	}
}
