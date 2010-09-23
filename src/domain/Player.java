package domain;

public class Player {
	String password;
	Thing character;

	public void setInfo(String p, Thing c) {
		this.setPassword(p);
		this.setCharacter(c);
	}
	public void setPassword(String p) {
		password = p;
	}
	public String getPassword(){
		return password;
	}
	public void setCharacter(Thing c) {
		character = c;
	}
	public Thing getCharacter() {
		return character;
	}
}
