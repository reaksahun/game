 package game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Game {
	// FileOutput Stream- allows us to send data to a file
	// ObjectOutputStream - allows use to place objects on the stream 
	// ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
	// 		Stream.writeObject(object);
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> roomDesc = new HashMap<String, String>();
	public static Scanner scan = new Scanner(System.in);
	private static GUI gui;
	
	public static void main(String[] args) {
//		System.out.println("Welcome to your beautiful house. You have a party later on today with the cool kids"
//				+ "in your class but you misplaced your keys. Your job is to find the keys and make it to the party"
//				+ "or else you will be a big LOSER!");
		System.out.println(" ");
		//String playerCommand;
		currentRoom = World.buildWorld();
		gui = new GUI();
		Game.populateMap();
		Game.print(currentRoom);
		
	}
	
	public static Item getItem(String name) {
		for (Item i : inventory) {
			if(i.getName().equals(name)) {
				return i;
			}
		}return null;
	}
	
	public static void removeItem(String name) {
		
		int index = -1;
		for(int i=0; i<inventory.size(); i++) {
			Item x = inventory.get(i);
			if(x.getName().equals(name)) {
				index = i;
			}
		}
		
		if(index == -1) {
			Game.print("You are not carrying "+name);
		}else {
			inventory.remove(index);
		}
	}
	
	public static Room getCurrentRoom() {
		
		//gui.print(currentRoom.toString());
		return currentRoom;
	}
	
	
	
	public static void move(String direction) {
		Room nextRoom = currentRoom.getExit(direction.charAt(0));
		if(nextRoom != null) {
			if(nextRoom.isLocked()) {
				Game.print("The room is locked!");
				
			}else {
				currentRoom = nextRoom;
				Game.print(currentRoom);
			}
		} else {
			Game.print("You can't go that way");
		}
	}
	
	public static void print(Object message) {
		gui.print(message.toString());
		//System.out.print(message+"\n");
	}
	
	public static void processCommand(String playerCommand) {
		//do {
			System.out.println("What do you want to do? ");
			//playerCommand = scan.nextLine();
			String[] a;
			String item;
			a = playerCommand.split(" ");
			playerCommand = a[0];
			if (playerCommand.equals("i")) {
				if (inventory.isEmpty()) {
					Game.print("you are holding nothing");
				} else {
					for(Item i : inventory) {
					Game.print(i);
					}
				}
			} else if(playerCommand.equals("e")) {
				move(playerCommand);
			} else if (playerCommand.equals("w")) {
				move(playerCommand);
			} else if (playerCommand.equals("n")) {
				move(playerCommand);
			} else if (playerCommand.equals("s")) {
				move(playerCommand);
			} else if (playerCommand.equals("u")) {
				move(playerCommand);
			} else if (playerCommand.equals("d")) {
				move(playerCommand);
			} else if(playerCommand.equals("take")) {
				item = a[1];
				if(currentRoom.hasItem(item)) {
					Item itemName = currentRoom.getItem(item);
					itemName.take();
				}else {
					Game.print("There is no "+item+"!");
				}
			} else if(playerCommand.equals("use")) {
				String x = a[1];
				Item i = getItem(x);
				if(i == null) {
					Game.print("You dont have the " + a[1]);
				}else { 
					i.use();
					
				}
			} else if(playerCommand.equals("give")) {
				NPC npc = currentRoom.getNPC(a[3]);
				Item i = getItem(a[1]);
				if(npc == null) {
					Game.print("No one to give this item to");
				}else if(i == null) {
					Game.print("You dont have that item");
				}
				else {
					npc.give(i);
					
				}
				
			}else if(playerCommand.equals("look")) {
				Item y = getItem(a[1]);	
				NPC p = currentRoom.getNPC(a[1]);
				
				if (y == null) {
					y = currentRoom.getItem(a[1]);
				}
				if( y == null) {
					Game.print("There is no " + a[1] + "!");
				} else {
					y.look();
				}
				
				if (p == null) {
					p = currentRoom.getNPC(a[1]);
				}
				if( p == null) {
					Game.print("There is no " + a[1] + "!");
				}else {
					p.look();
				}
				
			}else if(playerCommand.equals("talk")) {
				
				NPC npc = currentRoom.getNPC(a[1]);
				if(npc == null) {
					Game.print("There is no "+ a[1]);
					
				}else {
					npc.talk();
				}
			}else if(playerCommand.equals("load")) {
				loadGame();
			}else if(playerCommand.equals("save")) {
				saveGame();
			}else if(playerCommand.equals("x")) {
				Game.print("Bye Bye!");
			} else {
				Game.print("You can't do that.");
			}
		//}while(!playerCommand.equals("x"));
		//scan.close();
		
	}
	
	public static void collectItem(String name) {
		if(currentRoom.hasItem(name)) {
			inventory.add(currentRoom.removeItem(name));
		}
		else {
			System.out.println("Nothing there");
		}
	}
	
	
	public static void populateMap() {
		try {
			Scanner scan = new Scanner(new File("rooms.txt")); 
			while(scan.hasNextLine()) {
				String room = scan.nextLine();
				String desc = scan.nextLine();
				scan.nextLine();
				roomDesc.put(room, desc);
			}
		}catch(FileNotFoundException ex) {
			Game.print("file not found");
		}
	}
	
	public static void saveGame() {
		
		try {
			File saveFile = new File("save");
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(World.rooms);
			stream.close();
			Game.print("Game save!");
		} catch (FileNotFoundException ex) {
			Game.print("Error accessing save file.");
		} catch (IOException e) {
			Game.print("Error: Cannot save file");
			e.printStackTrace();
			
		}
	}
	
	
	public static void loadGame() {	
			try {
				Game.print("Loading game...");
				File loadFile = new File("save");
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(loadFile));
				currentRoom = (Room) stream.readObject();
				inventory = (ArrayList<Item>) stream.readObject();
				World.rooms = (HashMap<String, Room>) stream.readObject();
				Game.print(currentRoom.getDesc());
				stream.close();
			} catch (ClassNotFoundException e) {
				Game.print("Error");
			} catch (IOException e) {
				Game.print("Error");
			}
			
		
	}
	
	
	
	
}
