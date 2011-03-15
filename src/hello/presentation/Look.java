package hello.presentation;

import java.util.HashSet;

import hello.domain.Thing;

public class Look extends Command{
	Game g1;
	int x = 0;
	String[] desc;
	Thing target;
	HashSet<Thing> targetContents;
	
	
	public void setGame(Game game) {
		g1 = game;
	}
	@Override
	public Command parse(String[] s) {
		Look look = new Look();
		look.g1 = g1;
		if(s.length == 2) {
			look.target = g1.character.getLocation().idTarget(s[1]);
		} else {
			look.target = g1.character.getLocation();
		}
		return look;
	}
	@Override
	public void process(Thing a) {
		if(target != null) {
			x = 1;
		} else {
			//TODO generate error
			x = 0;
		}
	}
	@Override
	public void output() {
		if(x == 1) {
			g1.uComm.add("You look at [" + target.getName() + "] and see: ");
			for(Thing thing : target.getContents()) {
				g1.uComm.add("[" + thing.getName() + "]");
			}
		} else {
			g1.uComm.add("There was an error.");
		}
	}
}
