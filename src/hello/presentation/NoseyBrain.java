package hello.presentation;

public class NoseyBrain extends Brain {
	public void receiveCommand(Look look) {}
	public void receiveCommand(Drop drop) {}
	public void receiveCommand(Get get) {
		Say s;
		s = (Say) g1.getCommand("say").copy(owner);
		s.setSpoke(owner.getName() + " says, Oooh what did you just grab?");
		s.runCommand(owner);
	}
	public void receiveCommand(Empty empty) {}
	public void receiveCommand(Go go) {}
	public void receiveCommand(Error error) {}
	public void receiveCommand(Say say) {}
}
