package domain;

public class Player {
	String password;
	Thing character;

	public void setPassword(String p) {
		password = p;
	}
	public String getPassword(){
		return password;
	}
	public void setCharacter(Thing g) {
		character = g;
	}
	public Thing getCharacter() {
		return character;
	}
}
