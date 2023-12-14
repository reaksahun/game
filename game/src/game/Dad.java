package game;

public class Dad extends NPC{

	public Dad() {
		super("dad","still in his work clothes, beer belly, messy hair");
	}
	
	public void give(Item i) {
		if(i.getName().equals("treat")) {
			Game.print("Your dad starts munching on the treat in his sleep");
			Game.removeItem(i.getName());
		}else {
			Game.print("he isn't gonna have any use with this");
		}
	}
	int t = 1;
	public void talk() {
		if(t == 1) {
			say("*snoring*");
			String[] options = {
					"*wispers* hey dad...",
					"I should let him sleep"
			};	
			getResponse(options);
			t++;
		}else {
			Game.print("Zzzzz");
		}
		
	}
	
	public void response(int choice) {
		switch(choice) {
		case 1:
			say("don't talk to me");
			break;
		case 2:
			say("the snores get progressivly louder");
			break;
		}
	}
	
}
