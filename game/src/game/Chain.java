package game;

public class Chain extends Item{

	public Chain() {
		super("chain");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Basement")) {
			if(isUsed())
				System.out.println("chain has already been pulled");
			else
				Game.print("Goo spills all over you!");
				Item goo = new Item("goo");
				goo.setDesc("slimy and sticky green goo");
				Game.getCurrentRoom().addItem(goo);
				Game.collectItem("goo");
				setUsed(true);
			
		}
	}
}
