package presentation;

import domain.Thing;

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
		item = a.getLocation().identifyContent(s[1]);
		a.getLocation().removeContent(item);
		item.setLocation(a);
		a.addContent(item);
		return get;
	}

	@Override
	public void output(String[] s) {
		System.out.println("You got the " + s[1] + ".");
	}

}
