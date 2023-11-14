package game;

public class yellowKey extends Item{
	
	public yellowKey() {
		super("yellowKey");
	}	
	
	public void take() {
		super.take(); // calls item's take() method 
		Game.getCurrentRoom().setRoomID("Kitchen_B");
	} 
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Kitchen")) {
			System.out.println("The key fits into the basement door. You can now go downstairs into the basement.");
			Room basement = Game.getCurrentRoom().getExit('d');
			basement.setLocked(false);
			
		}else 
			System.out.println("The key doesn't fit any lock in this room");		
	}
}

