package modmaker.export;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
	public static void writeSub(String orginalFilePath, File file , ZipOutputStream out) throws Exception{
		for(File f : file.listFiles()){
			if(f.isDirectory()){
				FileUtils.writeSub(orginalFilePath, f, out);
			}
			else{
				FileInputStream in = new FileInputStream(f);

				// name the file inside the zip  file 
				out.putNextEntry(new ZipEntry(f.getAbsolutePath().replace(orginalFilePath, ""))); 

				// buffer size
				byte[] b = new byte[1024];
				int count;

				while ((count = in.read(b)) > 0) {
					out.write(b, 0, count);
				}
				in.close();
			}
		}
	}
}
