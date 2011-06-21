package hello.presentation;

public class CharacterBrain extends Brain {
	
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
}
