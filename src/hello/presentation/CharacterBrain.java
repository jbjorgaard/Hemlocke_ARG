package hello.presentation;

public class CharacterBrain extends Brain {
	Game game;
	
	public void setGame(Game g) {
		game = g;
	}	
	@Override
	public void receiveCommand(Look look) {
		look.output(look.actor);
	}
	@Override
	public void receiveCommand(Drop drop) {
		drop.output(drop.actor);
	}
	public void receiveCommand(Get get) {
		get.output(get.actor);
	}
	public void receiveCommand(Empty empty) {
		empty.output(empty.actor);
	}
	public void receiveCommand(Go go) {
		go.output(go.actor);
	}
	public void receiveCommand(Error error) {
		error.output(error.actor);
	}
	public void receiveCommand(Say say) {
		say.output(say.actor);
	}
//	@Override
//	public void receiveCommand(Command command) {
//		game.uComm.add("Perceived command: " + command);
//		super.receiveCommand(command);
//	}
}
