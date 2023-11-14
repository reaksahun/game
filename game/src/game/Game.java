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
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to your beautiful house. You have a party later on today with the cool kids"
				+ "in your class but you misplaced your keys. Your job is to find the keys and make it to the party"
				+ "or else you will be a big LOSER!");
		System.out.println(" ");
		Scanner scan = new Scanner(System.in);
		String playerCommand;
		currentRoom = World.buildWorld();
		Game.populateMap();
		System.out.println(currentRoom);
		do {
			System.out.print("What do you want to do?");
			playerCommand = scan.nextLine();
			String[] a;
			String item;
			a = playerCommand.split(" ");
			playerCommand = a[0];
//			currentRoom = World.buildWorld();
//			System.out.println(currentRoom);
			if (playerCommand.equals("i")) {
				if (inventory.isEmpty()) {
					System.out.println("you are carrying nothing");
				} else {
					for(Item i : inventory) {
					System.out.println(i);
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
					System.out.println("There is no "+item+"!");
				}
			} else if(playerCommand.equals("use")) {
				String x = a[1];
				Item i = getItem(x);
				if(i == null) {
					System.out.println("You dont have the " + a[1]);
				}else { 
					//Item i = getItem(x);
					i.use();
					
				}
				
			}else if(playerCommand.equals("look")) {
				Item y = getItem(a[2]);	
				if (y == null) {
					y = currentRoom.getItem(a[2]);
				}
				if( y == null) {
					System.out.println("There is no " + a[2] + "!");
				}
				
				else {
					y.look();
				}
			}else if(playerCommand.equals("load")) {
				loadGame();
			}else if(playerCommand.equals("save")) {
				saveGame();
			} else {
				System.out.println("Invalid command.");
			}
		} while(!playerCommand.equals("x"));
		scan.close();
		
	}
	
	public static Item getItem(String name) {
		for (Item i : inventory) {
			if(i.getName().equals(name)) {
				return i;
			}
		}return null;
	}
	
	public static void removeItem(String name) {
		
		int index = 0;
		for(int i=0; i<inventory.size(); i++) {
			Item x = inventory.get(i);
			if(x.getName().equals(name)) {
				index = i;
			}
		}
		inventory.remove(index);
	}
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void move(String direction) {
		Room nextRoom = currentRoom.getExit(direction.charAt(0));
		if(nextRoom != null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked!");
				
			}else {
				currentRoom = nextRoom;
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way");
		}
	}
	
	public static void print(String message) {
		System.out.print(message+"\n");
	}
	
	public static void collectItem(String name) {
		if(currentRoom.hasItem(name)) {
			inventory.add(currentRoom.removeItem(name));
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
			Game.print("Game save");
		} catch (IOException e) {
			Game.print("Error: Cannot save file");
			e.printStackTrace();
			
		}
	}
	
	public static void loadGame() {	
			try {
				File loadFile = new File("save");
				ObjectInputStream stream = new ObjectInputStream(new FileInputStream(loadFile));
				currentRoom = (Room) stream.readObject();
				inventory = (ArrayList<Item>) stream.readObject();
				World.rooms = (HashMap<String, Room>) stream.readObject();
				stream.close();
			} catch (ClassNotFoundException e) {
				Game.print("Error");
			} catch (IOException e) {
				Game.print("Error");
			}
			
		
	}
	
	
	
	
}
