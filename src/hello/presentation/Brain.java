package hello.presentation;

public abstract class Brain {
	public Long key;
	public long owner;
	public void receiveCommand(Drop drop){}
	public void receiveCommand(Empty empty){}
	public void receiveCommand(Error error){}
	public void receiveCommand(Get get){}
	public void receiveCommand(Go go){}
	public void receiveCommand(Look look){}
	public void receiveCommand(Say say){}
	public void dispatchCommand(Command command){
		command.notifyBrain(this);
	}
	public void setId() {
		key = getGame().nextId();
		getGame().brainId.put(key, this);
	}
	public long getId() {
		return key;
	}
	protected Game getGame() {
		return Game.currentGame;
	}
}
