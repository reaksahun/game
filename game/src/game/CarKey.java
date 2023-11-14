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
			if(isUsed()) {
				System.out.println("The car is already open");
			}
			System.out.println("You insert the car keys into the car and you get in. You drive off into the sunset and make it to the party!!!");
		}else {
			System.out.println("Not the right place for these");
		}
	}
}

