package modmaker.gui;

import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class GuiNodeEdit extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -173828128413757211L;
	public SpringLayout layout;
	public GuiNodeEdit(JDialog parent){
		super(parent, "Node Edittor");
		Point p = parent.getLocation(); 
		this.layout = new SpringLayout();
		this.setLayout(layout);
		this.initGui();
		setLocation(p.x,p.y);
		this.setSize(parent.getParent().getSize());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	public void initGui(){
		NodeDisplay display = new NodeDisplay();
		JScrollPane scroll = new JScrollPane(display);
		this.add(scroll);
		layout.putConstraint(SpringLayout.NORTH, scroll, 0, SpringLayout.VERTICAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, scroll, 0, SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, this.getContentPane());
	}
}
