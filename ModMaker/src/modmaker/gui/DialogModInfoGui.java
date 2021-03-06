package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modmaker.Mod;
import modmaker.Start;

public class DialogModInfoGui extends JDialog implements ActionListener, ChangeListener{
	private static final long serialVersionUID = 1L;
	public boolean isthisOpen;
	public String name = Start.main.mod.name;
	public String info = Start.main.mod.info;
	public String by = Start.main.mod.by;
	public boolean exportSource = Start.main.mod.exportSource;
	public boolean replace;
	public OpenModInfo open;
	public JButton doneButton;
	public DialogModInfoGui(String title, boolean replace, OpenModInfo open){
		super(Start.gui.frame, title, true);
		this.open = open;
		this.replace = replace;
		this.isthisOpen = true;
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		if(replace){
			name = "";
			info = "";
			by = "";
			exportSource = false;
		}
		else{
			name = Start.main.mod.name;
			info = Start.main.mod.info;
			by = Start.main.mod.by;
			exportSource = Start.main.mod.exportSource;
		}
		JToolBar modName = this.generateTextBarWithLable(name, "Mod Name:", 20, 1);
		this.add(modName);
		JToolBar description = this.generateTextBarWithLable(info, "Description:", 20, 2);
		layout.putConstraint(SpringLayout.NORTH, description,20,SpringLayout.SOUTH, modName);
		this.add(description);
		JToolBar yourName = this.generateTextBarWithLable(by, "Author's Name:", 20, 3);
		layout.putConstraint(SpringLayout.NORTH, yourName,20,SpringLayout.SOUTH, description);
		this.add(yourName);
		doneButton = new JButton("Done");
		this.add(doneButton);
		doneButton.addActionListener(this);
		layout.putConstraint(SpringLayout.SOUTH, doneButton,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, doneButton,-20,SpringLayout.EAST, this.getContentPane());
		JCheckBox exportSource = new JCheckBox("Export Source", this.exportSource);
		this.add(exportSource);
		exportSource.setBorderPainted(true);
		exportSource.setMultiClickThreshhold((long)0.25);
		exportSource.addChangeListener(this);
		layout.putConstraint(SpringLayout.NORTH, exportSource,20,SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, exportSource,-20,SpringLayout.EAST, this.getContentPane());
		doneButton.setEnabled(!name.equals(""));
		this.setSize(800, 600);
		this.setLocationRelativeTo(Start.gui.frame);
		this.setVisible(true);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		this.exportSource = !this.exportSource;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(replace){
			Start.main.mod = new Mod(name, info, by, exportSource);
			int k = Start.gui.items.getRowCount();
			for(int i = 0; i < k; i++){
				Start.gui.items.removeRow(k-i-1);
			}
		}
		else{
			Start.main.mod.by = by;
			Start.main.mod.exportSource = exportSource;
			Start.main.mod.info = info;
			Start.main.mod.name = name;
		}
		this.dispose();
	}
	private class InfoCaretListener implements CaretListener{
		int id;
		DialogModInfoGui dialog;
		public InfoCaretListener(int i, DialogModInfoGui dialog){
			this.dialog = dialog;
			id = i;
		}
		@Override
		public void caretUpdate(CaretEvent e) {
			if(id == 1){
				dialog.name = ((JTextField)e.getSource()).getText();
			}
			else if(id == 2){
				dialog.info = ((JTextField)e.getSource()).getText();
			}
			else{
				dialog.by = ((JTextField)e.getSource()).getText();
			}
			dialog.doneButton.setEnabled(!dialog.name.equals(""));
		}

	}
	public JToolBar generateTextBarWithLable(String textInBox, String lable, int lenght, int id){
		JToolBar textBar = new JToolBar();
		textBar.setFloatable(false);
		JLabel jLable = new JLabel(lable);
		textBar.add(jLable);
		JTextField textFeild = new JTextField(textInBox, lenght);
		textFeild.addCaretListener(new InfoCaretListener(id, this));
		textBar.add(textFeild);
		return textBar;
	}
}
