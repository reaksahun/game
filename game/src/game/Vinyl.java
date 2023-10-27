package game;

public class Vinyl extends Item {
	public Vinyl() {
		super("vinyl");
	}
	public void use() {
	if(Game.getCurrentRoom().getName().equals("Sisroom")) {
		if(isUsed()) {
			System.out.println("Record player was already open");
		}else {
			System.out.println("The correct vinvyl was put in, music starts the play and the record"
					+ "player opens. Inside is a magnet");
			Item magnet = new Magnet();
			magnet.setDesc("very strong long magnet");
			Game.getCurrentRoom().addItem(magnet);
			setUsed(true);
		}
	}else 
		System.out.println("The vinyl cant be used here");		

	}
}
