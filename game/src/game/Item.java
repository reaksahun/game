package game;

public class Item {
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
		System.out.println(desc);
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
}
