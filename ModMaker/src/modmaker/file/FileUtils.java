package modmaker.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
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
	public static File file(String path){
		return new File(path.replace("/", File.separator));
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
	public static void writerStringToZip(ZipOutputStream out, String string, String filename) throws IOException{
		ZipEntry entry = new ZipEntry(filename);
		out.putNextEntry(entry);
		out.write(string.getBytes());
	}
	public static void downloadFile(String url, String output, String directory){
		new File(directory).mkdirs();
		FileUtils.downloadFile(url, output);
	}
	public static void downloadFile(String url, String output){
		FileUtils.downloadFile(url, new File(output));
	}
	public static void downloadFile(String url, File output){
		try {
			URL website = new URL(url);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(output);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	  public static enum OS
	  {
	    WINDOWS,  MACOS,  SOLARIS,  LINUX,  UNKNOWN;
	    
	    private OS() {}
	  }
	  
	  public static OS getPlatform()
	  {
	    String osName = System.getProperty("os.name").toLowerCase();
	    if (osName.contains("win")) {
	      return OS.WINDOWS;
	    }
	    if (osName.contains("mac")) {
	      return OS.MACOS;
	    }
	    if (osName.contains("linux")) {
	      return OS.LINUX;
	    }
	    if (osName.contains("unix")) {
	      return OS.LINUX;
	    }
	    return OS.UNKNOWN;
	  }

	public static File getWorkingDirectory()
	  {
	    String userHome = System.getProperty("user.home", ".");
	    File workingDirectory;
	    switch (getPlatform().ordinal())
	    {
	    case 0: 
		      String applicationData = System.getenv("APPDATA");
		      String folder = applicationData != null ? applicationData : userHome;
		      workingDirectory = new File(folder, ".modmaker/");
		      break;
	    case 1: 
	    	workingDirectory = new File(userHome, "Library/Application Support/modmaker");
		      break;
	    case 2: 
	      workingDirectory = new File(userHome, ".modmaker/");
	      break;
	    case 3: 
	    	workingDirectory = new File(userHome, ".modmaker/");
		      break;
	    case 4: 
	      workingDirectory = new File(userHome, "Library/Application Support/modmaker");
	      break;
	    default: 
	      workingDirectory = new File(userHome, ".modmaker/");
	    }
	    return workingDirectory;
	  }
	public static File getMinecraftDirectory()
	  {
	    String userHome = System.getProperty("user.home", ".");
	    File workingDirectory;
	    switch (getPlatform().ordinal())
	    {
	    case 0: 
		      String applicationData = System.getenv("APPDATA");
		      String folder = applicationData != null ? applicationData : userHome;
		      workingDirectory = new File(folder, ".minecraft/");
		      break;
	    case 1: 
	    case 2: 
	      workingDirectory = new File(userHome, ".minecraft/");
	      break;
	    case 3: 
	      applicationData = System.getenv("APPDATA");
	      folder = applicationData != null ? applicationData : userHome;
	      workingDirectory = new File(folder, ".minecraft/");
	      break;
	    case 4: 
	      workingDirectory = new File(userHome, "Library/Application Support/minecraft");
	      break;
	    default: 
	      workingDirectory = new File(userHome, ".minecraft/");
	    }
	    return workingDirectory;
	  }
}
