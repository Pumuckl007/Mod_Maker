package modmaker;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import modmaker.export.FileUtils;
import modmaker.gui.Gui;
import modmaker.gui.InitFiles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Mod {
	public static ArrayList<String> vannilaItems = new ArrayList<String>();
	public static HashMap<String, Item> vannilaItemLookUp = new HashMap<String, Item>();
	private ZipFile minecraftJar;
	private Enumeration<? extends ZipEntry> entries;
	private String minecraftVerstion = "1.6.4";
	public static final String minecraftForgeLocation = "http://files.minecraftforge.net/minecraftforge/minecraftforge-src-1.6.4-9.11.1.916.zip";
	public static final String mCPlocation = "http://download1307.mediafire.com/v1xnkih5zdag/96mrmeo57cdf6zv/mcp811.zip";
	public ArrayListSortItem<Item> items = new ArrayListSortItem<Item>();
	public String name;
	public String info;
	public String by;
	public boolean exportSource;
	public Mod(String name, String info, String by, boolean exportSource){
		this(name, info, by, exportSource, false);
	}
	public Mod(String name, String info, String by, boolean exportSource, boolean init){
		this.name = name;
		this.info = info;
		this.by = by;
		this.exportSource = exportSource;
		if(init){
			File minecraft = FileUtils.file(FileUtils.getMinecraftDirectory().getAbsolutePath() + "/versions/" + this.minecraftVerstion + "/" + this.minecraftVerstion + ".jar");
			System.out.println("Minecraft Directory: " + minecraft.getAbsolutePath());
			File blocks = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/blocks/");
			blocks.mkdirs();
			File items = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/items/");
			items.mkdirs();
			if(minecraft.exists()){
				this.initfiles(blocks, items);
				try {
					BufferedReader itemreader = new BufferedReader(new FileReader(FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/items/items.txt")));
					String line;
					while((line = itemreader.readLine()) != null){
						Item item = new Item(line.split(" ")[1].replace("_", " "), ItemType.Item);
						item.setId(Integer.parseInt(line.split(" ")[0].split(":")[0]));
						if(line.contains(":"))
							item.setMetadat(Integer.parseInt(line.split(" ")[0].split(":")[1]));
						item.setImageFile(FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/items/" + line.split(" ")[2] + ".png"));
						Mod.vannilaItemLookUp.put(item.getName(), item);
						Mod.vannilaItems.add(item.getName());
					}
					itemreader.close();
					for(File file : new File(FileUtils.getWorkingDirectory(), "/blocks").listFiles()){
						Item item = new Item(file.getName() , ItemType.Block);
						item.setId(0);
						item.setImageFile(file);
						Mod.vannilaItemLookUp.put(item.getName(), item);
						Mod.vannilaItems.add(item.getName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else{
				Gui.stardardLookAndFeel(null);
				JOptionPane.showMessageDialog(null, "No Minecraft install found\n" + FileUtils.getMinecraftDirectory().getAbsolutePath() + "\n" + FileUtils.getPlatform(), "Eorror", JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
		}
	}
	//	StringBuilder builder = new StringBuilder();
	//	for(File file : blocks.listFiles()){
	//		String name = "Block " + file.getName().replace(".png", "");
	//		Item item = new Item(name);
	//		item.setImage(file);
	//		this.vannilaItems.add(name);
	//		this.vannilaItemLookUp.put(name, item);
	//	}
	//	for(File file : items.listFiles()){
	//		String name = "Item " + file.getName().replace(".png", "");
	//		Item item = new Item(name);
	//		item.setImage(file);
	//		this.vannilaItems.add(name);
	//		this.vannilaItemLookUp.put(name, item);
	//	}
	//	Collections.sort(this.vannilaItems);
	//	for(String item : this.vannilaItems){
	//		builder.append("1 " + item + "\n");
	//	}
	//	System.out.println(builder.toString());
	private void initfiles(File blocks, File items){
		File minecraftVerstionFile = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/minecraftV" + this.minecraftVerstion + ((Boolean)Main.hasMcpPremistion).toString() + "/");
		if(!minecraftVerstionFile.exists()){
			InitFiles init = new InitFiles();
			Thread thread = new Thread(init);
			thread.start();
			init.setProgress(0, "Removing Old Files");
			for(java.io.File file : blocks.listFiles()){
				file.delete();
			}
			for(java.io.File file : items.listFiles()){
				file.delete();
			}
			File minecraftForgeFile = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/");
			minecraftForgeFile.mkdir();
			for(java.io.File file : minecraftForgeFile.listFiles()){
				file.delete();
			}
			init.setProgress(50, "Extracting Files");
			blocks.mkdir();
			items.mkdir();
			for(java.io.File file : FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/").listFiles()){
				if(file.getName().contains("minecraftV")){
					file.delete();
				}
			}
			try {
				minecraftJar = new ZipFile(System.getProperty("user.home") + "/.minecraft/versions/" + this.minecraftVerstion + "/" + this.minecraftVerstion + ".jar");
			} catch (IOException e) {
				e.printStackTrace();
			}
			entries = minecraftJar.entries();
			int i = 0;
			boolean extracted = false;
			while(entries.hasMoreElements()){
				ZipEntry zipEntry = entries.nextElement();
				if(zipEntry.getName().contains("/textures/blocks/") && !zipEntry.getName().contains("mcmeta")){
					if(!FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/blocks/" + zipEntry.getName().replace("assets/minecraft/textures/blocks/", "")).exists()){
						try {
							BufferedInputStream pngZipedFile = new BufferedInputStream(minecraftJar.getInputStream(zipEntry));
							BufferedImage image = ImageIO.read(pngZipedFile);
							OutputStream outStream = new FileOutputStream(FileUtils.getWorkingDirectory().getAbsolutePath() + "/blocks/" + zipEntry.getName().replace("assets/minecraft/textures/blocks/", ""));
							ImageIO.write(image, "png", outStream);
							pngZipedFile.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					extracted = true;
				}
				if(zipEntry.getName().contains("/textures/items/") && !zipEntry.getName().contains("mcmeta")){
					if(!FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/items/" + zipEntry.getName().replace("assets/minecraft/textures/items/", "")).exists()){
						try {
							BufferedInputStream pngZipedFile = new BufferedInputStream(minecraftJar.getInputStream(zipEntry));
							BufferedImage image = ImageIO.read(pngZipedFile);
							OutputStream outStream = new FileOutputStream(FileUtils.getWorkingDirectory().getAbsolutePath() + "/items/" + zipEntry.getName().replace("assets/minecraft/textures/items/", ""));
							ImageIO.write(image, "png", outStream);
							pngZipedFile.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					extracted = true;
				}
				if(extracted){
					init.setProgress(50 +(int)(i*0.5), "Extracting File: " + zipEntry.getName());
					i++;
				}
				else
					init.setProgress(50 + (int)(i*0.5), "Extracting Files");
				extracted = false;
			}
			this.download(init);
			ZipFile minecraftForge = null;
			try {
				minecraftForge = new ZipFile(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/minecraftForge.zip");
			} catch (IOException e) {
				e.printStackTrace();
			}
			Enumeration<? extends ZipEntry> mFEntries = minecraftForge.entries();
			i = 0;
			extracted = false;
			while(mFEntries.hasMoreElements()){
				ZipEntry zipEntry = mFEntries.nextElement();
				init.setProgress(480 +(int)(i*0.2), "Extracting File: " + zipEntry.getName() + " (" + ((Long)zipEntry.getSize()).toString() + ")");
				i++;
				try {
					if(zipEntry.getSize() > 0){
						File file = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/" + zipEntry.getName().replace(zipEntry.getName().split("/")[zipEntry.getName().split("/").length-1], ""));
						file.mkdirs();
						BufferedInputStream zipedFile = new BufferedInputStream(minecraftForge.getInputStream(zipEntry));
						FileOutputStream outStream = new FileOutputStream(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/" + zipEntry.getName());
						byte[] buffer = new byte[(int)zipEntry.getSize()];
						int len;
						while ((len = zipedFile.read(buffer)) != -1) {
							outStream.write(buffer, 0, len);
						}
						zipedFile.close();
						outStream.close();
					}
					else{
						File file = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/" + zipEntry.getName().replace(zipEntry.getName().split("/")[zipEntry.getName().split("/").length-1], ""));
						File file2 = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/" + zipEntry.getName());
						file.mkdirs();
						file2.createNewFile();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(Main.hasMcpPremistion){
				FileUtils.removeDirectory(FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp/"));
				init.setProgress(770, "Installing MCP/Forge (This May Take A While)");
				Process runtime = null;
				try {
					if(System.getProperty("os.name").contains("Windows")){
						runtime = Runtime.getRuntime().exec(System.getProperty("user.home") + "\\.modmaker\\MinecraftForge\\forge\\fml\\python\\python_fml " +  System.getProperty("user.home") + "\\.modmaker\\MinecraftForge\\forge\\fml\\install.py", null, FileUtils.file(System.getProperty("user.home") + "\\.modmaker\\MinecraftForge\\forge\\"));
					}
					else{
						runtime = Runtime.getRuntime().exec("python " + FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/fml/install.py", null, FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/"));
					}
					String line;
					BufferedReader stdInput = new BufferedReader(new InputStreamReader(runtime.getInputStream()));

					BufferedReader stdError = new BufferedReader(new InputStreamReader(runtime.getErrorStream()));
					int j = 0;
					//					 read the output from the command
					while ((line = stdInput.readLine()) != null) {
						System.out.println(line);
						init.setProgress(770 + j/30, line + " (This may take a while)");
						j++;
					}

					// read any errors from the attempted command
					while ((line = stdError.readLine()) != null) {
						System.out.println(line);
						init.setProgress(770 + j/30, line + " (This may take a while)");
						j++;
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.exit(-1);
				}
			}
			init.setProgress(1000, "Finishing");
			init.done = true;
			init.dispose();
			minecraftVerstionFile.mkdirs();
		}
	}
	private void download(InitFiles init){
		init.setProgress(400, "Downloading ItemRefences");
		String idUrl = "https://raw.github.com/Pumuckl007/Mod_Maker/master/downloadables/Items.txt";
		FileUtils.downloadFile(idUrl, FileUtils.getWorkingDirectory().getAbsolutePath() + "/items/items.txt");
		init.setProgress(410, "Downloading SwingX Licence");
		String swingxLicens = "https://raw.github.com/Pumuckl007/Mod_Maker/master/SwingX_lisence.txt";
		FileUtils.downloadFile(swingxLicens, FileUtils.getWorkingDirectory().getAbsolutePath() + "/SwingX_lisence.txt");
		String lwjgllicence = "https://raw.github.com/Pumuckl007/Mod_Maker/master/LWJGL_lisence.txt";
		init.setProgress(420, "Downloading LWJGL Licence");
		FileUtils.downloadFile(lwjgllicence, FileUtils.getWorkingDirectory().getAbsolutePath() + "/LWJGL_lisence.txt");
		init.setProgress(425, "Downloading SlickUtil Licence");
		String slickUtillicence = "https://raw.github.com/Pumuckl007/Mod_Maker/master/SlickUtil_lisence.txt";
		FileUtils.downloadFile(slickUtillicence, FileUtils.getWorkingDirectory().getAbsolutePath() + "/SlickUtil_lisence.txt");
		init.setProgress(435, "Downloading ModMaker Licence");
		String modMakerLicence = "https://raw.github.com/Pumuckl007/Mod_Maker/master/LICENCE.txt";
		FileUtils.downloadFile(modMakerLicence, FileUtils.getWorkingDirectory().getAbsolutePath() + "/ModMaker_lisence.txt");
		init.setProgress(440, "Downloading Gson Licence");
		String gsonLicence = "https://raw.github.com/Pumuckl007/Mod_Maker/master/downloadables/gson_licence.txt";
		FileUtils.downloadFile(gsonLicence, FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/Gson_licence.txt"));
		FileUtils.removeDirectory(FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/"));
		init.setProgress(445, "Downloading Minecraft Forge");
		FileUtils.downloadFile(minecraftForgeLocation, FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/minecraftForge.zip", FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/");
		init.setProgress(480, "Extracting Minecraft Forge");
	}



	public String save(){
		StringBuilder builder = new StringBuilder();
		Gson gson = new Gson();
		HashMap<String, Object> info = new HashMap<String, Object>();
		info.put("Name", this.name);
		info.put("Description", this.info);
		info.put("Author", this.by);
		info.put("Source", this.exportSource);
		builder.append(gson.toJson(info));
		return builder.toString();
	}
	public static void load(String json){
		Gson gson = new Gson();
		Type hashMapType = new TypeToken<HashMap<String, Object>>(){}.getType();
		HashMap<String, Object> info = gson.fromJson(json, hashMapType);
		Start.main.mod = new Mod((String)info.get("Name"), (String)info.get("Description"), (String)info.get("Author"), (Boolean)info.get("Source"));
	}


















	//	init.setProgress(740, "Downloading MCP");
	//	try {
	//		File location = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/");
	//		location.mkdir();
	//		URL website = new URL(mCPlocation);
	//		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
	//		FileOutputStream fos = new FileOutputStream(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp.zip");
	//		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	//		fos.close();
	//	}catch (Exception e) {
	//		e.printStackTrace();
	//	}
	//	init.setProgress(755, "Exrtcating MCP");
	//	ZipFile mCP = null;
	//	try {
	//		mCP = new ZipFile(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp.zip");
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
	//	Enumeration<? extends ZipEntry> mCPEntries = mCP.entries();
	//	i = 0;
	//	extracted = false;
	//	while(mCPEntries.hasMoreElements()){
	//		ZipEntry zipEntry = mCPEntries.nextElement();
	//		init.setProgress(480 +(int)(i*0.2), "Extracting File: " + zipEntry.getName() + " (" + ((Long)zipEntry.getSize()).toString() + ")");
	//		i++;
	//		try {
	//			if(zipEntry.getSize() > 0){
	//				File file = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp/" + zipEntry.getName().replace(zipEntry.getName().split("/")[zipEntry.getName().split("/").length-1], ""));
	//				file.mkdirs();
	//				BufferedInputStream zipedFile = new BufferedInputStream(minecraftForge.getInputStream(zipEntry));
	//				FileOutputStream outStream = new FileOutputStream(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp/" + zipEntry.getName());
	//				byte[] buffer = new byte[(int)zipEntry.getSize()];
	//				int len;
	//				while ((len = zipedFile.read(buffer)) != -1) {
	//					outStream.write(buffer, 0, len);
	//				}
	//				outStream.close();
	//				zipedFile.close();
	//			}
	//			else{
	//				File file = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp/" + zipEntry.getName().replace(zipEntry.getName().split("/")[zipEntry.getName().split("/").length-1], ""));
	//				File file2 = FileUtils.file(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp/" + zipEntry.getName());
	//				file.mkdirs();
	//				file2.createNewFile();
	//			}
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}
}
