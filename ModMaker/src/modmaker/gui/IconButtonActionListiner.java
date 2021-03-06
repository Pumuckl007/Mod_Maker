package modmaker.gui;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import modmaker.Item;

public class IconButtonActionListiner implements ActionListener{
	private JButton icon;
	private Container parent;
	private Item item;
	public IconButtonActionListiner(JButton icon, Container parent, Item item){
		this.icon = icon;
		this.parent = parent;
		this.item = item;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new FileFilter(){

				@Override
				public boolean accept(File f) {
					return f.toString().contains("jpg") || f.toString().contains("png") || f.toString().contains("gif") || f.isDirectory();
				}

				@Override
				public String getDescription() {
					return "Image(jpg,png,gif)";
				}
				
			});
			int state = fc.showOpenDialog(this.parent);
			if(state == JFileChooser.APPROVE_OPTION){
				ImageIcon imageicon = null;
				File selectedFile = fc.getSelectedFile();
				try {
					imageicon = new ImageIcon(selectedFile.toURI().toURL());
					imageicon = new ImageIcon(imageicon.getImage().getScaledInstance((int)122, (int)122, Image.SCALE_DEFAULT));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.item.setImageFile(selectedFile);
				this.icon.setIcon(imageicon);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
