package hello.presentation;

import hello.domain.Thing;

public class Get extends Command {
	Game g1;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command process(Thing a, String[] s) {
		Get get = new Get();
		Thing item;
		
		get.g1 = g1;
		if(a.getLocation().idTarget(s[1]) != null) {
			item = a.getLocation().idTarget(s[1]);
			a.getLocation().removeContent(item);
			item.setLocation(a);
			a.addContent(item);
		} else {
			System.out.println("Command not recognized.");
		}
		return get;
	}

	@Override
	public void output(String[] s) {
		System.out.println("You picked up " + s[1] + ".");
	}

}
