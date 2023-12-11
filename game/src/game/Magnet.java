package game;

public class Magnet extends Item {
	public Magnet() {
		super("magnet");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			if(isUsed()) {
				Game.print("There is no longer anything in the sink");
			}else {
				Game.print("You use the magnet in the sink drain"
						+ "and the magnet pulls out a yellowKey");
				Item yellowKey = new yellowKey();
				yellowKey.setDesc("Small yellow key");
				Game.getCurrentRoom().addItem(yellowKey);
				setUsed(true);
			}
			
		}else
			Game.print("the magnet isnt gonna stick silly");
	}
}


