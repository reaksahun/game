package game;

public class redKey extends Item{
	
	public redKey() {
		super("redKey");
	}
	
	public void take() {
		super.take(); // calls item's take() method 
		Game.getCurrentRoom().setRoomID("Kitchen_A");
	}
	
	@Override
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			System.out.println("You insert the red key into the study door and it opens");
			Room study = Game.getCurrentRoom().getExit('s');
			study.setLocked(false);
		}else {
			System.out.println("Unlocks nothing silly");
		}
	}
	
	
}
