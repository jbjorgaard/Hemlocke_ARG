package hello.presentation;

import hello.domain.Thing;

public class Drop extends Command {
	Game g1;
	String v1;
	Thing item;
	boolean succeeded = false;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(String[] s) {
		Drop d1 = new Drop();
		d1.g1 = g1;
		d1.v1 = s[1];
		return d1;
	}
	@Override
	public void process(Thing a) {
		succeeded = a.idTarget(v1) != null;
		if(succeeded) {
			item = a.idTarget(v1);
			a.removeContent(item);
			item.setLocation(a.getLocation());
			a.getLocation().addContent(item);
		}
	}
	@Override
	public void output() {
		if(succeeded) {
			g1.uComm.add("You dropped " + v1 + ".");
		} else {
			g1.uComm.add("You do not have a [" + v1 + "] to drop.");
		}
		
	}
}
