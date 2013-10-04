package modmaker.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import modmaker.Item;
import modmaker.Start;

import org.jdesktop.swingx.JXTable;

public class Gui {
	public JFrame frame;
	public boolean buttonPushed;
	public DialogModInfoGui modInfo = new DialogModInfoGui();
	public DialogExportingGui exporting = new DialogExportingGui();
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
				System.out.println("Added a Block");
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
				Item item = new Item("Null");
				Start.gui.items.addRow(item.getItemForTable());
				Start.main.items.add(item);
			}

		});
		JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 10,400,100);
		sizeSlider.setToolTipText("Slide to adjust the scale of the items/blocks");
		sizeSlider.setMinorTickSpacing(2);
		sizeSlider.setMajorTickSpacing(10);
		sMBLayout.putConstraint(SpringLayout.EAST, sizeSlider,0,SpringLayout.EAST, sliderAndButtons);
		sMBLayout.putConstraint(SpringLayout.WEST, sizeSlider,-200,SpringLayout.EAST, sliderAndButtons);
//		sliderAndButtons.add(sizeSlider);
		frame.add(sliderAndButtons, BorderLayout.NORTH);
		layout.putConstraint(SpringLayout.NORTH, sliderAndButtons,0,SpringLayout.SOUTH, toolBar);
		layout.putConstraint(SpringLayout.EAST, sliderAndButtons,0,SpringLayout.EAST, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, sliderAndButtons,25,SpringLayout.SOUTH, toolBar);
		layout.putConstraint(SpringLayout.WEST, sliderAndButtons,0,SpringLayout.WEST, frame.getContentPane());
		
		items = new ItemTableModle();
		Object[][] stringItems = new Object[Start.main.items.size()][5];
		int i = 0;
		for(Item item : Start.main.items){
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

		frame.setSize(800, 600);
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
				Start.gui.modInfo.popUpFrame("New");
			}

		});
		JButton saveButton = new JButton("Save");
		toolBar.add(saveButton);
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saved");
				try {
					JFileChooser fc = new JFileChooser();
					fc.showSaveDialog(Start.gui.frame);
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
				fc.showOpenDialog(Start.gui.frame);
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
				if(returnval == JFileChooser.APPROVE_OPTION && fc.getSelectedFile() != null)
					Start.gui.exporting.popUpFrame(fc.getSelectedFile().toString());
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
