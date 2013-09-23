package modmaker;

import java.util.ArrayList;

public class Item {
	public ArrayList<Recipy> recipies = new ArrayList<Recipy>();
	public Item(){
		this.recipies.add(new Recipy());
	}
	public String[] getItemForTable(){
		return new String[]{"Item", "Tea", "12345", "Edit", "Delete"};
	}
}
