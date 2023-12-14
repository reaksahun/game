package game;

import java.io.Serializable;

public class NPC implements Serializable {

	private String name;
	private String desc;
	private boolean convo;
	
	public NPC(String name) {
		this.name = name;
	}
	
	public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
		convo = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void give(Item i) {
		Game.print("You are't carrying it");
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public void talk() {
		Game.print("You can't talk to " +name);
	}
	
	public void response(String option) {
		
	}
	
	public void say(String dialog) {
		Game.print(name+": "+dialog);
	}
	
	public void setConvo(boolean c) {
		convo = c;
	}
	
	

	
	
	//display options to player
	//prompt player to select an option
	//read player's choice
	//call the response method with the player's choice
	//as the parameter
	public void getResponse(String[] options) {
		for(int i =0; i<options.length; i++) {
			Game.print("Options "+(i+1)+": "+options[i]);
		}
		Game.print("Enter an otpions (1-"+options.length+")");
		//int choice = Game.scan.nextInt();
		//Game.scan.nextLine(); //flush input buffer
		//response(choice);
	}
}
