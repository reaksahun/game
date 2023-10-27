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
						+ "and you pull out a ring. You put the ring in your pocket");
				Item ring = new Item("ring");
				ring.setDesc("Women's diamond ring");
				Game.getCurrentRoom().addItem(ring);
				Game.collectItem("ring");
				setUsed(true);
			}
		
		}else
			System.out.println("the magnet isnt gonna stick silly");
	}
}


