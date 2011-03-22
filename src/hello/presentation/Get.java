package hello.presentation;

import hello.domain.Thing;

public class Get extends Command {
	Thing item;
	String v1;
	
	@Override
	public Command parse(String[] s) {
		v1 = s[1];
		item = g1.character.getLocation().idTarget(s[1]);
		return this;
	}
	@Override
	public Command process(Thing a) {
		if(item != null) {
			a.getLocation().removeContent(item);
			item.setLocation(a);
			a.addContent(item);
			return this;
		} else {
			Error e1 = new Error();
			e1.g1 = g1;
			e1.errorMessage = "There is no [" + v1 + "] to get.";
			return e1;
		}
	}

	@Override
	public void output() {
			g1.uComm.add("You got [" + item.getName() + "]");
	}
}
