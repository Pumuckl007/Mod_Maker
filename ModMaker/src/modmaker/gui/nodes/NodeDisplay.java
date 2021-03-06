package modmaker.gui.nodes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JComponent;

public class NodeDisplay extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5638329437068814437L;
	public Stack<Node> nodes = new Stack<Node>();
	public ListinerOfMouse listener;
	public NodeDisplay(){
		nodes.add(new Node("Test", 100, 100, 150, 400, this));
		nodes.add(new Node("foo", 300, 100, 150, 400, this));
		nodes.add(new Node("bar", 500, 100, 150, 400, this));
		nodes.add(new Node("\uF200", 700, 100, 150, 400, this));
		MouseListen listen = new MouseListen();
		listener = listen;
		this.addKeyListener(listen);
		this.addMouseListener(listen);
		this.addMouseMotionListener(listen);
		this.setOpaque(false);
	}
	public void removeSelectedNode(){
		Node node = this.getSeletedNode();
		if(node != null){
			nodes.remove(node);
		}
		this.repaint();
	}
	public Node getSeletedNode(){
		Node node = null;
		boolean found = false;
		for(Node testNode : nodes){
			if(!found){
				if(testNode.isHighlighted){
					found = true;
					node = testNode;
				}
			}
		}
		return node;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint paint = new GradientPaint(0, 0, new Color(225,225,225),
				this.getWidth()/2, 0, new Color(250,250,250), true);
		g2.setPaint(paint);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(Node node : nodes){
			node.prepaint(g);
		}
		for(Node node : nodes){
			node.paint(g);
		}
	}
	public interface ListinerOfMouse{
		public void setSelectedNode(Node node);
		public Node getSelectedNode();
	}
	private class MouseListen implements MouseListener, MouseMotionListener, KeyListener, ListinerOfMouse{
		public Node selectedNode;
		private int offX,offY;
		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			boolean found = false;
			int val = nodes.size();
			for(int i = 0; i < val; i ++){
				Node node = nodes.get((val - 1) - i);
				if(!found){
					int x = e.getPoint().x;
					int y = e.getPoint().y;
					if(node.isInNode(e.getPoint())){
						node.isHighlighted = !node.isHighlighted;
						this.selectedNode = node;
						node.clicked(x, y);
						this.offX = x - node.x;
						this.offY = y - node.y;
						found = true;
						setCursor(new Cursor(Cursor.MOVE_CURSOR));
					}
					else{
						node.isHighlighted = false;
					}
				} else {
					node.isHighlighted = false;
				}
			}
			if(found){
				int index = nodes.size() -1;
				nodes.remove(this.selectedNode);
				nodes.insertElementAt(selectedNode, index);
				repaint();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(this.selectedNode != null){
				if(this.selectedNode.realeased(e.getX(), e.getY())){
					this.selectedNode = null;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				repaint();
			}
			recaculateNodePorts();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if(this.selectedNode != null){
				if(this.selectedNode.draged(e.getX(), e.getY())){
					ArrayList<Link> links = new ArrayList<Link>();
					this.selectedNode.isDraging = true;
					this.selectedNode.isHighlighted = true;
					this.selectedNode.x = e.getPoint().x - this.offX;
					this.selectedNode.y = e.getPoint().y - this.offY;
					setCursor(new Cursor(Cursor.MOVE_CURSOR));
					for(Node node : nodes){
						for(Link link : node.links){
							if(link.getPort() != null){
								if(link.getPort() == null){
									links.add(link);
								}
								else{
									link.update(link.getPort());
									link.update(link.getEndPort());
								}
							}
						}
						for(Link link : links){
							node.links.remove(link);
						}
					}
				}
				repaint();
			}
			else{
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void setSelectedNode(Node node) {
			this.selectedNode = node;
		}

		@Override
		public Node getSelectedNode() {
			return this.selectedNode;
		}

	}
	public void recaculateNodePorts(){
		for(Node node : this.nodes){
			for(NodePort port : node.ports){
				port.link = null;
				port.linkcount = 0;
			}
			node.link = null;
		}
		for(Node node : this.nodes){
			ArrayList<Link> linksToRemove = new ArrayList<Link>();
			for(Link link : node.links){
				if(link.getPort() != null && link.getEndPort() != null){
					if(!link.active()){
						link.getPort().linkcount --;
						link.getEndPort().linkcount = 0;
						linksToRemove.add(link);
					} else {
						if(link.getEndPort().linkcount < 1){
							link.getPort().linkcount ++;
							link.getEndPort().linkcount ++;
						} else {
							linksToRemove.add(link);
						}
					}
				}
				else{
					linksToRemove.add(link);
				}	
			}
			node.links.remove(linksToRemove);
		}
	}

}
