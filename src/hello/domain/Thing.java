package hello.domain;

import java.util.HashMap;
import java.util.HashSet;

public class Thing {
	String description;
	String name;
	String type;
	String shortdesc;
	Thing location;
	private HashSet<Thing> contents = new HashSet<Thing>();
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
	public String getShortDesc() {
		return shortdesc;
	}
	public Thing getLink(String s) {
		return links.get(s);
	}
	public void addContent(Thing t) {
		getContents().add(t);
	}
	public void removeContent(Thing t) {
		getContents().remove(t);
	}
	public void addLink(String s, Thing t) {
		links.put(s, t);
	}
	public void removeLink(String s, Thing t) {
		links.remove(s);
	}
	public boolean containsLink(String s) {
		return links.containsKey(s);
	}
	public void moveTo(Thing t, String[] s) {
		Thing target;
		
		if(t.type.equalsIgnoreCase("character")) {
			target = t.getLocation().getLink(s[1]);
			t.getLocation().removeContent(t);
			t.setLocation(target);
			target.addContent(t);
		}else if(t.type.equalsIgnoreCase("item")) {
			target = t;
		}
	}
	public Thing idTarget(String t) {
		Thing target = null;
		
		for(Thing thing : getContents()) {
			if(thing.getName().equalsIgnoreCase(t)) {
				target = thing;
			}
		}
		return target;
	}
	public String describe() {
		String d = this.name.concat(";").concat(this.shortdesc).concat(";");
		
		for(Thing thing : getContents()) {
			d = d.concat(thing.getName()).concat(";");
		}
		
		return d;
	}
	public void setContents(HashSet<Thing> contents) {
		this.contents = contents;
	}
	public HashSet<Thing> getContents() {
		return contents;
	}
}
