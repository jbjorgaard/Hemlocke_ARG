package hello.presentation;

import hello.domain.Thing;

public class Look extends Command{
	Game g1;
	Look look = new Look();
	String[] userInput;
	Thing actor;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(Thing a, String[] s) {
		actor = a;
		userInput = s;
		return look;		
	}
	@Override
	public Command process() {
		
		look.g1 = g1;
		String[] s1 = userInput;
		String[] c1;
		
		if(s1.length > 1) {
			if(actor.getLocation().idTarget(s1[1]) != null) {
				c1 = actor.getLocation().idTarget(s1[1]).describe().split(";");
				g1.uComm.add("You look at [" + c1[0] + "]" + c1[1]);
				if(c1.length > 2) {
					g1.uComm.add("Inside you see: ");
					int x = 0;
					while(x < (c1.length - 2)) {
						g1.uComm.add("[" + c1[x+2] + "]");
						x = x + 1;
					}
				} 
			} else {
				g1.uComm.add("Item not recognized");
			}
		} else {
			g1.uComm.add("You are in " + actor.getLocation().getName() + actor.getLocation().getShortDesc());
			c1 = actor.getLocation().describe().split(";");
			if(c1.length > 2) {
				int x = 0;
				while(x < (c1.length - 2)) {
					g1.uComm.add("[" + c1[x+2] + "]");
					x = x + 1;
				}
			}
		}
		
		return look;		
	}
	@Override
	public Command generate() {
		return look;
	}
	public void output(String[] s) {		
	}
}
