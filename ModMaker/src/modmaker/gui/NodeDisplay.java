package modmaker.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

public class NodeDisplay extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5638329437068814437L;
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public NodeDisplay(){
		nodes.add(new Node("test", 100, 100, 150, 500, Color.darkGray));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Node node : nodes){
			node.paint(g);
		}
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
		public int x,y,width,hight;
		public String title;
		public Color color;
		public Node(String title, int x, int y, int width,int hight, Color color){
			this.title = title;
			this.x = x;
			this.y = y;
			this.width = width;
			this.hight = hight;
			this.color = color;
		}
		public void paint(Graphics g){
			g.setColor(this.color);
			g.fillArc(x, y, width, 10, 0, 90);
			g.fillRect(x + 10, y, this.width, this.hight - 10);
		}
	}
	
}
