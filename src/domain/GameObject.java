package domain;

public class GameObject {
	String description;
	String name;
	String type;
	GameObject location;
	
	public void setInfo(String d, String n, String t) {
		description = d;
		name = n;
		type = t;
	}
	public void setLocation(GameObject l) {
		location = l;
	}
	public String getName() {
		return name;
	}
	public GameObject getLocation() {
		return location;
	}
	public String getDescription() {
		return description;		
	}
}
