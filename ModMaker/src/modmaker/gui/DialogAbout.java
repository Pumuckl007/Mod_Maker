package modmaker.gui;

import modmaker.Start;

public class DialogAbout {
	public boolean done;
	public DialogAbout(){
	}
	public void openGui(){
		done = false;
		new About(Start.gui.frame, "About ModMaker", this);
		while(!done){
			
		}
	}
}
