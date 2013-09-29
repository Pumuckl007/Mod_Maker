package modmaker.gui;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import modmaker.Recipy;

import org.jdesktop.swingx.JXTable;

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
	private class NameCaretListener implements CaretListener{
		private EditItem editItem;
		public NameCaretListener(EditItem editItem){
			this.editItem = editItem;
		}
		@Override
		public void caretUpdate(CaretEvent e) {
			this.editItem.editItem.item.setName(((JTextField)e.getSource()).getText());
		}
		
	}
	private class IDCaretListener implements CaretListener{
		private EditItem editItem;
		public IDCaretListener(EditItem editItem){
			this.editItem = editItem;
		}
		@Override
		public void caretUpdate(CaretEvent e) {
			boolean candoIt = true;
			try{
				new Integer(((JTextField)e.getSource()).getText());
			}
			catch(Exception ex){
				candoIt = false;
			}
			if(candoIt)
			this.editItem.editItem.item.setId(new Integer(((JTextField)e.getSource()).getText()));
		}
		
	}
	private void addGui(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		JButton done = new JButton("Done");
		done.addActionListener(this);
		this.add(done);
		layout.putConstraint(SpringLayout.SOUTH, done,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, done,-20,SpringLayout.EAST, this.getContentPane());
		JToolBar name = this.generateTextBarWithLable(new NameCaretListener(this),this.editItem.item.getName(), "Name:", 20);
		JToolBar iD = this.generateTextBarWithLable(new IDCaretListener(this), this.editItem.item.getId().toString(), "ID:", 20);
		this.add(name);
		this.add(iD);
		layout.putConstraint(SpringLayout.NORTH, iD,20,SpringLayout.SOUTH, name);
		ImageIcon imageicon = null;
		imageicon = new ImageIcon(this.editItem.item.getImage());
		imageicon = new ImageIcon(imageicon.getImage().getScaledInstance((int)122, (int)122, Image.SCALE_DEFAULT));
		icon = new JButton(imageicon);
		icon.addActionListener(new IconButtonActionListiner(icon, getParent(), this.editItem.item));
		this.add(icon);
		layout.putConstraint(SpringLayout.SOUTH, icon,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, icon,20,SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, icon,-148,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, icon,148,SpringLayout.WEST, this.getContentPane());
		JButton newRecipy = new JButton("Add New Recipy");
		newRecipy.addActionListener(new EventNewRecipyLisiner(this, this.editItem.item));
		this.add(newRecipy);
		layout.putConstraint(SpringLayout.EAST, newRecipy,-20,SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, newRecipy,20,SpringLayout.NORTH, this.getContentPane());
		this.recipies = new ItemTableModle(this.editItem.item);
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
		JXTable modStuffTable = new JXTable(recipies);
		modStuffTable.getColumn("Remove").setCellRenderer(new ButtonRenderer());
		modStuffTable.getColumn("Remove").setCellEditor(
				new RemoveButton(new JCheckBox()));
		JScrollPane modStuff = new JScrollPane(modStuffTable);
		return modStuff;
	}
	public void actionPerformed(ActionEvent e) {
		this.editItem.done = true;
		setVisible(false); 
		dispose(); 
	}
	public JToolBar generateTextBarWithLable(CaretListener listener, String textInBox, String lable, int lenght){
		JToolBar textBar = new JToolBar();
		textBar.setFloatable(false);
		JLabel jLable = new JLabel(lable);
		textBar.add(jLable);
		JTextField textFeild = new JTextField(textInBox, lenght);
		textFeild.addCaretListener(listener);
		textBar.add(textFeild);
		return textBar;
	}
}
