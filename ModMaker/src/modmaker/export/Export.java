package modmaker.export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JOptionPane;

import modmaker.Item;
import modmaker.Main;
import modmaker.Mod;
import modmaker.Start;
import modmaker.gui.DialogExportingGui;

public class Export {
	@SuppressWarnings("unused")
	public void export(Mod mod, File file){
		if(Main.hasMcpPremistion || mod.exportSource){
			DialogExportingGui dialog = DialogExportingGui.popUpthis(Start.gui.frame, file.getAbsolutePath());
			try{
				File modDirecotry = new File(file.getAbsolutePath() + "/" + mod.name.toLowerCase() + "/");
				modDirecotry.mkdirs();
				File itemDirecotry = new File(modDirecotry.getAbsolutePath() + "/items/");
				itemDirecotry.mkdir();
				for(Item item : mod.items){
					File itemfile = new File(itemDirecotry.getAbsolutePath() + "/Item" + item.getName() + ".java");
					Integer i = 2;
					while(itemfile.exists()){
						itemfile = new File(itemDirecotry.getAbsolutePath() + "/Item" + item.getName() + i.toString() + ".java");
						i++;
					}
					BufferedWriter writer = new BufferedWriter(new FileWriter(itemfile.getAbsolutePath()));
					StringBuilder builder = new StringBuilder();
					builder.append("package " + mod.name.toLowerCase() + ".items;");
					builder.append("\nimport net.minecraft.client.renderer.texture.IconRegister;\nimport net.minecraft.item.Item;");
					builder.append("\nimport cpw.mods.fml.relauncher.Side;\nimport cpw.mods.fml.relauncher.SideOnly;");
					builder.append("\npublic class " + itemfile.getName().replace(".java", "") +" extends Item {");
					builder.append("\npublic " + itemfile.getName().replace(".java", "") +"() {\nsuper(" + item.getId().toString() + "-256);\n}");
					builder.append("\n}");
					writer.write(builder.toString());
					writer.close();
				}
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath() + ".zip"));
				for(File f : new File(file.getAbsolutePath()).listFiles()){
					if(f.isDirectory()){
						this.writeSub(file.getAbsolutePath(), f, out);
					}
					else{
						FileInputStream in = new FileInputStream(f);


						out.putNextEntry(new ZipEntry(f.getAbsolutePath().replace(file.getAbsolutePath(), ""))); 

						byte[] b = new byte[1024];
						int count;

						while ((count = in.read(b)) > 0) {
							out.write(b, 0, count);
						}
						in.close();
					}
				}
				FileUtils.removeDirectory(modDirecotry);
				out.close();
			}
			catch(Exception e){e.printStackTrace();}
			dialog.dispose();
		}
		else{
			JOptionPane.showMessageDialog(Start.gui.frame, "Error: Cant compile no MCP found!",
					"Error: No MCP Found!", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void writeSub(String orginalFilePath, File file , ZipOutputStream out) throws Exception{
		for(File f : file.listFiles()){
			if(f.isDirectory()){
				this.writeSub(orginalFilePath, f, out);
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
