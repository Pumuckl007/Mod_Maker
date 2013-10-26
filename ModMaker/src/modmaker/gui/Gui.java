package modmaker.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import modmaker.Item;
import modmaker.ItemType;
import modmaker.Start;
import modmaker.export.Export;
import modmaker.export.SaveSlashLoad;

import org.jdesktop.swingx.JXTable;

public class Gui {
	public JFrame frame;
	public boolean buttonPushed;
	public ItemTableModle items;
	public Gui(){
		SpringLayout layout = new SpringLayout();
		frame = new JFrame("Mod Maker");
		frame.setLayout(layout);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		Gui.initButtons(toolBar);
		frame.add(toolBar, BorderLayout.NORTH);
		layout.putConstraint(SpringLayout.NORTH, toolBar,0,SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.EAST, toolBar,0,SpringLayout.EAST, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, toolBar,35,SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, toolBar,0,SpringLayout.WEST, frame.getContentPane());
		JToolBar sliderAndButtons = new JToolBar();
		SpringLayout sMBLayout = new SpringLayout();
		sliderAndButtons.setLayout(sMBLayout);
		sliderAndButtons.setFloatable(false);
		JButton addBlock = new JButton("Add Block");
		sliderAndButtons.add(addBlock);
		sMBLayout.putConstraint(SpringLayout.NORTH, addBlock,1,SpringLayout.NORTH, sliderAndButtons);
		sMBLayout.putConstraint(SpringLayout.SOUTH, addBlock,0,SpringLayout.SOUTH, sliderAndButtons);
		addBlock.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item = new Item("Undifind", ItemType.Block);
				Start.gui.items.addRow(item.getItemForTable());
				Start.main.mod.items.add(item);
			}

		});
		JButton addItem = new JButton("Add Item");
		sliderAndButtons.add(addItem);
		sMBLayout.putConstraint(SpringLayout.NORTH, addItem,1,SpringLayout.NORTH, sliderAndButtons);
		sMBLayout.putConstraint(SpringLayout.SOUTH, addItem,0,SpringLayout.SOUTH, sliderAndButtons);
		sMBLayout.putConstraint(SpringLayout.WEST, addItem,5,SpringLayout.EAST, addBlock);
		addItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Item item = new Item("Undifind", ItemType.Item);
				Start.gui.items.addRow(item.getItemForTable());
				Start.main.mod.items.add(item);
			}

		});
		frame.add(sliderAndButtons, BorderLayout.NORTH);
		layout.putConstraint(SpringLayout.NORTH, sliderAndButtons,0,SpringLayout.SOUTH, toolBar);
		layout.putConstraint(SpringLayout.EAST, sliderAndButtons,0,SpringLayout.EAST, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, sliderAndButtons,25,SpringLayout.SOUTH, toolBar);
		layout.putConstraint(SpringLayout.WEST, sliderAndButtons,0,SpringLayout.WEST, frame.getContentPane());

		items = new ItemTableModle();
		Object[][] stringItems = new Object[Start.main.mod.items.size()][5];
		int i = 0;
		for(Item item : Start.main.mod.items){
			stringItems[i] = item.getItemForTable();
			i++;
		}
		items.setDataVector(stringItems, new Object[] { "Type", "Name", "ID", "Edit", "Delete"});
		JXTable modStuffTable = new JXTable(items);
		modStuffTable.getColumn("Edit").setCellRenderer(new ButtonRenderer());
		modStuffTable.getColumn("Edit").setCellEditor(
				new ButtonEditor(new JCheckBox()));
		modStuffTable.getColumn("Delete").setCellRenderer(new ButtonRenderer());
		modStuffTable.getColumn("Delete").setCellEditor(
				new ButtonEditor(new JCheckBox()));
		modStuffTable.setAutoCreateRowSorter(true);
		modStuffTable.toggleSortOrder(1);
		modStuffTable.setSortable(false);
		JScrollPane modStuff = new JScrollPane(modStuffTable);
		frame.add(modStuff);
		layout.putConstraint(SpringLayout.NORTH, modStuff,0,SpringLayout.SOUTH, sliderAndButtons);
		layout.putConstraint(SpringLayout.EAST, modStuff,0,SpringLayout.EAST, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, modStuff,0,SpringLayout.SOUTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, modStuff,0,SpringLayout.WEST, frame.getContentPane());

		Gui.stardardLookAndFeel(frame);

		frame.setSize(1120, 840);
		frame.setLocationRelativeTo(null);
		//5. Show it.
		frame.setVisible(true);

	}
	/**					try {
	int hight = 800;
	if(args.length > 0){
		hight = new Integer(args[0]);
	}
	Display.setDisplayMode(new DisplayMode((hight/2)*3, hight));
	Display.setTitle("Mod Maker");
	Display.create();
	GL11.glOrtho(0, 1200, 800, 0, -1, 1);
	File f = new File(System.getProperty("user.dir"));
	System.out.println(System.getProperty("user.dir"));
	System.out.println(f.getAbsolutePath());
	Gui gui = new Gui();
	while(!Display.isCloseRequested()){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(255, 255, 255, 255);
		gui.render();
		Display.sync(60);
		Display.update();
	}
} catch (LWJGLException e) {
	e.printStackTrace();
}
Display.destroy();
	 */
	public static void stardardLookAndFeel(JFrame frame){
		try{ 
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
			if(frame != null)
				SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void initButtons(JToolBar toolBar){
		JButton newButton = new JButton("New");
		toolBar.add(newButton);
		newButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new OpenModInfo().open("New", true);
			}

		});
		JButton saveButton = new JButton("Save");
		toolBar.add(saveButton);
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser fc = new JFileChooser();
					int returnval = fc.showSaveDialog(Start.gui.frame);
					if(returnval == JFileChooser.APPROVE_OPTION && fc.getSelectedFile() != null){
						SaveSlashLoad.save(Start.main.mod, new File(fc.getSelectedFile().getAbsolutePath() + "/"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		JButton openButton = new JButton("Open");
		toolBar.add(openButton);
		openButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileFilter(){

					@Override
					public boolean accept(File file) {
						return file.isDirectory() || file.getName().contains(".mcm");
					}

					@Override
					public String getDescription() {
						return "ModMaker files (.mcm)";
					}

				});
				int returnval = fc.showOpenDialog(Start.gui.frame);
				if(returnval == JFileChooser.APPROVE_OPTION && fc.getSelectedFile() != null){
					SaveSlashLoad.load(fc.getSelectedFile());
				}
			}

		});
		JButton exportButton = new JButton("Export");
		toolBar.add(exportButton);
		exportButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		exportButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnval = fc.showDialog(Start.gui.frame, "Export");
				if(returnval == JFileChooser.APPROVE_OPTION && fc.getSelectedFile() != null){
					new Export().export(Start.main.mod, fc.getSelectedFile());
				}
			}
		});
		JButton modInfoButton = new JButton("Mod Info");
		toolBar.add(modInfoButton);
		modInfoButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new OpenModInfo().open("Mod Info", false);
			}
		});
		JButton aboutButton = new JButton("About");
		toolBar.add(aboutButton);
		aboutButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		aboutButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new DialogAbout().openGui();
			}
		});
	}
}
