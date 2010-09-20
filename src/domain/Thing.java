package domain;

import java.util.HashMap;
import java.util.HashSet;

public class Thing {
	String description;
	String name;
	String type;
	Thing location;
	HashSet<Thing> contents = new HashSet<Thing>();
	HashMap<String, Thing> links = new HashMap<String, Thing>();
	
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
	public void addContent(Thing t) {
		contents.add(t);
	}
	public void removeContent(Thing t) {
		contents.remove(t);
	}
	public void addLink(String s, Thing t) {
		links.put(s, t);
	}
	public void removeLink(String s, Thing t) {
		links.remove(s);
	}
	public Thing getLink(String s) {
		return links.get(s);
	}
	public boolean containsLink(String s) {
		return links.containsKey(s);
	}
}
