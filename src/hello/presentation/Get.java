package hello.presentation;

import hello.domain.Thing;

public class Get extends Command {
	Thing item;
	String v1;
	
	@Override
	public Command parse(String[] s) {
		item = g1.character.getLocation().idTarget(s[1]);
		if(item == null){
			Error e1 = new Error();
			e1.g1 = g1;
			e1.errorMessage = "There is no [" + s[1] + "] to get.";
			return e1;
		}
		return this;
	}
	@Override
	public Command process(Thing a) {
		a.getLocation().removeContent(item);
		item.setLocation(a);
		a.addContent(item);
		return this;
	}

	@Override
	public void output() {
			g1.uComm.add("You got [" + item.getName() + "]");
	}
}
