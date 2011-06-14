package hello.domain;

import hello.presentation.Brain;
import hello.presentation.Game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Thing {
	Long key;
	String description;
	String name;
	String type;
	String shortdesc;
	Long brain;
	Long location;
	private HashSet<Long> contents = new HashSet<Long>();
	private HashMap<String, Long> links = new HashMap<String, Long>();
	
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
	public Thing getLink(Long s) {
		return (Thing) Game.currentGame.objectId.get(s);
	}
	public void addContent(Long k) {
		contents.add(k);
	}
	public void removeContent(Thing t) {
		getContents().remove(t);
	}
	public void addLink(String s, Long l) {
		getLinks().put(s, l);
	}
	public void removeLink(String s, Thing t) {
		getLinks().remove(s);
	}
	public boolean containsLink(Long l) {
		return getLinks().containsKey(l);
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
	public HashSet<Thing> getContents() {
		HashSet<Thing> currentContents = new HashSet<Thing>();
		
		for(Long cKey : contents) {
			if(Game.currentGame.objectId.containsKey(cKey)) {
				currentContents.add(Game.currentGame.getThing(cKey));
			}
		}
		return currentContents;
	}
	@Override
	public String toString() {
		return describe();
	}
	public void setBrain(Brain b) {
		brain = b.getId();
		b.owner = this;
	}
	public Long getBrain() {
		return brain;
	}
	void setLinks(HashMap<String, Long> links) {
		this.links = links;
	}
	HashMap<String, Long> getLinks() {
		return links;
	}
}
