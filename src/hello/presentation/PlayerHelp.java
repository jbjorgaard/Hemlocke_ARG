package hello.presentation;

public class PlayerHelp {
	Game g1;
	
	public void setGame(Game game) {
		g1 = game;
	}
	
	public void help() {
		g1.uComm.add("LIST OF AVAILABLE COMMANDS");
		g1.uComm.add("look <left, right, up, down, forward, back>");
		g1.uComm.add("go <forward, left, right, back>");
		g1.uComm.add("get <itemname>");
		g1.uComm.add("drop <itemname>");
		g1.uComm.add("quit -logs out of character-");
		g1.uComm.add("exit -closes game client-");		
	}

}
