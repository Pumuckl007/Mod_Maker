package modmaker;

import java.util.Comparator;

public class ItemSort<T> implements Comparator <T> {


	@Override
	public int compare(T o1, T o2) {
		if(((Item)o1).getName() != null && ((Item)o2).getName() != null){
			return ((Item)o1).getName().compareToIgnoreCase(((Item)o2).getName());
		}

		return 0;
	}

}