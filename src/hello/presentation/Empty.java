package hello.presentation;

import hello.domain.Thing;

public class Empty extends Command {
	Thing container;

	@Override
	public Command parse(String[] s) {
		container = g1.character.idTarget(s[1]);
		if (container == null) {
			Error e1 = new Error();
			e1.g1 = g1;
			e1.errorMessage = "There is no [" + s[1] + "] to empty.";
			return e1;
		}
		return this;
	}
	@Override
	public Command process(Thing character) {
		for(Thing thing : container.getContents()) {
			container.removeContent(thing);
			thing.setLocation(character.getLocation());
			character.getLocation().addContent(thing);
		}
		return this;
	}
	@Override
	public void output() {
			g1.uComm.add("You emptied " + container + ".");
	}
}
