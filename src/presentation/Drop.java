package presentation;

import domain.Thing;

public class Drop extends Command {
	Game g1;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command process(Thing a, String[] s) {
		Drop drop = new Drop();
		Thing item;
		
		drop.g1 = g1;
		if(a.idTarget(s[1]) != null) {
			item = a.idTarget(s[1]);
			a.removeContent(item);
			item.setLocation(a.getLocation());
			a.getLocation().addContent(item);
		} else {
			System.out.println("Command not recognized.");
		}
		return drop;
	}

	@Override
	public void output(String[] s) {
		System.out.println("You dropped " + s[1] + ".");		
	}

}
