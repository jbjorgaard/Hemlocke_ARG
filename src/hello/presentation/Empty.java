package hello.presentation;

import hello.domain.Thing;

public class Empty extends Command {
	Game g1;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command process(Thing a, String[] s) {
		Empty empty = new Empty();
		Thing container;
		
		empty.g1 = g1;
		if(a.getLocation().idTarget(s[1]) != null) {
			container = a.getLocation().idTarget(s[1]);
			for(Thing thing : container.getContents()) {
				container.removeContent(thing);
				thing.setLocation(container.getLocation());
				container.getLocation().addContent(thing);
			}
		} else {
			g1.uComm.add("Command not recognized.");
//			System.out.println("Command not recognized.");
		}
		return empty;
	}

	@Override
	public void output(String[] s) {
		g1.uComm.add("You have emptied " + s[1] + ".");
//		System.out.println("You have emptied " + s[1] + ".");		
	}

}
