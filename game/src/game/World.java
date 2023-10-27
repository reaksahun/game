package game;

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
	Room livingRoom = new Room("Living Room","You are in the living room, you can go east to the kitchen or up the stairs."
			+ " or south to outside. You notice something sticking out from under the couch");
	Room kitchen = new Room("Kitchen","You are in the kitchen, you can go south into the study or west to the living room"
			+ " or down the stairs into the basement. There is a wand on the kitchen island"
			+ "there is also a sink in the kitchen that seems be a little wet");
	Room basement = new Room("Basement","You are down in the spooky scary basement"
			+ " You can go up back into the kitchen");
	Room study = new Room("Study","You are now in the study, you can go north into the kitchen"
			+ "there are some vinyls in this room, and a rusty old key");
	Room stairs = new Room("Stairs","You are now upstairs, you can go down back to the living room or west into your room"
			+ " or north down the hallway. There is a chest on the stairs");
	Room hallway = new Room("Hallway","You are in the hallway, you can go south back to the stairs"
			+ " or east into your sister's room");
	Room yourRoom = new Room("yourRoom","You are now in your room, you can go east back to the stairs "
			+ "You have a sower in this room");
	Room sisRoom = new Room("Sisroom","You're in your sister's bedroom, the room is filled with posters of british singing boys"
			+ " You can go west back into the hallway. Your sister has a record player in this room");
	Room porch = new Room("Porch","You are outside, you can go north to go back inside"
			+ " or you can do east to your car");
	Room car = new Room("Car","Your shiny new car. You can go west back to your porch");
	Item wallet = new Item("wallet");
	Item wand = new Wand();
	Item chest = new Item("chest");
	Item chestKey = new ChestKey();
	Item chain = new Chain();
	Item goo = new Item("goo");
	Item shower = new Shower();
	Item vinyl = new Vinyl();
	Item recordPlayer = new Item("recordPlayer");
	Item sink = new Item("sink");
	
	 
	livingRoom.addExit(kitchen, 'e');
	livingRoom.addExit(porch, 's');
	porch.addExit(livingRoom, 'n');
	porch.addExit(car, 'e');
	car.addExit(porch, 'w');
	car.setLocked(true);
	livingRoom.addItem(wallet);
	wallet.setDesc("Your Dad's wallet which happened to have $20 in it");
	kitchen.addExit(livingRoom, 'w');
	kitchen.addItem(wand);
	kitchen.addExit(basement,'d');
	kitchen.addItem(sink);
	basement.addExit(kitchen, 'u');
	basement.addItem(chain);
	basement.addItem(goo);
	goo.setSlimy(true);
	chain.setDesc("a rusty metal chain that hangs from the ceiling");
	chain.setHeavy(true);
	wand.setDesc("sparkly wand");
	kitchen.addExit(study,'s');
	sink.setDesc("You look down into the sink and see something shiny"
			+ "it's too far to reach with your bare hands");
	study.addExit(kitchen, 'n');
	sink.setHeavy(true);
	study.setLocked(true);
	study.addItem(chestKey);
	study.addItem(vinyl);
	vinyl.setDesc("one direction vinyl record");
	chestKey.setDesc("rusty skull key");
	livingRoom.addExit(stairs,'u');
	stairs.addExit(yourRoom, 'w');
	stairs.addExit(livingRoom, 'd');
	stairs.addExit(hallway, 'n');
	hallway.addExit(stairs, 's');
	hallway.addExit(sisRoom, 'e');
	sisRoom.addExit(hallway,'w');
	sisRoom.addItem(recordPlayer);
	recordPlayer.setDesc("old fasion record player");
	recordPlayer.setHeavy(true);
	stairs.addItem(chest);
	chest.setDesc("wooden old chest");
	chest.setHeavy(true);
	yourRoom.addExit(stairs, 'e');
	yourRoom.addItem(shower);
	shower.setHeavy(true);
	shower.setDesc("sparkly clean shower");
	
	
	
	return livingRoom;
	}
}
