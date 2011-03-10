package hello.presentation;

import hello.domain.Thing;

public class Go extends Command{
	Game g1;
	Thing location;
	Thing character;
	String[] command;
	Thing target;
	String desc;
	int x = 0;
	
	public void setGame(Game game) {
		g1 = game;
	}
	
	@Override
	public Command parse(String[] s) {
		Go go = new Go();
		go.g1 = g1;
		
		if(s.length == 2) {
			go.desc = s[1];
			if(g1.character.getLocation().getLink(s[1]) != null) {
				go.target = g1.character.getLocation().getLink(s[1]);
			} else {
				//TODO generate error command
				go.target = g1.character.getLocation();
			}			
		} else {
			//TODO generate error command
			go.target = g1.character.getLocation();
		}
		return go;
	}
	@Override
	public void process(Thing a) {
		if(target != a.getLocation()){
			a.getLocation().removeContent(a);
			a.setLocation(target);
			target.addContent(a);
			x = 1;
		} else {
			x = 0;
		}
	}
	@Override
	public void output() {
		if(x == 1) {
			g1.uComm.add("You have gone " + desc );
		} else {
			g1.uComm.add("You were not able to go " + desc);
		}
	}
//	public void setGame(Game game) {
//		g1 = game;
//	}
//	@Override
//	public void output(String[] s) {
//		g1.uComm.add("You have gone " + s[1] + ".");
//	}
}
