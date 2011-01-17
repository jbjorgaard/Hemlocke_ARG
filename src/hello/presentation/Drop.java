package hello.presentation;

import hello.domain.Thing;

public class Drop extends Command {
	Drop d1;
	Game g1;
	String v1;
	Thing item;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(String[] s) {
		d1 = new Drop();
		d1.g1 = g1;
		v1 = s[1];
		return d1;
	}
	@Override
	public Command process(Thing a) {
		if(a.idTarget(v1) != null) {
			item = a.idTarget(v1);
			a.removeContent(item);
			item.setLocation(a.getLocation());
			a.getLocation().addContent(item);
		} else {
			g1.uComm.add("Command not recognized.");
		}
		return d1;
	}
	@Override
	public void output() {
		g1.uComm.add("You dropped " + v1 + ".");
	}
	
//	@Override
//	public Command process(Thing a, String[] s) {
//		Drop drop = new Drop();
//		Thing item;
//		
//		drop.g1 = g1;
//		if(a.idTarget(s[1]) != null) {
//			item = a.idTarget(s[1]);
//			a.removeContent(item);
//			item.setLocation(a.getLocation());
//			a.getLocation().addContent(item);
//		} else {
//			g1.uComm.add("Command not recognized.");
//		}
//		return drop;
//	}

//	@Override
//	public void output(String[] s) {
//		g1.uComm.add("You dropped " + s[1] + ".");		
//	}
//
}
