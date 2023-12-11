package game;

public class CarKey extends Item{
	public CarKey() {
		super("carKey");
	}
	
	public void take() {
		super.take(); // calls item's take() method 
		Game.getCurrentRoom().setRoomID("Backyard_A");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Garage")) {
			Game.print("You insert the car keys into the car and you get in. You drive off into the sunset and make it to the party!!!");
		}else {
			Game.print("Not the right place for these");
		}
	}
}

