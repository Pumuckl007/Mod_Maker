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
import modmaker.Recipy;
import modmaker.Start;
import modmaker.gui.DialogExportingGui;

public class Export {
	public static final String items = ""
			+ "package @PACKAGE@;\n"
			+ "\n"
			+ "import net.minecraft.block.Block;\n"
			+ "import net.minecraft.item.Item;\n"
			+ "import net.minecraft.item.ItemStack;"
			+ "\n"
			+ "\n"
			+ "\n"
			+ "import cpw.mods.fml.common.registry.GameRegistry;\n"
			+ "\npublic class InitItems {\n"
			+ "\n"
			+ "    @ITEMINSTANCES@\n"
			+ "\n"
			+ "    public static void init() {\n"
			+ "\n"
			+ "        @INITITEM@\n"
			+ "\n"
			+ "\n"
			+ "\n"
			+ "        @ITEMRECIPTIES@\n"
			+ "\n"
			+ "    }\n"
			+ "}";
	@SuppressWarnings("unused")
	public void export(Mod mod, File file){
		if(Main.hasMcpPremistion || mod.exportSource){
			DialogExportingGui dialog = DialogExportingGui.popUpthis(Start.gui.frame, file.getAbsolutePath());
			try{
				File modDirecotry = new File(file.getAbsolutePath() + "/" + mod.name.toLowerCase() + "/");
				modDirecotry.mkdirs();
				File itemDirecotry = new File(modDirecotry.getAbsolutePath() + "/items/");
				itemDirecotry.mkdir();
				
				String modItems = items;
				modItems = modItems.replace("@PACKAGE@", mod.name.toLowerCase() + ".items");
				StringBuilder itemInstances = new StringBuilder();
				StringBuilder initItem = new StringBuilder();
				StringBuilder itemRecipies = new StringBuilder();
				
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
					String itemVarName = itemfile.getName().replace(".java", "").replaceFirst(Character.toString(item.getName().charAt(0)),
							Character.toString(item.getName().toLowerCase().charAt(0)));
					itemInstances.append("public static Item " + itemVarName + ";\n    ");
					initItem.append(itemVarName + " = new " + itemfile.getName().replace(".java", "") + "();\n    ");
					for(Recipy recpiy : item.recipies)
					itemRecipies.append("//" + item.getName() + " : " + recpiy.recipy + "\n    ");
				}
				
				
				modItems = modItems.replace("@ITEMINSTANCES@", itemInstances.toString());
				modItems = modItems.replace("@INITITEM@", initItem.toString());
				modItems = modItems.replace("@ITEMRECIPTIES@", itemRecipies.toString());
				BufferedWriter writer = new BufferedWriter(new FileWriter(itemDirecotry.getAbsolutePath() + "/InitItems.java"));
				writer.append(modItems);
				writer.close();

				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath() + ".zip"));
				for(File f : new File(file.getAbsolutePath()).listFiles()){
					if(f.isDirectory()){
						FileUtils.writeSub(file.getAbsolutePath(), f, out);
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
				modDirecotry.delete();
			}
			catch(Exception e){e.printStackTrace();}
			dialog.dispose();
		}
		else{
			JOptionPane.showMessageDialog(Start.gui.frame, "Error: Cant compile no MCP found!",
					"Error: No MCP Found!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
