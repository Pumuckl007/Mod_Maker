package modmaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSortItem<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -97572267590895251L;
	@Override
	public boolean add(T e) {
		boolean returm = super.add(e);
		Collections.sort(this, new ItemSort());
		return returm;
	}

	public class ItemSort implements Comparator <T> {

	    @Override
	    public int compare(T o1, T o2) {
	    	
	        if(((Item)o1).getName() != null && ((Item)o2).getName() != null){
	            return ((Item)o1).getName().compareToIgnoreCase(((Item)o2).getName());
	        }

	        return 0;
	    }

	}
	
}
