package game;

public class Vinyl extends Item {
	
	public Vinyl() {
		super("vinyl");
	}
	
	public void take() {
		super.take(); // calls item's take() method 
		Game.getCurrentRoom().setRoomID("Study_A");
	} 
	
	public void use() {
	if(Game.getCurrentRoom().getName().equals("Sis Room")) {
		if(isUsed()) {
			System.out.println("Record player was already open");
		}else {
			System.out.println("The correct vinyl was put in, music starts to play and the record"
					+ "player opens. Inside is a magnet");
			Item magnet = new Magnet();
			magnet.setDesc("very strong long magnet");
			Game.getCurrentRoom().addItem(magnet);
			Game.removeItem("vinyl");
			setUsed(true);
			Game.getCurrentRoom().setRoomID("Sis Room_A");
		}
	}else 
		System.out.println("The vinyl cant be used here");		

	}
}
