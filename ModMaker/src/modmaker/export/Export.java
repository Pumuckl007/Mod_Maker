package modmaker.export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file.getAbsolutePath() + ".zip"));
				
				String modItems = items;
				modItems = modItems.replace("@PACKAGE@", mod.name.toLowerCase() + ".items");
				StringBuilder itemInstances = new StringBuilder();
				StringBuilder initItem = new StringBuilder();
				StringBuilder itemRecipies = new StringBuilder();
				ArrayList<String> itemfiles = new ArrayList<String>();
				for(Item item : mod.items){
					String itemfile = "Item/Items" + item.getName() + ".java";
					Integer i = 2;
					while(itemfiles.contains(itemfile)){
						itemfile = "Item/Items" + item.getName() + i.toString() + ".java";
						i++;
					}
					itemfiles.add(itemfile);
					StringBuilder builder = new StringBuilder();
					builder.append("package " + mod.name.toLowerCase() + ".items;");
					builder.append("\nimport net.minecraft.client.renderer.texture.IconRegister;\nimport net.minecraft.item.Item;");
					builder.append("\nimport cpw.mods.fml.relauncher.Side;\nimport cpw.mods.fml.relauncher.SideOnly;");
					builder.append("\npublic class " + itemfile.replace(".java", "") +" extends Item {");
					builder.append("\npublic " + itemfile.replace(".java", "") +"() {\nsuper(" + item.getId().toString() + "-256);\n}");
					builder.append("\n}");
					FileUtils.writerStringToZip(out, builder.toString(), itemfile);
					String itemVarName = itemfile.replace(".java", "").replaceFirst(Character.toString(item.getName().charAt(0)),
							Character.toString(item.getName().toLowerCase().charAt(0)));
					itemInstances.append("public static Item " + itemVarName + ";\n    ");
					initItem.append(itemVarName + " = new " + itemfile.replace(".java", "") + "();\n    ");
					for(Recipy recpiy : item.recipies)
					itemRecipies.append("//" + item.getName() + " : " + recpiy.recipy + "\n    ");
				}
				modItems = modItems.replace("@ITEMINSTANCES@", itemInstances.toString());
				modItems = modItems.replace("@INITITEM@", initItem.toString());
				modItems = modItems.replace("@ITEMRECIPTIES@", itemRecipies.toString());
				FileUtils.writerStringToZip(out, modItems, "Items/InitItems.java");
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
}
