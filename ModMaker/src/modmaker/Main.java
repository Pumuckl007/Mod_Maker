package modmaker;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public ArrayListSortItem<Item> items = new ArrayListSortItem<Item>();
	public Mod mod;
	public File workingDir;
	public Main(){
		workingDir = new File(System.getProperty("user.home") + "/.modmaker/");
		workingDir.mkdirs();
		mod = new Mod();
		Collections.sort(items, new itemSort());
	}
	private class itemSort implements Comparator <Item> {

	    @Override
	    public int compare(Item o1, Item o2) {
	        if(o1.getName() != null && o2.getName() != null){
	            return o1.getName().compareToIgnoreCase(o2.getName());
	        }

	        return 0;
	    }

	}
}
