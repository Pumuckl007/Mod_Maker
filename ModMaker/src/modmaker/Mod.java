package modmaker;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

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
	}
	private void initfiles(File blocks, File items){
		File minecraftVerstionFile = new File(System.getProperty("user.home") + "/.modmaker/minecraftV" + this.minecraftVerstion + "/");
		if(!minecraftVerstionFile.exists()){
			for(File file : blocks.listFiles()){
				file.delete();
			}
			for(File file : items.listFiles()){
				file.delete();
			}
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
				}
			}
		}
	}
}
