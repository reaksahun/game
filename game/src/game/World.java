package game;

import java.util.HashMap;

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	
	public static HashMap<String, Room> rooms = new HashMap<String, Room>();
	
	public static Room buildWorld() {
	Room livingRoom = new Room("Living Room");
	Room kitchen = new Room("Kitchen");
	Room basement = new Room("Basement");
	Room study = new Room("Study");
	Room stairs = new Room("Stairs");
	Room hallway = new Room("Hallway");
	Room yourRoom = new Room("Your Room");
	Room sisRoom = new Room("Sis Room");
	Room garage = new Room("Garage");
	Room backyard = new Room("Backyard");
	
	
	
	Item redKey = new redKey();
	Item chest = new Item("chest");
	Item blueKey = new blueKey();
	Item vinyl = new Vinyl();
	Item recordPlayer = new Item("recordPlayer");
	Item sink = new Item("sink");
	Item car = new Item("car");
	Item money = new Money();
	Item treat = new Item("treat");
	
	 
	livingRoom.addExit(kitchen, 'e');
	livingRoom.addExit(garage, 'w');
	livingRoom.addNPC(new Dad());
	livingRoom.addItem(money);
	livingRoom.addNPC(new Puppy());
	garage.addExit(livingRoom, 'e');
	kitchen.addExit(livingRoom, 'w');
	kitchen.addExit(basement,'d');
	kitchen.addItem(sink);
	kitchen.addItem(treat);
	kitchen.addItem(redKey);
	redKey.setDesc("small red key");
	backyard.addExit(kitchen, 's');
	basement.setLocked(true);
	basement.addExit(kitchen, 'u');
	kitchen.addExit(study,'s');
	kitchen.addExit(backyard, 'n');
	sink.setDesc("You look down into the sink and see something shiny"
			+ "it's too far to reach with your bare hands");
	study.addExit(kitchen, 'n');
	sink.setHeavy(true);
	study.setLocked(true);
	yourRoom.addItem(blueKey);
	study.addItem(vinyl);
	vinyl.setDesc("one direction vinyl record");
	blueKey.setDesc("small blue key");
	livingRoom.addExit(stairs,'u');
	stairs.addExit(yourRoom, 'w');
	stairs.addExit(livingRoom, 'd');
	stairs.addExit(hallway, 'n');
	hallway.addExit(stairs, 's');
	hallway.addExit(sisRoom, 'e');
	sisRoom.addExit(hallway,'w');
	sisRoom.addNPC(new Sister());
	sisRoom.addItem(recordPlayer);
	recordPlayer.setDesc("old fasion record player");
	recordPlayer.setHeavy(true);
	stairs.addItem(chest);
	chest.setDesc("wooden old chest");
	chest.setHeavy(true);
	yourRoom.addExit(stairs, 'e');
	garage.addItem(car);
	car.setHeavy(true);
	car.setDesc("Rusty broken down mini van handed down from your mom");
	
	
	
	
	return livingRoom;
	}
}
