package game;

public class blueKey extends Item{
	

	public blueKey() {
		super("blueKey");
	}	
	
	public void take() {
		super.take(); // calls item's take() method 
		Game.getCurrentRoom().setRoomID("Your Room_A");
	} 
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Stairs")) {
			if(isUsed()) {
				System.out.println("the chest is already opened");
			}else {
				System.out.println("The key fits into the chest! You open the chest and find a lightBulb inside");
				Item lightbulb = new lightBulb();
				lightbulb.setDesc("Sparkly!");
				Game.getCurrentRoom().addItem(lightbulb);
				setUsed(true);
			}
		}else 
			System.out.println("The key doesn't fit any lock in this room");		
	}
}
