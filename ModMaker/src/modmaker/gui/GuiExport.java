package modmaker.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modmaker.Start;

public class GuiExport {
	public JFrame frame;
	public void getFrame(){
		frame = new JFrame("Export");
		JPanel panelLeft = new JPanel();
		JPanel panelRight = new JPanel();
		JButton newButton = new JButton("New");
		panelLeft.add(newButton);
		newButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("New");
			}

		});
		JButton saveButton = new JButton("Save");
		panelLeft.add(saveButton);
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saved");
			}

		});
		JButton openButton = new JButton("Open");
		panelLeft.add(openButton);
		openButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Opened");
			}

		});
		JButton cancleButton = new JButton("Cancle");
		panelRight.add(cancleButton);
		cancleButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Cancled");
				Start.gui.buttonPushed = false;
				Start.gui.guiExport.frame.dispose();
			}

		});
		JButton okButton = new JButton("OK");
		panelRight.add(okButton);
		okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("OK");
			}

		});

		frame.add(panelLeft, BorderLayout.WEST);
		frame.add(panelRight, BorderLayout.SOUTH);
		frame.pack();

		//5. Show it.
		frame.setVisible(true);

	}
}
