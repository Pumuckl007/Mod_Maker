package modmaker.gui;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;

import modmaker.Item;
import modmaker.Recipy;
import modmaker.Start;

public class EditItem extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5667853163604646206L;
	private DialogEditItem editItem;
	public JButton icon;
	public ItemTableModle recipies;
	public EditItem(JFrame parent, String title, DialogEditItem editItem) {
		super(parent, title, true);
		Point p = parent.getLocation(); 
		setLocation(p.x,p.y);
		this.setSize(parent.getSize());
		this.editItem = editItem;
		this.addGui();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	private void addGui(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		JButton done = new JButton("Done");
		done.addActionListener(this);
		this.add(done);
		layout.putConstraint(SpringLayout.SOUTH, done,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, done,-20,SpringLayout.EAST, this.getContentPane());
		JToolBar name = this.generateTextBarWithLable("", "Name:", 20);
		JToolBar iD = this.generateTextBarWithLable("", "ID:", 20);
		this.add(name);
		this.add(iD);
		layout.putConstraint(SpringLayout.NORTH, iD,20,SpringLayout.SOUTH, name);
		ImageIcon imageicon = null;
			try {
				imageicon = new ImageIcon(new File("resources/textures/Tea-Bag.JPEG").toURI().toURL());
				imageicon = new ImageIcon(imageicon.getImage().getScaledInstance((int)122, (int)122, Image.SCALE_DEFAULT));
			} catch (IOException e) {
				e.printStackTrace();
			}
		icon = new JButton(imageicon);
		icon.addActionListener(new IconButtonActionListiner(icon, getParent()));
		this.add(icon);
		layout.putConstraint(SpringLayout.SOUTH, icon,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, icon,20,SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, icon,-148,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, icon,148,SpringLayout.WEST, this.getContentPane());
		JButton newRecipy = new JButton("Add New Recipy");
		this.add(newRecipy);
		layout.putConstraint(SpringLayout.EAST, newRecipy,-20,SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, newRecipy,20,SpringLayout.NORTH, this.getContentPane());
		this.recipies = new ItemTableModle();
		JScrollPane recipytable = this.drawTable(recipies);
		this.add(recipytable);
		layout.putConstraint(SpringLayout.NORTH, recipytable,20,SpringLayout.SOUTH, newRecipy);
		layout.putConstraint(SpringLayout.EAST, recipytable,0,SpringLayout.EAST, newRecipy);
		layout.putConstraint(SpringLayout.SOUTH, recipytable,-20,SpringLayout.NORTH, done);
		layout.putConstraint(SpringLayout.WEST, recipytable,20,SpringLayout.EAST, iD);
	}
	public JScrollPane drawTable(ItemTableModle recipies){
		Object[][] stringItems = new Object[this.editItem.item.recipies.size()][3];
		int i = 0;
		for(Recipy recipy : this.editItem.item.recipies){
			stringItems[i] = recipy.getStringForTable();
			i++;
		}
		recipies.setDataVector(stringItems, new Object[] { "Type", "Data", "Remove"});
		JTable modStuffTable = new JTable(recipies);
		modStuffTable.getColumn("Remove").setCellRenderer(new ButtonRenderer());
		modStuffTable.getColumn("Remove").setCellEditor(
	        new ButtonEditor(new JCheckBox()));
		JScrollPane modStuff = new JScrollPane(modStuffTable);
		return modStuff;
	}
	public void actionPerformed(ActionEvent e) {
		this.editItem.done = true;
		setVisible(false); 
		dispose(); 
	}
	public JToolBar generateTextBarWithLable(String textInBox, String lable, int lenght){
		JToolBar textBar = new JToolBar();
		textBar.setFloatable(false);
		JLabel jLable = new JLabel(lable);
		textBar.add(jLable);
		JTextField textFeild = new JTextField(textInBox, lenght);
		textBar.add(textFeild);
		return textBar;
	}
}
