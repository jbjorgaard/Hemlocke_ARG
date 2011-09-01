package hello.presentation;

import hello.domain.Player;
import hello.domain.Thing;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import persistence.SqlMapper;
import dataswarm.mybatis.SqliteDataSource;

public class Game {
	HashMap<String, Player> mapLogin = new HashMap<String, Player>();
	public HashMap<String, Command> mapCommand = new HashMap<String, Command>();
	public HashMap<Long, Thing> thingId = new HashMap<Long, Thing>();
	public HashMap<Long, Thing> linkId = new HashMap<Long, Thing>();
	public HashMap<Long, Brain> brainId = new HashMap<Long, Brain>();
	public ArrayList<String> uComm = new ArrayList<String>();
	public ArrayList<Command> commandQueue = new ArrayList<Command>();
	Player currentPlayer;
	Thing character;
	Thing world;
	long currentId = 0;
	public boolean running = true;
	int mode = 0;
	public static Game currentGame = new Game();
	private static SqlMapper m;
	
	public static Game getGame() {
		return currentGame;
	}
	public long nextId() {
		return currentId++;
	}
	public void putThing(Thing t) {
		thingId.put(t.getId(), t);
	}
	public Thing getThing(long id) {
		return thingId.get(id);
	}
	public void putBrain(Brain b) {
		brainId.put(b.getId(), b);
	}
	public Brain getBrain(long id) {
		return brainId.get(id);
	}
	public void putLink(Thing l) {
		linkId.put(l.getId(), l);
	}
	public Thing getLinkThing(long id) {
		return linkId.get(id);
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
	public void initializeGame() throws SQLException{
		Player p1 = new Player();
		Look look = new Look();
		Go go = new Go();
		Get get = new Get();
		Drop drop = new Drop();
		Empty empty = new Empty();
//		Error error = new Error();
		Say say = new Say();
		Thing world = new Thing();
		Thing r1 = new Thing();
		Thing r2 = new Thing();
		Thing c1 = new Thing();
		Thing npc002 = new Thing();
		Thing npc001 = new Thing();
		Thing npc003 = new Thing();
		Thing i1 = new Thing();
		Thing i2 = new Thing();
		GreedBrain gb1 = new GreedBrain();
		FriendlyBrain fb1 = new FriendlyBrain();
		NoseyBrain nb1 = new NoseyBrain();
		CharacterBrain pcb1 = new CharacterBrain();
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, new SqliteDataSource("sqlite://tmp/hemlockedb"));
		Configuration configuration = new Configuration(environment);
		configuration.setCacheEnabled(true);
		configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
		configuration.setUseColumnLabel(true);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		configuration.addMapper(SqlMapper.class);
		
		try {
			Statement st = session.getConnection().createStatement();
			for (String stmt : SqlMapper.CREATE_TABLES) {
				st.execute(stmt);
			}
			session.commit(true);
			st.close();
			m = session.getMapper(SqlMapper.class);
			/* Create and insert Things into db + brains and links.  Write constructors for each */			
//			Person fred = insertPerson(new Person("fred", "123 Elm Street"));
//			Person joe = insertPerson(new Person("joe", "555 Phonebook Terrace"));
//			Person mary = insertPerson(new Person("mary", "1313 Mockingbird Lane"));
//			m.insertFriend(fred, joe);
//			m.insertFriend(fred, mary);
//			m.insertFriend(joe, mary);
//			Person fred2 = m.getPersonByName("fred");
//			System.out.println(fred2);
//			System.out.println("fred1: " + fred + ", fred2: " + fred2 + ", fred3: " + fred2.friends.get(0).friends.get(0).hashCode());
		} finally {
			session.close();
		}
		
		world.setId();
		r1.setId();
		currentGame.linkId.put(r1.getId(), r1);
		r2.setId();
		currentGame.linkId.put(r2.getId(), r2);
		c1.setId();
		currentGame.thingId.put(c1.getId(), c1);
		npc001.setId();
		currentGame.thingId.put(npc001.getId(), npc001);
		npc002.setId();
		currentGame.thingId.put(npc002.getId(), npc002);
		npc003.setId();
		currentGame.thingId.put(npc003.getId(), npc003);
		i1.setId();
		currentGame.thingId.put(i1.getId(), i1);
		i2.setId();
		currentGame.thingId.put(i2.getId(), i2);
		pcb1.setId();
		currentGame.brainId.put(pcb1.getId(), pcb1);
		gb1.setId();
		currentGame.brainId.put(gb1.getId(), gb1);
		fb1.setId();
		currentGame.brainId.put(fb1.getId(), fb1);
		nb1.setId();
		currentGame.brainId.put(nb1.getId(), nb1);
		c1.setBrain(pcb1);
		npc001.setBrain(gb1);
		npc002.setBrain(fb1);
		npc003.setBrain(nb1);
		
		c1.setInfo(r1, "a short, slender young woman who appears to be in her twenties.\nDressed in a black body glove, she wears a black backpack covered in pockets.", ", a young woman", "Nightshade", 1);
		npc002.setInfo(r2, "a grim, pale-skinned man standing about five and a half feet tall; dressed in all black including trenchcoat and fedora hat.", ", a man in black", "Hemlocke", 1);
		npc001.setInfo(r1, "A greedy little puke", "Greedy Puke", "PunkDaddy", 1);
		npc003.setInfo(r1, "a nosey guy", ", this guy is nosey", "Cirano", 1);
		r1.setInfo(world, "in an archway covered in years of unkept brambles.", " that is almost hidden", "an archway", 2);
		r1.addLink("north", r2.getId());
		r2.setInfo(world, "in a clearing, in a very strange woods.", "", "forest clearing", 2);
		r2.addLink("south", r1.getId());
		i1.setInfo(i2, " ", "an ornate curved knife.", "knife", 3);
		i2.setInfo(r1, " ", "a plain looking box.", "box", 3);
		p1.setInfo("peartree", c1);
		world.addContent(r1.getId());
		world.addContent(r2.getId());
		mapLogin.put("jeremiah", p1);
		mapCommand.put("look", look);
		mapCommand.put("go", go);
		mapCommand.put("get", get);
		mapCommand.put("drop", drop);
		mapCommand.put("empty", empty);
		mapCommand.put("say", say);
	}
}
