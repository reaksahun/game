package game;

import java.io.Serializable;

public class Item implements Serializable {
	private String name;
	private String desc;
	private boolean heavy;
	private boolean used;
	private boolean slimy;

	
	public Item(String n) {
		name = n;
		heavy = false;
		used = false;
		slimy = false;
		
	}
	
	public void setHeavy(boolean w) {
		heavy = w;
	}
	
	
	public boolean isSlimy() {
		return slimy;
	}
	
	public void setSlimy(boolean s) {
		slimy = s;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	public void setDesc(String d) {
		desc = d;
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = b;
	}
	public void use() {
		System.out.println("you cant use that item... yet");
		
	}
	
	public void take() {
		if(heavy) {
			Game.print("That's too heavy to carry around");
		}else {
			Game.inventory.add(Game.getCurrentRoom().removeItem(name));
			Game.print("You picked up "+ name + ".");
		}
		
	}
}
