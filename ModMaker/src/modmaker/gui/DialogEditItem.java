package modmaker.gui;

import java.util.Collections;

import modmaker.Item;
import modmaker.ItemSort;
import modmaker.Start;

public class DialogEditItem {
	public boolean done;
	public Item item;
	public DialogEditItem(){
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void openGui(int itemIndex){
		Item item = Start.main.items.get(itemIndex);
		this.item = item;
		done = false;
		new EditItem(Start.gui.frame, "Edit Item", this);
		while(!done){
			
		}
		item = this.item;
		Start.main.items.set(itemIndex, item);
		Collections.sort(Start.main.items, new ItemSort());
		for(int i = 0; i < 5; i++){
			Start.gui.items.removeRow(itemIndex);
			Start.gui.items.insertRow(itemIndex, item.getItemForTable());
		}
	}
}
