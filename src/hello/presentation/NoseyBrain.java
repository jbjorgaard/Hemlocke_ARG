package hello.presentation;

public class NoseyBrain extends Brain {
	public void receiveCommand(Look look) {}
	public void receiveCommand(Drop drop) {}
	public void receiveCommand(Get get) {
		Say s;
		s = (Say) getGame().getCommand("say").copy(getGame().getThing(owner));
		s.setSpoke(getGame().getThing(owner).getName() + " says, Oooh what did you just grab?");
		s.runCommand(getGame().getThing(owner));
	}
	public void receiveCommand(Empty empty) {}
	public void receiveCommand(Go go) {}
	public void receiveCommand(Error error) {}
	public void receiveCommand(Say say) {}
}
