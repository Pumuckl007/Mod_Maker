package modmaker.gui;

import modmaker.Item;
import modmaker.Recipy;
import modmaker.Start;

public class DialogNewRecipy {
	public boolean done;
	public Item item;
	public Recipy recipy;
	public DialogNewRecipy(){
	}
	public void openGui(Item item, int recipyIndex, EditItem editItem){
		this.item = item;
		this.recipy = new Recipy();
		done = false;
		new NewRecipy(Start.gui.frame, "Edit Item", this);
		while(!done){

		}
		item.recipies.add(recipy);
		editItem.recipies.insertRow(recipyIndex - 1, recipy.getStringForTable());
	}
}
