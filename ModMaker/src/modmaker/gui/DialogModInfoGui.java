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

import modmaker.Start;

public class DialogModInfoGui {
	public JFrame frame;
	public boolean isFrameOpen;
	public void popUpFrame(String title){
		if(!isFrameOpen){
			this.isFrameOpen = true;
			SpringLayout layout = new SpringLayout();
			frame = new JFrame(title);
			frame.setLayout(layout);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JToolBar modName = this.generateTextBarWithLable("", "Mod Name:", 20);
			frame.add(modName);
			JToolBar description = this.generateTextBarWithLable("", "Description:", 20);
			layout.putConstraint(SpringLayout.NORTH, description,20,SpringLayout.SOUTH, modName);
			frame.add(description);
			JToolBar yourName = this.generateTextBarWithLable("", "Author's Name:", 20);
			layout.putConstraint(SpringLayout.NORTH, yourName,20,SpringLayout.SOUTH, description);
			frame.add(yourName);
			JButton doneButton = new JButton("Done");
			frame.add(doneButton);
			doneButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Doned");
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
			layout.putConstraint(SpringLayout.NORTH, exportSource,20,SpringLayout.NORTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.EAST, exportSource,-20,SpringLayout.EAST, frame.getContentPane());
			Gui.stardardLookAndFeel(frame);

			frame.setSize(500, 375);
			frame.setLocationRelativeTo(null);
			//5. Show it.
			frame.setVisible(true);
		}
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
