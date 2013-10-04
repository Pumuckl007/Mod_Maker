package modmaker;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public Mod mod;
	public File workingDir;
	public static final boolean hasMcpPremistion = true;
	public Main(){
		workingDir = new File(System.getProperty("user.home") + "/.modmaker/");
		workingDir.mkdirs();
		mod = new Mod("NOTDEF","","",true);
		Collections.sort(mod.items, new itemSort());
		File f = new File(System.getProperty("user.home") + "/.modmaker/");
		f.mkdir();
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
