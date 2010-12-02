package hello.presentation;

import hello.domain.Thing;

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
			g1.uComm.add("Command not recognized.");
		}
		return drop;
	}

	@Override
	public String generate(String[] s) {
		return null;		
	}
	@Override
	public Command parse(Thing a, String[] s) {
		// TODO Auto-generated method stub
		return null;
	}

}
