package presentation;

import domain.Thing;

public class Look extends Command{
	Game g1;
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command process(Thing a, String[] s) {
		Look l1 = new Look();
		l1.g1 = g1;
		String[] s1 = s;
		String[] c1;
		
		if(s1.length > 1) {
			if(a.getLocation().idTarget(s1[1]) != null) {
				c1 = a.getLocation().idTarget(s1[1]).describe().split(";");
				System.out.println("You look at [" + c1[0] + "]" + c1[1]);
				if(c1.length > 2) {
					System.out.println("Inside you see: ");
					int x = 0;
					while(x < (c1.length - 2)) {
						System.out.println("[" + c1[x+2] + "]");
						x = x + 1;
					}
				} 
			} else {
				System.out.println("Item not recognized");
			}
		} else {
			System.out.println("You are in " + a.getLocation().getName() + a.getLocation().getShortDesc());
			c1 = a.getLocation().describe().split(";");
			if(c1.length > 2) {
				int x = 0;
				while(x < (c1.length - 2)) {
					System.out.println("[" + c1[x+2] + "]");
					x = x + 1;
				}
			}
		}
		
		return l1;		
	}
	public void output(String[] s) {		
	}
}
