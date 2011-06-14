package hello.presentation;

import hello.domain.Player;
import hello.domain.Thing;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	HashMap<String, Player> mapLogin = new HashMap<String, Player>();
	public HashMap<String, Command> mapCommand = new HashMap<String, Command>();
	public HashMap<Long, Object> objectId = new HashMap<Long, Object>();
	public HashMap<Long, Thing> linkId = new HashMap<Long, Thing>();
	public ArrayList<String> uComm = new ArrayList<String>();
	public ArrayList<Command> commandQueue = new ArrayList<Command>();
	Player currentPlayer;
	Thing character;
	Thing world;
	long currentId = 0;
	public boolean running = true;
	int mode = 0;
	public static Game currentGame;
	
	public static Game getGame() {
		return currentGame;
	}
	public Game() {
		currentGame = this;
	}	
	public long nextId() {
		return currentId++;
	}
	public void putThing(Thing t) {
		objectId.put(t.getId(), t);
	}
	public Thing getThing(long id) {
		return (Thing) objectId.get(id);
	}
	public void putBrain(Brain b) {
		objectId.put(b.getId(), b);
	}
	public Brain getBrain(long id) {
		return (Brain) objectId.get(id);
	}
	public void printOutput() {
		for(String str : uComm) {
			System.out.println(str);
		}
		uComm.clear();
	}
	public void addOutput(String s) {
		uComm.add(s);
	}	
	private void login(String readLine) {
		if(mapLogin.containsKey(readLine)) {
		currentPlayer = mapLogin.get(readLine);
		mode = 2;
		uComm.add("Please enter your password: ");
		} else {
			uComm.add("User not recognized.");
			mode = 0;
		}
		
	}
	private void checkPassword(String readLine) {
		if(readLine.equals(currentPlayer.getPassword())) {
			character = currentPlayer.getCharacter();
			uComm.add("You have sucessfully logged into [" + character.getName() + "]");
			uComm.add(character.getName() + " is " + character.getDescription());
			uComm.add("You find yourself " + character.getLocation().getDescription());
			uComm.add("What would you like to do?");
			mode = 1;
		} else {
			uComm.add("Password not recognized.  Please try again.");
			mode = 0;
		}
	}
	public void printLoginPrompt() {
		uComm.add("Please enter your username: ");
		printOutput();
	}
	public void processInput(String readLine) {
		String playerCommand[] = null;
		Command command;
		if(mode == 1) {
			playerCommand = readLine.split(" ");
			if(mapCommand.containsKey(playerCommand[0])) {
				command = mapCommand.get(playerCommand[0]);
				command = command.copy(character).parse(playerCommand);
				command = command.process();
				propagate(command);
			} else {
				uComm.add("That command is not recognized.");
			}
		} else if(mode == 2){
			checkPassword(readLine);
		} else {
			login(readLine);
		}
	}
	public void propagate(Command command) {
		for(Thing thing : command.actor.getLocation().getContents()) {
			if(thing.getBrain() != null) {
				thing.getBrain().dispatchCommand(command);
			}
		}
		while(!commandQueue.isEmpty()) {
			propagate(commandQueue.remove(0).process());			
		}
	}
	public Command getCommand(String s) {
		return mapCommand.get(s);
	}
	public void initializeGame() {
		Player p1 = new Player();
		Look look = new Look();
		Go go = new Go();
		Get get = new Get();
		Drop drop = new Drop();
		Empty empty = new Empty();
		Error error = new Error();
		Say say = new Say();
		GreedBrain gb1 = new GreedBrain();
		FriendlyBrain fb1 = new FriendlyBrain();
		NoseyBrain nb1 = new NoseyBrain();
		CharacterBrain pcb1 = new CharacterBrain();
		Thing m1r1 = new Thing();
		Thing m1r2 = new Thing();
		Thing c1 = new Thing();
		Thing npc002 = new Thing();
		Thing npc001 = new Thing();
		Thing npc003 = new Thing();
		Thing m1 = new Thing();
		Thing m2 = new Thing();
		Thing i1 = new Thing();
		Thing i2 = new Thing();
		world = new Thing();
		
		c1.setInfo(m1r1, "a short, slender young woman who appears to be in her twenties.\nDressed in a black body glove, she wears a black backpack covered in pockets.", ", a young woman", "Nightshade", "character");
		npc002.setInfo(m1r2, "a grim, pale-skinned man standing about five and a half feet tall; dressed in all black including trenchcoat and fedora hat.", ", a man in black", "Hemlocke", "character");
		npc001.setInfo(m1r1, "A greedy little puke", "Greedy Puke", "PunkDaddy", "character");
		npc003.setInfo(m1r1, "a nosey guy", ", this guy is nosey", "Cirano", "character");
		m1r1.setInfo(m1, "in an archway covered in years of unkept brambles.", " that is almost hidden", "an archway", "room");
		m1r1.addLink("north", m1r2.getId());
		m1r2.setInfo(m1, "in a clearing, in a very strange woods.", "", "forest clearing", "room");
		m1r2.addLink("south", m1r1.getId());
		m1.setLocation(world);
		m2.setLocation(world);
		i1.setInfo(i2, " ", "an ornate curved knife.", "knife", "item");
		i2.setInfo(m1r1, " ", "a plain looking box.", "box", "item");
		p1.setInfo("peartree", c1);
		c1.setBrain(pcb1);
		npc001.setBrain(gb1);
		npc002.setBrain(fb1);
		npc003.setBrain(nb1);
		world.addContent(m1);
		world.addContent(m2);
		mapLogin.put("jeremiah", p1);
		mapCommand.put("look", look);
		mapCommand.put("go", go);
		mapCommand.put("get", get);
		mapCommand.put("drop", drop);
		mapCommand.put("empty", empty);
		mapCommand.put("say", say);
		gb1.setGame(this);
		fb1.setGame(this);
		pcb1.setGame(this);
		nb1.setGame(this);
		go.setGame(this);
		get.setGame(this);
		drop.setGame(this);
		empty.setGame(this);
		error.setGame(this);
		look.setGame(this);
		say.setGame(this);
	}
}
