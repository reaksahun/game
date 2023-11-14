
package game;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable{
	
	//private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked; //is the room locked?
	private String name;
	private String roomID;
	
	
	private HashMap<String, Item> roomItems; 
	
	public Room(String n) {
		//description = d;
		locked = false;
		name = n;
		roomID = n;
		roomItems = new HashMap<String, Item>();
		World.rooms.put(name, this); // Room object places itself in the map
	}
	public String getName(){
		return name;
	}
	
	
	public void setRoomID(String id) {
		roomID = id;
		
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public Item removeItem(String name) {
		Item it = roomItems.get(name);
		roomItems.remove(name);
		return it;
	}
	
	
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public Item getItem(String item) {
		return roomItems.get(item);
	}
	
		// return roomItems.remove(name);
	public Room getExit(char direction) {
		if(direction == 'e') {
			return east;
		}else if(direction == 'w') {
			return west;
		}else if(direction == 'n') {
			return north;
		}else if(direction == 's') {
			return south;
		}else if(direction == 'u') {
			return up;
		}else if(direction == 'd') {
			return down;
		}else {
			return null;
		}
	}
	
	public void addExit(Room object, char direction) {
		if(direction == 'e') {
			east = object;
		}else if(direction == 'w') {
			west = object;
		}else if(direction == 'n') {
			north = object;
		}else if(direction == 's') {
			south = object;
		}else if(direction == 'u') {
			up = object;
		}else if(direction == 'd') {
			down = object;
		}
	}
	
	public String getDesc() {
		return Game.roomDesc.get(roomID);
	}
	
	
	
	public String toString() {
		return getDesc();
	}
	
}
