package game;

public class Shovel extends Item{
	public Shovel() {
		super("shovel");
	}
	
	public void use() {
		
		if(Game.getCurrentRoom().getName().equals("Backyard")) {
			if(isUsed()) {
				Game.print("Already been dug up");
			}else {
				Game.print("You start digging the hold that your dog dug, and at the bottom of the hole are your carKey's!");
				Item carKey = new CarKey();
				carKey.setDesc("Keys to your beautiful ride");
				Game.getCurrentRoom().addItem(carKey);
				Game.getCurrentRoom().setRoomID("Backyard_A");
			}
		}else 
			Game.print("You can't dig though anything here");		
	}
}
	