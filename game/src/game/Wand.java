package game;

public class Wand extends Item{
	
	public Wand() {
		super("wand");
	}
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			System.out.println("You wave the wand around and the study door opens");
			Room study = Game.getCurrentRoom().getExit('s');
			study.setLocked(false);
		}else {
			System.out.println("You wave the wand around");
		}
	}
}
