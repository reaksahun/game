 package game;
import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playerCommand;
		currentRoom = World.buildWorld();
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
					if(itemName.isHeavy()) {
						System.out.println("That's too heavy to carry around");
					}else if(itemName.isSlimy()) {
						System.out.println("can't take slimy goo");
					}else {
						inventory.add(currentRoom.removeItem(item));
						System.out.println("You picked up "+itemName);
					}
				}else {
					System.out.println("There is no "+item+"!");
				}
			} else if(playerCommand.equals("use")) {
				String x = a[1];
				
					if(x == null) {
						System.out.println("You dont have the " + a[1]);
					
					}else { 
						Item i = getItem(x);
						i.use();
					
					}
				if(x.equals("chain")) {
					Item y = currentRoom.getItem("chain");
					y.use();
				}
				if(x.equals("shower")) {
					Item s = currentRoom.getItem("shower");
					s.use();
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
		for( int i = 0; i < inventory.size(); i++) {
			Item x = inventory.get(i);
			if(x.getName().equals(name)) {
				inventory.remove(i);
			}else
				System.out.println("there is no item " + name + " in inventory");
		}
	}
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void move(String direction) {
		Room nextRoom = currentRoom.getExit(direction.charAt(0));
		if(nextRoom != null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked");
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
	
	
	
}
