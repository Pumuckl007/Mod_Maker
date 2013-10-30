package modmaker;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;

import modmaker.export.FileUtils;

public class Main {
	public Mod mod;
	public File workingDir;
	public static final boolean hasMcpPremistion = false;
	public Main(){
		System.out.println(FileUtils.getMinecraftDirectory().getAbsolutePath());
		workingDir = FileUtils.getWorkingDirectory();
		workingDir.mkdirs();
		mod = new Mod("NOTDEF","","",true, true);
		Collections.sort(mod.items, new itemSort());
		File f = FileUtils.getWorkingDirectory();
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
