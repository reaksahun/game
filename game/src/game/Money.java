package game;

public class Money extends Item {

	public Money() {
		super("money");
	}
	
	public void take() {
		super.take(); // calls item's take() method 
		Game.getCurrentRoom().setRoomID("Living Room_A");
	} 
	
}
