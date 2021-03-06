package modmaker.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import modmaker.Item;
import modmaker.Mod;
import modmaker.Start;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SaveSlashLoad {
	public static void save(Mod mod, File file){
		try{
			ZipOutputStream out;
			if(file.getName().contains(".mcm"))
				out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath()));
			else
				out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath() + ".mcm"));
			Gson gson = new Gson();
			StringBuilder builder = new StringBuilder();
			for(Item item : mod.items){
				builder.append(gson.toJson(item) + "\n");
			}
			ZipEntry entry = new ZipEntry("mod.json");
			out.putNextEntry(entry);
			out.write(mod.save().getBytes());
			ZipEntry entry2 = new ZipEntry("items.json");
			out.putNextEntry(entry2);
			out.write(builder.toString().getBytes());
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void load(File file){
		try{
			ZipFile loaded = null;
			loaded = new ZipFile(file);
			Enumeration<? extends ZipEntry> entries = loaded.entries();
			int lenght = Start.gui.items.getRowCount();
			for(int i = 0; i< lenght; i++){
				Start.gui.items.removeRow(lenght - i - 1);
			}
			while(entries.hasMoreElements()){
				ZipEntry zipEntry = entries.nextElement();
				if(zipEntry.getSize() > 0 && zipEntry.getName().contains(".json")){
					InputStream zipedFile = loaded.getInputStream(zipEntry);
					BufferedReader reader = new BufferedReader(new InputStreamReader(zipedFile, "UTF-8"));
					String line;
					Gson gson = new Gson();
					while((line = reader.readLine()) != null) {
						if(zipEntry.getName().contains("mod.json")){
							Mod.load(line);
						}
						if(zipEntry.getName().contains("items.json")){
							Type itemType = new TypeToken<Item>(){}.getType();
							Item item = gson.fromJson(line, itemType);
							Start.main.mod.items.add(item);
							Start.gui.items.addRow(item.getItemForTable());
							for(String string : line.split(":")){
								if(string.contains("/")){
									item.setImageFile(new File(string.split("}")[0].replace("\"", "")));
								}
							}
						}
							
					}
					reader.close();
					zipedFile.close();
				}
			}
			loaded.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
