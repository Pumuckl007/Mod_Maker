package modmaker;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

import modmaker.init.InitFiles;

public class Mod {
	public ArrayList<String> vannilaItems = new ArrayList<String>();
	public HashMap<String, Item> vannilaItemLookUp = new HashMap<String, Item>();
	private ZipFile minecraftJar;
	private Enumeration<? extends ZipEntry> entries;
	private String minecraftVerstion = "1.6.4";
	public Mod(){
		File minecraft = new File(System.getProperty("user.home") + "/.minecraft/versions/" + this.minecraftVerstion + "/" + this.minecraftVerstion + ".jar");
		File blocks = new File(System.getProperty("user.home") + "/.modmaker/blocks/");
		blocks.mkdirs();
		File items = new File(System.getProperty("user.home") + "/.modmaker/items/");
		items.mkdirs();
		if(minecraft.exists()){
			this.initfiles(blocks, items);
		}
		try {
			BufferedReader itemreader = new BufferedReader(new FileReader(new File(System.getProperty("user.home") + "/.modmaker/items/items.txt")));
			String line;
			while((line = itemreader.readLine()) != null){
				Item item = new Item(line.split(" ")[1].replace("_", " "));
				item.setId(Integer.parseInt(line.split(" ")[0].split(":")[0]));
				if(line.contains(":"))
					item.setMetadat(Integer.parseInt(line.split(" ")[0].split(":")[1]));
				item.setImage(new File(System.getProperty("user.home") + "/.modmaker/items/" + line.split(" ")[2] + ".png"));
				this.vannilaItemLookUp.put(item.getName(), item);
				this.vannilaItems.add(item.getName());
			}
			itemreader.close();
		} catch (Exception e) {
			e.printStackTrace();
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
		File minecraftVerstionFile = new File(System.getProperty("user.home") + "/.modmaker/minecraftV" + this.minecraftVerstion + "/");
		if(minecraftVerstionFile.exists()){
			InitFiles init = new InitFiles();
			Thread thread = new Thread(init);
			thread.start();
			init.setProgress(0, "Removing Old Files");
			for(File file : blocks.listFiles()){
				file.delete();
			}
			for(File file : items.listFiles()){
				file.delete();
			}
			init.setProgress(50, "Extracting Files");
			blocks.mkdir();
			items.mkdir();
			minecraftVerstionFile.mkdirs();
			for(File file : new File(System.getProperty("user.home") + "/.modmaker/").listFiles()){
				if(file.getName().contains("minecraftV") && !file.getName().contains("minecraftV" + this.minecraftVerstion)){
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
					if(!new File(System.getProperty("user.home") + "/.modmaker/blocks/" + zipEntry.getName().replace("assets/minecraft/textures/blocks/", "")).exists()){
						try {
							BufferedInputStream pngZipedFile = new BufferedInputStream(minecraftJar.getInputStream(zipEntry));
							BufferedImage image = ImageIO.read(pngZipedFile);
							OutputStream outStream = new FileOutputStream(System.getProperty("user.home") + "/.modmaker/blocks/" + zipEntry.getName().replace("assets/minecraft/textures/blocks/", ""));
							ImageIO.write(image, "png", outStream);
							pngZipedFile.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					extracted = true;
				}
				if(zipEntry.getName().contains("/textures/items/") && !zipEntry.getName().contains("mcmeta")){
					if(!new File(System.getProperty("user.home") + "/.modmaker/items/" + zipEntry.getName().replace("assets/minecraft/textures/items/", "")).exists()){
						try {
							BufferedInputStream pngZipedFile = new BufferedInputStream(minecraftJar.getInputStream(zipEntry));
							BufferedImage image = ImageIO.read(pngZipedFile);
							OutputStream outStream = new FileOutputStream(System.getProperty("user.home") + "/.modmaker/items/" + zipEntry.getName().replace("assets/minecraft/textures/items/", ""));
							ImageIO.write(image, "png", outStream);
							pngZipedFile.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					extracted = true;
				}
				i++;
				if(extracted)
					init.setProgress(50 +(i/3), "Extracting File: " + zipEntry.getName());
				else
					init.setProgress(50 + (i/3), "Extracting Files");
				extracted = false;
			}
			init.setProgress(900, "Downloading Files");
			String idUrl = "https://dl.dropboxusercontent.com/s/0n7rmvzgiebi25x/Items.txt?token_hash=AAGEi4TXYeOikhZGl2IYbx1mbGaG4HZez9tyTiSOMFdvUA&dl=1";
			try {
				URL website = new URL(idUrl);
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/.modmaker/items/items.txt");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			init.setProgress(1000, "Finishing");
			init.done = true;
			init.dispose();
		}
	}
}
