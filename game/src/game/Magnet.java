package game;

public class Magnet extends Item {
	public Magnet() {
		super("magnet");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			if(isUsed()) {
				System.out.println("There is no longer anything in the sink");
			}else {
				System.out.println("You use the magnet in the sink drain"
						+ "and the magnet pulls out a yellowKey");
				Item yellowKey = new yellowKey();
				yellowKey.setDesc("Small yellow key");
				Game.getCurrentRoom().addItem(yellowKey);
				setUsed(true);
			}
			
		}else
			System.out.println("the magnet isnt gonna stick silly");
	}
}


