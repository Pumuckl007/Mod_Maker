package modmaker.export;

import java.io.File;

public class FileUtils {
	public static void removeDirectory(File directory){
		if(directory.exists()){
			for(File file : directory.listFiles()){
				if(file.isDirectory()){
					FileUtils.removeDirectory(file);
				}
				else{
					file.delete();
				}
			}
			directory.delete();
		}
	}
}
