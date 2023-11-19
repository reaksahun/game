package game;

public class Sister extends NPC{
	
		public Sister() {
			super("sister","short bratty teenager");
			
	}
		
		int time = 1;
		int c = 1;
		public void talk() {
			if(time == 1 ) {
				say("Get out of my room! Or give me $20");
				String[] options = {
						"No, weirdo.",
						"Why are you so loney, fine here"
				};
				time++;
				getResponse(options);
			
			}else if(time == 2) {
				say("I'm going to sleep");
				String[] option = {
						"You sleep too much, wake up!",
						"Good Night"
				};
				getResponse(option);
				time++;
			}else{
				say("ZZzzzz");
			}
		}

		public void response(int choice) {
			if(c == 1 ) {
				switch(choice) {
				case 1:
					say("MOMMMMM");
					break;
				case 2:
					say("Loser, always doing as I say.");
					Game.removeItem("money");
					break;
				}
				c++;
				
			}else if(c == 2){
				switch(choice) {
				case 1:
					say("You're one to talk, you get up at like 3pm every day.");
					break;
				case 2:
					say("Shut up.");
					break;
				}
				c++;
				
			}
		}
}