package domain;

import java.util.HashSet;

public class Thing {
	String description;
	String name;
	String type;
	Thing location;
	HashSet<Thing> contents;
	
	public void setInfo(String d, String n, String t) {
		description = d;
		name = n;
		type = t;
	}
	public void setLocation(Thing l) {
		location = l;
	}
	public String getName() {
		return name;
	}
	public Thing getLocation() {
		return location;
	}
	public String getDescription() {
		return description;		
	}
}
