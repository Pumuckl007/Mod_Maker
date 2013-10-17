package modmaker.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class GuiTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8127628290181568377L;
	public GuiTest(){
		super("ModMaker");
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		this.setSize(800,800);
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Other Button");
		b1.addActionListener(new b1list(b1,b2));
		this.add(b1);
		b2.addActionListener(new b2list(b1, b2));
		this.add(b2);
		layout.putConstraint(SpringLayout.WEST, b1, 20, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, b2, -20, SpringLayout.EAST, this.getContentPane());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	private class b2list implements ActionListener{

		JButton b1;
		JButton b2;
		public b2list(JButton b1, JButton b2){
			this.b1 = b1;
			this.b2 = b2;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			b1.setVisible(true);
			b2.setVisible(false);
			System.out.println("Button 2");
		}
		
	}
	private class b1list implements ActionListener{

		JButton b1;
		JButton b2;
		public b1list(JButton b1, JButton b2){
			this.b1 = b1;
			this.b2 = b2;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			b1.setVisible(false);
			b2.setVisible(true);
			System.out.println("Button 1");
		}
		
	}

}
