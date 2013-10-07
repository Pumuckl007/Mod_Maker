package modmaker.export;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
			File temp = new File(Start.main.workingDir.getAbsolutePath() + "/temp/" + file.getName() + "/");
			File modtempdir = new File(temp.getAbsolutePath() + "/mod/" + file.getName() + "/");
			temp.mkdirs();
			modtempdir.mkdirs();
			Gson gson = new Gson();
			StringBuilder builder = new StringBuilder();
			for(Item item : mod.items){
				builder.append(gson.toJson(item) + "\n");
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(modtempdir.getAbsolutePath() + "/items.json"));
			writer.append(builder.toString());
			writer.close();
			writer = new BufferedWriter(new FileWriter(modtempdir.getAbsolutePath() + "/mod.json"));
			writer.append(mod.save());
			writer.close();

			ZipOutputStream out;
			if(file.getName().contains(".mcm"))
				out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath()));
			else
				out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath() + ".mcm"));
			for(File f : temp.listFiles()){
				if(f.isDirectory()){
					FileUtils.writeSub(temp.getAbsolutePath(), f, out);
				}
				else{
					FileInputStream in = new FileInputStream(f);
					out.putNextEntry(new ZipEntry(f.getAbsolutePath().replace(temp.getAbsolutePath(), ""))); 
					byte[] b = new byte[1024];
					int count;

					while ((count = in.read(b)) > 0) {
						out.write(b, 0, count);
					}
					in.close();
				}
			}
			out.close();
			FileUtils.removeDirectory(new File(Start.main.workingDir.getAbsolutePath() + "/temp/" + file.getName()));
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
