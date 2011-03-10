package hello.presentation;

import hello.domain.Thing;

public class Look extends Command{
	Game g1;
	String v1;
	int x = 0;
	String[] desc;
	
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(String[] s) {
		Look l1 = new Look();
		l1.g1 = g1;
		if(s.length > 1) {
			l1.v1 = s[1];
		}
		return l1;
	}
	@Override
	public void process(Thing a) {	
		//TODO convert string to actual object in parse for all commands
		if(v1 != null){
			if(a.getLocation().idTarget(v1) != null) {
				desc = a.getLocation().idTarget(v1).describe().split(";");
				x = 1;
			} else { 
				//TODO generate error
				x = 0;
			}
		} else {
			desc = a.getLocation().describe().split(";");
			x = 2;
		}
	}
	@Override
	public void output() {
		if(x == 1) {
			g1.uComm.add("You see " + desc[0] + ", " + desc[1] + ".");
		} else if(x == 2){
			g1.uComm.add("You look around and see " + desc[0] + desc[1] + ".");
		} else {
			g1.uComm.add("The item you are looking for is not in this room");
		}
		
	}
}
