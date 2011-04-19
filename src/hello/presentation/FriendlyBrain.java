package hello.presentation;

public class FriendlyBrain extends Brain {
	@Override
	public void receiveCommand(Look look) {
		look.output(look.actor);
	}
	@Override
	public void receiveCommand(Drop drop) {}
	public void receiveCommand(Get get) {}
	public void receiveCommand(Empty empty) {}
	public void receiveCommand(Go go) {
		Say s;
		s = (Say) g1.getCommand("say").copy(owner);
		s.setSpoke(owner.getName() + " says, Hi, how are you?");
		s.runCommand(owner);
	}
	public void receiveCommand(Error error) {}
	public void receiveCommand(Say say) {
	}
//	@Override
//	public void receiveCommand(Command command) {
//		game.uComm.add("Perceived command: " + command);
//		super.receiveCommand(command);
//	}
}
