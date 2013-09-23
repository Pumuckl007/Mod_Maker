package modmaker.gui;

import modmaker.Item;
import modmaker.Start;

public class DialogEditItem {
	public boolean done;
	public Item item;
	public DialogEditItem(){
	}
	public void openGui(int itemIndex){
		Item item = Start.main.items.get(itemIndex);
		this.item = item;
		done = false;
		new EditItem(Start.gui.frame, "Edit Item", this);
		while(!done){
			
		}
		item = this.item;
		Start.main.items.set(itemIndex, item);
		for(int i = 0; i < 5; i++){
			Start.gui.items.removeRow(itemIndex);
			Start.gui.items.insertRow(itemIndex, item.getItemForTable());
		}
	}
}
