package hello.domain;

import hello.presentation.Brain;
import hello.presentation.Game;

import java.util.HashMap;
import java.util.HashSet;

public class Thing {
	Long key;
	int type;
	String name;
	String shortdesc;
	String description;	
	Long brain;
	Long location;
	private HashSet<Long> contents = new HashSet<Long>();
	private HashMap<String, Long> links = new HashMap<String, Long>();
	
	public void setInfo(Thing l, String d, String sd, String n, int t) {
		this.location = l.getId();
		l.addContent(this.key);
		description = d;
		shortdesc = sd;
		name = n;
		type = t;
	}
	protected Game getGame() {
		return Game.currentGame;
	}
	public void setId() {
		key = getGame().nextId();
		getGame().thingId.put(key, this);
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
		return getGame().getThing(location);
	}
	public String getDescription() {
		return description;		
	}
	public String getShortDesc() {
		return shortdesc;
	}
	public Thing getLink(String s) {
		return getGame().linkId.get(links.get(s));
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
	public Thing idTarget(String t) {
		for(Thing thing : getContents()) {
			if(thing.getName().equalsIgnoreCase(t)) {
				return thing;
			}
		}
		return null;
	}
	public String describe() {
//		String d = this.name.concat(";").concat(this.shortdesc).concat(";");
		String d = "";
		
		for(Thing thing : getContents()) {
			d = d.concat("[" + thing.getName() + "]").concat("; ");
		}
		
		return d;
	}
	public void setContents(HashSet<Long> contents) {
		this.contents = contents;
	}
	public HashSet<Thing> getContents() {
		HashSet<Thing> currentContents = new HashSet<Thing>();
		
		for(Long cKey : contents) {
			if(getGame().thingId.containsKey(cKey)) {
				currentContents.add(getGame().getThing(cKey));
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
		b.owner = this.getId();
	}
	public Brain getBrain() {
		return getGame().brainId.get(brain);
	}
	void setLinks(HashMap<String, Long> links) {
		this.links = links;
	}
	HashMap<String, Long> getLinks() {
		return links;
	}
}
