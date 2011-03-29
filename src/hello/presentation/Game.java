package hello.presentation;

import hello.domain.Player;
import hello.domain.Thing;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	HashMap<String, Player> mapLogin = new HashMap<String, Player>();
	public HashMap<String, Command> mapCommand = new HashMap<String, Command>();
	public ArrayList<String> uComm = new ArrayList<String>();
	Player currentPlayer;
	Thing character;
	Thing world;
	public boolean running = true;
	int mode = 0;
	
	
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
				command = command.copy().parse(playerCommand);
				command = command.process(character);
				command.output();
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
				command.notifyBrain(thing.getBrain());
			}
		}
	}
	public Command getCommand(String s) {
		return mapCommand.get(s);
	}
	public void initializeGame() {
		Player p1 = new Player();
		Player p2 = new Player();
		Look look = new Look();
		Go go = new Go();
		Get get = new Get();
		Drop drop = new Drop();
		Empty empty = new Empty();
		Error error = new Error();
		GreedBrain gb1 = new GreedBrain();
		CharacterBrain pcb1 = new CharacterBrain();
		CharacterBrain pcb2 = new CharacterBrain();
		Thing m1r1 = new Thing();
		Thing m1r2 = new Thing();
		Thing c1 = new Thing();
		Thing c2 = new Thing();
		Thing npc001 = new Thing();
		Thing m1 = new Thing();
		Thing m2 = new Thing();
		Thing i1 = new Thing();
		Thing i2 = new Thing();
		world = new Thing();
		
		c1.setInfo(m1r1, "a short, slender young woman who appears to be in her twenties.\nDressed in a black body glove, she wears a black backpack covered in pockets.", ", a young woman", "Nightshade", "character");
		c2.setInfo(m1r2, "a grim, pale-skinned man standing about five and a half feet tall; dressed in all black including trenchcoat and fedora hat.", ", a man in black", "Hemlocke", "character");
		m1r1.setInfo(m1, "in an archway covered in years of unkept brambles.", " that is almost hidden", "an archway", "room");
		m1r1.addLink("north", m1r2);
		m1r2.setInfo(m1, "in a clearing, in a very strange woods.", "", "forest clearing", "room");
		m1r2.addLink("south", m1r1);
		m1.setLocation(world);
		m2.setLocation(world);
		i1.setInfo(i2, " ", "an ornate curved knife.", "knife", "item");
		i2.setInfo(m1r1, " ", "a plain looking box.", "box", "item");
		p1.setInfo("peartree", c1);
		p2.setInfo("plumtree", c2);
		npc001.setBrain(gb1);
		c1.setBrain(pcb1);
		c2.setBrain(pcb2);
		world.addContent(m1);
		world.addContent(m2);
		mapLogin.put("jeremiah", p1);
		mapLogin.put("bill", p2);
		mapCommand.put("look", look);
		mapCommand.put("go", go);
		mapCommand.put("get", get);
		mapCommand.put("drop", drop);
		mapCommand.put("empty", empty);
		gb1.setGame(this);
		pcb1.setGame(this);
		pcb2.setGame(this);
		go.setGame(this);
		get.setGame(this);
		drop.setGame(this);
		empty.setGame(this);
		error.setGame(this);
		look.setGame(this);
	}
}
