package modmaker;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

import modmaker.gui.InitFiles;

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
		if(!minecraftVerstionFile.exists()){
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
				if(extracted){
					init.setProgress(50 +(int)(i*1.6), "Extracting File: " + zipEntry.getName());
					i++;
				}
				else
					init.setProgress(50 + (int)(i*1.6), "Extracting Files");
				extracted = false;
			}
			init.setProgress(900, "Downloading ItemRefences");
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
			init.setProgress(920, "Downloading SwingX Licence");
			String swingxLicens = "https://raw.github.com/Zypr/Zypr-Reference-Client---Java/master/libraries/swingx-core-1.6.2-LICENSE.txt";
			try {
				URL website = new URL(swingxLicens);
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/.modmaker/SwingX_lisence.txt");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			init.setProgress(940, "Copying LWJGL Licence");
			String lwjglLicence = "Copyright (c) 2002-2007 Lightweight Java Game Library Project"
					+ "\nAll rights reserved."
					+ "\nRedistribution and use in source and binary forms, with or without"
					+ "\nmodification, are permitted provided that the following conditions are"
					+ "\nmet:\nRedistributions of source code must retain the above copyright"
					+ "\nnotice, this list of conditions and the following disclaimer."
					+ "\nRedistributions in binary form must reproduce the above copyright"
					+ "\nnotice, this list of conditions and the following disclaimer in the"
					+ "\ndocumentation and/or other materials provided with the distribution."
					+ "\nNeither the name of 'Light Weight Java Game Library' nor the names of"
					+ "\nits contributors may be used to endorse or promote products derived"
					+ "\nfrom this software without specific prior written permission."
					+ "\nTHIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS"
					+ "\n\"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED"
					+ "\nTO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR"
					+ "\nPURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR"
					+ "\nCONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,"
					+ "\nEXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,"
					+ "\nPROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR"
					+ "\nPROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF"
					+ "\nLIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING"
					+ "\nNEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS"
					+ "\nSOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE";
			try {
				BufferedWriter lwjglLicenceWriter = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/.modmaker/LWJGL_lisence.txt"));
				lwjglLicenceWriter.append(lwjglLicence);
				lwjglLicenceWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			init.setProgress(950, "Downloading SlickUtil Licence");
			String slickUtillicence = "https://dl.dropboxusercontent.com/s/fnnl2w2935qmp1j/SlickUtil_lisence.txt?token_hash=AAH-vKNsRv6fTeRM6lI1zZEZcg87OutOQ7CzbTK702BVQQ&dl=1";
			try {
				URL website = new URL(slickUtillicence);
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/.modmaker/SlickUtil_lisence.txt");
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				fos.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			init.setProgress(960, "Downloading ModMaker Licence");
			String modMakerLicence = "https://dl.dropboxusercontent.com/s/49lkddvvy9mquh5/ModMaker_licence.txt?token_hash=AAExQvY5gJnlk9JAVEZaXkw5kdquXVx6hU6ZQUt19UL-RQ&dl=1";
			try {
				URL website = new URL(modMakerLicence);
				ReadableByteChannel rbc = Channels.newChannel(website.openStream());
				FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/.modmaker/ModMaker_lisence.txt");
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
