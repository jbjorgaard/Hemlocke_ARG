package hello.presentation;

import hello.domain.Thing;

public class Say extends Command{
	String spoke;

	@Override
	public Command process() {
		return this;
	}

	@Override
	public Command parse(String[] s) {
		int x = 0;
		s[0] = "says,";
		spoke = actor.getName().concat(" ");
		while(x < (s.length)) {
			spoke = spoke.concat(s[x]).concat(" ");
			x++;
		}
		return this;
	}
	@Override
	public void output(Thing thing) {
		getGame().uComm.add(spoke);
	}

	@Override
	public void notifyBrain(Brain brain) {
		brain.receiveCommand(this);
	}

	@Override
	public void runCommand(Thing i) {
		getGame().commandQueue.add(this);
	}
	public void setSpoke(String s){
		spoke = s;
	}

}
