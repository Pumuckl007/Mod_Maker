package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import modmaker.Start;

public class DialogExportingGui {
	public JFrame frame;
	public boolean isFrameOpen;
	public void popUpFrame(String location){
		if(!isFrameOpen){
			this.isFrameOpen = true;
			SpringLayout layout = new SpringLayout();
			frame = new JFrame("Exporting To: " + location);
			frame.setLayout(layout);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setLocation(100, 50);
			JButton doneButton = new JButton("Cancel");
			frame.add(doneButton);
			doneButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Cancelled");
					Start.gui.exporting.frame.dispose();
					Start.gui.exporting.isFrameOpen = false;
				}

			});
			layout.putConstraint(SpringLayout.SOUTH, doneButton,-20,SpringLayout.SOUTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.WEST, doneButton,20,SpringLayout.WEST, frame.getContentPane());
			layout.putConstraint(SpringLayout.NORTH, doneButton,-60,SpringLayout.SOUTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.EAST, doneButton,180,SpringLayout.WEST, frame.getContentPane());

			Gui.stardardLookAndFeel(frame);

			frame.setSize(500, 375);
			//5. Show it.
			frame.setVisible(true);
		}
	}
}
