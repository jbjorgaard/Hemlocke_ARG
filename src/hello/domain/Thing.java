package hello.domain;

import hello.presentation.Brain;
import hello.presentation.Game;

import java.util.HashMap;
import java.util.HashSet;

public class Thing {
	Long key;
	String description;
	String name;
	String type;
	String shortdesc;
	Brain brain;
	Long location;
	private HashSet<Long> contents = new HashSet<Long>();
	private HashMap<String, Thing> links = new HashMap<String, Thing>();
	
	public void setInfo(Thing l, String d, String sd, String n, String t) {
		this.location = l.getId();
		l.addContent(this.key);
		description = d;
		shortdesc = sd;
		name = n;
		type = t;
	}
	public void setId() {
		key = Game.currentGame.nextId();
		Game.currentGame.objectId.put(key, this);
	}
	public long getId() {
		return key;
	}
	public void setLocation(Thing l) {
		location = l.getId();
	}
	public String getName() {
		return name;
	}
	public Thing getLocation() {
		return Game.currentGame.getThing(location);
	}
	public String getDescription() {
		return description;		
	}
	public String getShortDesc() {
		return shortdesc;
	}
	public Thing getLink(String s) {
		return getLinks().get(s);
	}
	public void addContent(Thing t) {
		getContents().add(t);
	}
	public void removeContent(Thing t) {
		getContents().remove(t);
	}
	public void addLink(String s, Thing t) {
		getLinks().put(s, t);
	}
	public void removeLink(String s, Thing t) {
		getLinks().remove(s);
	}
	public boolean containsLink(String s) {
		return getLinks().containsKey(s);
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
		for(Thing thing : getContents()) {
			if(thing.getName().equalsIgnoreCase(t)) {
				return thing;
			}
		}
		return null;
	}
	public String describe() {
		String d = this.name.concat(";").concat(this.shortdesc).concat(";");
		
		for(Thing thing : getContents()) {
			d = d.concat(thing.getName()).concat(";");
		}
		
		return d;
	}
	public void setContents(HashSet<Long> contents) {
		this.contents = contents;
	}
	public HashSet<Long> getContents() {
		return contents;
	}
	@Override
	public String toString() {
		return describe();
	}
	public void setBrain(Brain b) {
		brain = b;
		b.owner = this;
	}
	public Brain getBrain() {
		return brain;
	}
	void setLinks(HashMap<String, Thing> links) {
		this.links = links;
	}
	HashMap<String, Thing> getLinks() {
		return links;
	}
}
