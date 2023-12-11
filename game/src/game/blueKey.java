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
				Game.print("the chest is already opened");
			}else {
				Game.print("The key fits into the chest! You open the chest and find a lightBulb inside");
				Item lightbulb = new lightBulb();
				lightbulb.setDesc("Sparkly!");
				Game.getCurrentRoom().addItem(lightbulb);
				setUsed(true);
			}
		}else 
			Game.print("The key doesn't fit any lock in this room");		
	}
}
