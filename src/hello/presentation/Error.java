package hello.presentation;

import hello.domain.Thing;

public class Error extends Command {
	String errorMessage;
	
	public Error() {}

	public Error(Game g1, String errorMessage, Thing actor) {
		this.actor = actor;
		this.errorMessage = errorMessage;
	}

	@Override
	public Command process() {
		return this;
	}

	@Override
	public Command parse(String[] s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void output(Thing thing) {
		getGame().uComm.add(errorMessage);
	}
	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}
	public void runCommand(Thing i) {
		
	}
}
