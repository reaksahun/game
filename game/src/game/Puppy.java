package game;

public class Puppy extends NPC{
	public Puppy() {
		super("puppy","small cute corgi wearing a red collar");
		
	}
	
	int time = 1;
	int c = 1;
	public void talk() {
		if(time == 1 ) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous"
			};
			time++;
			getResponse(options);
		
		}else if(time == 2) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] option = {
					"Yes! I love fetch?",
					"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(option);
			time++;
		}else{
			say("Yip");
		}
	}

	public void response(int choice) {
		if(c == 1 ) {
			switch(choice) {
			case 1:
				say("I am! I'm a good boy");
				break;
			case 2:
				say("I am to adorable! Why are you so mean?");
				Game.print("The puppy bites you. You desevre it.");
				break;
			}
			c++;
			
		}else if(c == 2){
			switch(choice) {
			case 1:
				say("Yay! Fetch");
				Item ball = new Item("ball");
				ball.setDesc("small red ball");
				Game.getCurrentRoom().addItem(ball);
				Game.collectItem("ball");
				break;
			case 2:
				say("You're a bad person! I dont like you!");
				Game.getCurrentRoom().removeNPC("puppy");
				break;
			}
			c++;
			
		}
		
		
	}
}