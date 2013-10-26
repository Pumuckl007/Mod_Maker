package modmaker.gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import modmaker.gui.nodes.Node;
import modmaker.gui.nodes.NodeDisplay;

public class GuiNodeEdit extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -173828128413757211L;
	public SpringLayout layout;
	public NodeDisplay display;
	public GuiNodeEdit(JDialog parent){
		super(parent, "Node Edittor");
		Point p = parent.getLocation(); 
		this.layout = new SpringLayout();
		this.setLayout(layout);
		this.initGui();
		setLocation(p.x,p.y);
		this.setSize(parent.getParent().getSize());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void initGui(){
		display = new NodeDisplay();
		JScrollPane scroll = new JScrollPane(display);
		this.add(scroll);
		layout.putConstraint(SpringLayout.NORTH, scroll, 100, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, scroll, 0, SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, scroll, 0, SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, this.getContentPane());
		
		JButton addNormalNode = new JButton("Add Normal Node");
		addNormalNode.setToolTipText("Add A Useless Node");
		addNormalNode.addActionListener(new AddNormalNode());
		this.add(addNormalNode);
		layout.putConstraint(SpringLayout.NORTH, addNormalNode, 0, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, addNormalNode, 200, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, addNormalNode, 48, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, addNormalNode, 0, SpringLayout.WEST, this.getContentPane());
		JButton removeNode = new JButton("Remove");
		removeNode.setToolTipText("Removes the seleted node");
		removeNode.addActionListener(new RemoveNode());
		this.add(removeNode);
		layout.putConstraint(SpringLayout.NORTH, removeNode, 52, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, removeNode, 200, SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, removeNode, 98, SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, removeNode, 0, SpringLayout.WEST, this.getContentPane());
	}
	private class AddNormalNode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			display.nodes.add(display.nodes.size(), new Node("New Node" + display.nodes.size(), 200, 100, 150, 400, display));
			display.repaint();
		}
	}
	private class RemoveNode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			display.removeSelectedNode();
		}
	}
}
