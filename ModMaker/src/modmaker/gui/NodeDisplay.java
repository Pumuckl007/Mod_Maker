package modmaker.gui;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class NodeDisplay extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5638329437068814437L;

	public NodeDisplay(){
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 100, 100);
	}

	@Override
	public void repaint(long tm, int x, int y, int width, int height) {
		super.repaint(tm, x, y, width, height);
	}

	@Override
	public void repaint(Rectangle r) {
		super.repaint(r);
	}
	public class Node{
		
	}
	
}