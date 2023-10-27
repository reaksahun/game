package game;

public class ChestKey extends Item{
	

	public ChestKey() {
		super("chestkey");
	}	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Stairs")) {
			if(isUsed()) {
				System.out.println("the chest is already opened");
			}else {
				System.out.println("The key fits into the chest! You open the chest and find a diamond inside");
				Item diamond = new Item("diamond");
				diamond.setDesc("Sparkly!");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			}
		}else 
			System.out.println("The key doesn't fit any lock in this room");		
	}
}
