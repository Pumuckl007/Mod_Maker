package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modmaker.Item;

public class EventNewRecipyLisiner implements ActionListener {
	private EditItem editItem;
	private Item item;
	public EventNewRecipyLisiner(EditItem editItem, Item item){
		this.editItem = editItem;
		this.item = item;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		new DialogNewRecipy().openGui(this.item, editItem.recipies.getRowCount() + 1, this.editItem);
	}

}
