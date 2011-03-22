package hello.presentation;

import hello.domain.Thing;

public class Empty extends Command {
	String v1;
	Thing container;

	@Override
	public Command parse(String[] s) {
		Empty e1 = new Empty();
		e1.g1 = g1;
		e1.v1 = s[1];
		container = g1.character.getLocation().idTarget(v1);
		return e1;
	}
	@Override
	public Command process(Thing a) {
		if(container != null) {
			for(Thing thing : container.getContents()) {
				container.removeContent(thing);
				thing.setLocation(container.getLocation());
				container.getLocation().addContent(thing);
			}
			return this;
		} else {
			Error e1 = new Error();
			e1.g1 = g1;
			e1.errorMessage = "There is no [" + v1 + "] to empty.";
			return e1;
		}
	}
	@Override
	public void output() {
			g1.uComm.add("You emptied " + v1 + ".");
	}
}
