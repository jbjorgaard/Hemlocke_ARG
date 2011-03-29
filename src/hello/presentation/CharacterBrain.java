package hello.presentation;

public class CharacterBrain extends Brain {
	Game game;
	
	public void setGame(Game g) {
		game = g;
	}
	
	@Override
	public void receiveCommand(Look look) {
		game.uComm.add("NightshadeBrain: You just looked at something.");
	}
}
