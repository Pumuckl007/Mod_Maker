package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;

public class DialogExportingGui extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -880976417223366283L;
	public JLabel label;
	public boolean done;
	public DialogExportingGui(JFrame parent, String title){
		super(parent, title);
			SpringLayout layout = new SpringLayout();
			this.setLayout(layout);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			JButton doneButton = new JButton("Cancel");
			this.add(doneButton);
			doneButton.addActionListener(this);
			layout.putConstraint(SpringLayout.SOUTH, doneButton,-20,SpringLayout.SOUTH, this.getContentPane());
			layout.putConstraint(SpringLayout.WEST, doneButton,20,SpringLayout.WEST, this.getContentPane());
			layout.putConstraint(SpringLayout.NORTH, doneButton,-60,SpringLayout.SOUTH, this.getContentPane());
			layout.putConstraint(SpringLayout.EAST, doneButton,180,SpringLayout.WEST, this.getContentPane());
			JProgressBar pBar = new JProgressBar();
			pBar.setIndeterminate(true);
			this.add(pBar);
			layout.putConstraint(SpringLayout.NORTH, pBar,20,SpringLayout.NORTH, this.getContentPane());
			layout.putConstraint(SpringLayout.WEST, pBar,20,SpringLayout.WEST, this.getContentPane());
			layout.putConstraint(SpringLayout.EAST, pBar,-20,SpringLayout.EAST, this.getContentPane());
			label = new JLabel("Generating Client Proxy ...");
			this.add(label);
			layout.putConstraint(SpringLayout.NORTH, label,20,SpringLayout.SOUTH, pBar);
			layout.putConstraint(SpringLayout.WEST, label,0,SpringLayout.WEST, pBar);

			this.setSize(500, 375);
			this.setLocationRelativeTo(null);
			//5. Show it.
			this.setVisible(true);
	}
	public static DialogExportingGui popUpthis(JFrame parent, String location){
		DialogExportingGui dialog = new DialogExportingGui(parent, location);
		return dialog;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		this.done = true;
	}
}
