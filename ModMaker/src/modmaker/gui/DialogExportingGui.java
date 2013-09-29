package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;

import modmaker.Start;

public class DialogExportingGui {
	public JFrame frame;
	public boolean isFrameOpen;
	public JLabel label;
	public void popUpFrame(String location){
		if(!isFrameOpen){
			this.isFrameOpen = true;
			SpringLayout layout = new SpringLayout();
			frame = new JFrame("Exporting To: " + location);
			frame.setLayout(layout);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
			JProgressBar pBar = new JProgressBar();
			pBar.setIndeterminate(true);
			frame.add(pBar);
			layout.putConstraint(SpringLayout.NORTH, pBar,20,SpringLayout.NORTH, frame.getContentPane());
			layout.putConstraint(SpringLayout.WEST, pBar,20,SpringLayout.WEST, frame.getContentPane());
			layout.putConstraint(SpringLayout.EAST, pBar,-20,SpringLayout.EAST, frame.getContentPane());
			label = new JLabel("Generating Client Proxy ...");
			frame.add(label);
			layout.putConstraint(SpringLayout.NORTH, label,20,SpringLayout.SOUTH, pBar);
			layout.putConstraint(SpringLayout.WEST, label,0,SpringLayout.WEST, pBar);
			Gui.stardardLookAndFeel(frame);

			frame.setSize(500, 375);
			frame.setLocationRelativeTo(null);
			//5. Show it.
			frame.setVisible(true);
		}
	}
}
