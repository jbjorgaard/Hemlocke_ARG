package domain;

import java.util.HashMap;
import java.util.HashSet;

public class Thing {
	String description;
	String name;
	String type;
	String shortdesc;
	Thing location;
	HashSet<Thing> contents = new HashSet<Thing>();
	HashMap<String, Thing> links = new HashMap<String, Thing>();
	
	public void setInfo(Thing l, String d, String sd, String n, String t) {
		this.setLocation(l);
		l.addContent(this);
		description = d;
		shortdesc = sd;
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
	public void describe() {
		if(this.type.equals("room")) {
			System.out.println("You are in " + this.getDescription());
			if(!contents.isEmpty()) {
				System.out.println("In the " + this.getName() + " you see: ");
				this.listContents();
			} else {
				System.out.println(this.getName() + " appears to be empty.");
			}
		} else if(this.type.equals("character")) {
			System.out.println("You see " + this.getName() + this.getShortDesc());
			if(!contents.isEmpty()) {
				System.out.println("On " + this.getName() + " you see: ");
				this.listContents();
			} else {
				System.out.println(this.getName() + " does not appear to be carrying anything.");
			}			
		} else {
			System.out.println("You see " + this.getName() + this.getShortDesc());
			if(!contents.isEmpty()) {
				System.out.println(" In " + this.getName() + " you see: ");
				this.listContents();
			} else {
				System.out.println(this.getName() + " does not appear to have anything inside of it.");
			}
		}
	}
	public void listContents() {
		for(Thing thing : contents) {
			System.out.println("[" + thing.getName() + "]" + thing.getShortDesc());
		}
	}
	private String getShortDesc() {
		return shortdesc;
	}
	public void listContent(String s) {
		Thing target = null;
		for(Thing thing : contents) {
			if(thing.getName().equals(s)) {
				target = thing;
			}
		}
		if(target != null) {
			target.describe();			
		} else {
			System.out.println("Cannot find what you were looking for.");
		}
	}
	public Thing identifyContent(String s) {
		Thing item = null;
		for(Thing thing : contents) {
			if(thing.getName().equals(s)) {
				item = thing;
			}
		}
		return item;
	}
	public void moveTo(Thing t, String[] s) {
		Thing target;
		
		if(t.type.equals("character")) {
			target = t.getLocation().getLink(s[1]);
			t.getLocation().removeContent(t);
			t.setLocation(target);
			target.addContent(t);
		}else if(t.type.equals("item")) {
			target = t;
		}
	}
}
