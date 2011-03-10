package hello.presentation;

import hello.domain.Thing;

public class Get extends Command {
	Game g1;
	String v1;
	Thing item;
	int x = 0;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(String[] s) {
		Get get1 = new Get();
		get1.g1 = g1;
		get1.v1 = s[1];
		return get1;
	}
	@Override
	public void process(Thing a) {
		if(a.getLocation().idTarget(v1) != null) {
			item = a.getLocation().idTarget(v1);
			a.getLocation().removeContent(item);
			item.setLocation(a);
			a.addContent(item);
			x = 1;
		} else {
			x = 0;
		}
	}
	@Override
	public void output() {
		if(x == 1) {
			g1.uComm.add("You got " + v1 + ".");
		} else {
			g1.uComm.add("There is no [" + v1 + "] to get.");
		}
		
	}
}
