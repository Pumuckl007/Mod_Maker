package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class DialogModInfoGui {
	public JFrame frame;
	public boolean isFrameOpen;
	public String name = "";
	public String info = "";
	public String by = "";
	public boolean exportSource;
	public void popUpFrame(String title){
		if(!isFrameOpen){
			this.isFrameOpen = true;
			SpringLayout layout = new SpringLayout();
			frame = new JFrame(title);
			frame.setLayout(layout);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JToolBar modName = this.generateTextBarWithLable(name, "Mod Name:", 20, 1);
			frame.add(modName);
			JToolBar description = this.generateTextBarWithLable(info, "Description:", 20, 2);
			layout.putConstraint(SpringLayout.NORTH, description,20,SpringLayout.SOUTH, modName);
			frame.add(description);
			JToolBar yourName = this.generateTextBarWithLable(by, "Author's Name:", 20, 3);
			layout.putConstraint(SpringLayout.NORTH, yourName,20,SpringLayout.SOUTH, description);
			frame.add(yourName);
			JButton doneButton = new JButton("Done");
			frame.add(doneButton);
			doneButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Start.main.mod = new Mod(Start.gui.modInfo.name, Start.gui.modInfo.info, Start.gui.modInfo.by, Start.gui.modInfo.exportSource);
					int k = Start.gui.items.getRowCount();
					for(int i = 0; i < k; i++){
						Start.gui.items.removeRow(k-i-1);
					}
					Start.gui.modInfo.name = "";
					Start.gui.modInfo.info = "";
					Start.gui.modInfo.by = "";
					Start.gui.modInfo.exportSource = false;
					Start.gui.modInfo.frame.dispose();
					Start.gui.modInfo.isFrameOpen = false;
				}

			});
			layout.putConstraint(SpringLayout.SOUTH, doneButton,-20,SpringLayout.SOUTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.EAST, doneButton,-20,SpringLayout.EAST, frame.getContentPane());
			JCheckBox exportSource = new JCheckBox("Export Source");
			frame.add(exportSource);
			exportSource.setBorderPainted(true);
			exportSource.setMultiClickThreshhold((long)0.25);
			exportSource.addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					Start.gui.modInfo.exportSource = !Start.gui.modInfo.exportSource;
				}
				
			});
			layout.putConstraint(SpringLayout.NORTH, exportSource,20,SpringLayout.NORTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.EAST, exportSource,-20,SpringLayout.EAST, frame.getContentPane());
			Gui.stardardLookAndFeel(frame);

			frame.setSize(500, 375);
			frame.setLocationRelativeTo(null);
			//5. Show it.
			frame.setVisible(true);
		}
	}
	private class InfoCaretListener implements CaretListener{
		int id;
		public InfoCaretListener(int i){
			id = i;
		}
		@Override
		public void caretUpdate(CaretEvent e) {
			if(id == 1){
				Start.gui.modInfo.name = ((JTextField)e.getSource()).getText();
			}
			else if(id == 2){
				Start.gui.modInfo.info = ((JTextField)e.getSource()).getText();
			}
			else{
				Start.gui.modInfo.by = ((JTextField)e.getSource()).getText();
			}
		}
		
	}
	public JToolBar generateTextBarWithLable(String textInBox, String lable, int lenght, int id){
		JToolBar textBar = new JToolBar();
		textBar.setFloatable(false);
		JLabel jLable = new JLabel(lable);
		textBar.add(jLable);
		JTextField textFeild = new JTextField(textInBox, lenght);
		textFeild.addCaretListener(new InfoCaretListener(id));
		textBar.add(textFeild);
		return textBar;
	}
}
