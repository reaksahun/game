package game;

public class lightBulb extends Item{
	public lightBulb() {
		super("lightBulb");
	}
	
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("Basement")) {
				System.out.println("You twist the light bulb in and now you can see in the basement. You see a bunch of random junk and a hand held shovel");
				Game.removeItem("lightBulb");
				Item shovel = new Shovel();
				shovel.setDesc("rusty small shovel");
				Game.getCurrentRoom().addItem(shovel);
				Game.removeItem("lightBulb");
				setUsed(true);
				Game.getCurrentRoom().setRoomID("Basement_A");
			
		}else 
			System.out.println("Can use this here");		
	}
}