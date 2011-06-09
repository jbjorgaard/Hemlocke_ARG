package hello.domain;

import hello.presentation.Brain;
import hello.presentation.Game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.bcel.generic.NEW;

public class Thing {
	Long key;
	String description;
	String name;
	String type;
	String shortdesc;
	Brain brain;
	Long location;
//	private Map<Long, Thing> contents = new HashMap<Long, Thing>();
	private HashSet<Long> contents = new HashSet<Long>();
	private HashMap<String, Thing> links = new HashMap<String, Thing>();
	
	public void setInfo(Thing l, String d, String sd, String n, String t) {
		this.location = l.getId();
		l.addContent(this);
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
	public void addLink(String s, Thing t) {
		getLinks().put(s, t);
	}
	public void removeLink(String s, Thing t) {
		getLinks().remove(s);
	}
	public boolean containsLink(String s) {
		return getLinks().containsKey(s);
	}
	public Thing idTarget(String t) {
		for(Map.Entry<Long, Thing> entry : contents.entrySet()) {
			if(entry.getValue().getName().equalsIgnoreCase(t)) {
				return entry.getValue();
			}
		}
		return null;
	}
	public String describe() {
		String d = this.name.concat(";").concat(this.shortdesc).concat(";");
		
		for(Map.Entry<Long, Thing> entry : contents.entrySet()) {
			d = d.concat(entry.getValue().getName()).concat(";");
		}
		
		return d;
	}
	public void addContent(Thing t) {
		contents.add(t.key);
	}
	public void removeContent(Thing t) {
		getContents().remove(t.key);
	}
	public void setContents(HashSet<Long> contents) {
		this.contents = contents;
	}
	public HashMap<String, Thing> getContents() {
		HashMap<String, Thing> contentObjects = new HashMap<String, Thing>();
		
		for(Long id : contents) {
			if(Game.currentGame.objectId.containsKey(id)) {
				contentObjects.put(Game.currentGame.getThing(id).getName(), Game.currentGame.getThing(id));
			}
		}
		return contentObjects;
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
