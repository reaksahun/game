package game;

public class Shower extends Item{
	public Shower() {
		super("shower");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("yourRoom")) {
			if(Game.getItem("goo") == null) {
				System.out.println("There is no goo on you to wash off");
			}else {
				System.out.println("The goo is now washed away");
				Game.removeItem("goo");
			}
		}else {
			System.out.println("no shower to use");
		}
	}
}
