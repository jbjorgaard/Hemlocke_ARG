package domain;

public class Player {
	String password;
	GameObject character;

	public void setPassword(String p) {
		password = p;
	}
	public String getPassword(){
		return password;
	}
	public void setCharacter(GameObject g) {
		character = g;
	}
	public GameObject getCharacter() {
		return character;
	}
}
