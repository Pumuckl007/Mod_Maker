package modmaker.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import modmaker.Start;

public class Gui {
	public JFrame frame;
	public GuiExport guiExport = new GuiExport();
	public boolean buttonPushed;
	public DialogModInfoGui modInfo = new DialogModInfoGui();
	public DialogExportingGui exporting = new DialogExportingGui();
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
		layout.putConstraint(SpringLayout.SOUTH, toolBar,40,SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, toolBar,0,SpringLayout.WEST, frame.getContentPane());
		JToolBar spicificMenuBar = new JToolBar();
		spicificMenuBar.setLayout(new SpringLayout());
		spicificMenuBar.setFloatable(false);
		JButton addBlock = new JButton("Add Block");
		spicificMenuBar.add(addBlock);
		addBlock.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Added a Block");
			}

		});
		JButton addItem = new JButton("Add Item");
		spicificMenuBar.add(addItem);
		addItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Added an Item");
			}

		});
		frame.add(spicificMenuBar, BorderLayout.NORTH);
		layout.putConstraint(SpringLayout.NORTH, spicificMenuBar,0,SpringLayout.SOUTH, toolBar);
		layout.putConstraint(SpringLayout.EAST, spicificMenuBar,0,SpringLayout.EAST, frame.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, spicificMenuBar,25,SpringLayout.SOUTH, toolBar);
		layout.putConstraint(SpringLayout.WEST, spicificMenuBar,0,SpringLayout.WEST, frame.getContentPane());


		Gui.stardardLookAndFeel(frame);

		frame.setSize(800, 600);
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
	}
}
