package modmaker.gui.nodes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class Node {

	public int x,y,width,height;
	public String title;
	public Color color, otherColor, thirdColor;
	public Color highliteColor = Color.yellow;
	public boolean isHighlighted = false;
	public int hightliteRadius = 2;
	public boolean isDraging;
	public JPanel contentPane;
	private JScrollPane scrollPane;
	public SpringLayout layout;
	public ArrayList<NodePort> ports = new ArrayList<NodePort>();
	public ArrayList<Link> links = new ArrayList<Link>();
	public Link link;
	public NodeDisplay display;
	public Node(String title, int x, int y, int width,int hight, NodeDisplay display){
		this(title,x,y,width,hight,new Color(50,50,50),Color.lightGray, new Color(80,80,80,10), display);
	}
	public Node(String title, int x, int y, int width,int hight, Color color, Color otherColor, Color thirdColor,  NodeDisplay display){
		this.title = title;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = hight;
		this.color = color;
		this.otherColor = otherColor;
		this.thirdColor = thirdColor;
		contentPane = new JPanel();
		this.layout = new SpringLayout();
		contentPane.setLayout(this.layout);
		scrollPane = new JScrollPane(contentPane);
		JButton removeNode = new JButton("Remove");
		removeNode.setToolTipText("Removes the seleted node");
		this.contentPane.add(removeNode);
		layout.putConstraint(SpringLayout.NORTH, removeNode, 0, SpringLayout.NORTH, this.contentPane);
		layout.putConstraint(SpringLayout.EAST, removeNode, 0, SpringLayout.EAST, this.contentPane);
		layout.putConstraint(SpringLayout.SOUTH, removeNode, 0, SpringLayout.SOUTH, this.contentPane);
		layout.putConstraint(SpringLayout.WEST, removeNode, 0, SpringLayout.WEST, this.contentPane);
		ports.add(new NodePort(width,30, Color.orange, Color.yellow, 1, false, this));
		ports.add(new NodePort(0,30, Color.orange, Color.yellow, 1, true, this));
		ports.add(new NodePort(width,45, new Color(63,209,94), new Color(204, 255, 204), 2, false, this));
		ports.add(new NodePort(0,45, Color.blue, new Color(63,143,209), 3, true, this));
		this.display = display;
	}
	public boolean isInNode(Point point){
		if(point.x >= this.x && point.x < this.x + this.width && point.y >= this.y && point.y < this.y + this.height){
			return true;
		}
		for(NodePort port : ports){
			if(port.inside(point.x-this.x, point.y-this.y-21)){
				return true;
			}
		}
		return false;
	}
	public boolean clicked(int x, int y){
		for(NodePort port : ports){
			if(port.inside(x-this.x, y-this.y-21)){
				if(port.reciveOrSend()){
					if(port.linkcount < 1){
						this.link = port.createNewLink();
						Point point = this.link.getPoint();
						int x2 = point.x + this.x;
						int y2 = point.y + this.y + 21;
						this.link.setPoint(new Point(x2,y2));
						this.link.renderX = this.x + point.x;
						this.link.renderY = this.y + point.y + 21;
					} else {
						for(Node node : this.display.nodes){
							if(node != this){
								Link foundlink = null;
								for(Link link : node.links){
									if(link.getEndPort() == port){
										link.getPort().linkcount --;
										link.getEndPort().linkcount --;
										node.link = link;
										port.node.link = link;
										this.display.listener.setSelectedNode(node);
										foundlink = link;
									}
								}
								if(foundlink != null){
									node.links.remove(foundlink);
								}
							}
						}
					}
				}
				else{
					this.link = port.createNewLink();
					Point point = this.link.getPoint();
					int x2 = point.x + this.x;
					int y2 = point.y + this.y + 21;
					this.link.setPoint(new Point(x2,y2));
					this.link.renderX = this.x + point.x;
					this.link.renderY = this.y + point.y + 21;
				}
			}
		}
		return true;
	}
	public boolean realeased(int x, int y){

		if(this.link != null){
			NodePort port = null;
			Node node = null;
			for(Node uode : this.display.nodes){
				if(uode != this){
					NodePort nodePort = uode.getPortAt(x, y);
					if(port == null && nodePort != null){
						port = nodePort;
						node = uode;
					}
				}
			}

			if(port != null){
				if(this.link.getPort().canConnect(port)){
					this.link.setFinalPort(port);
					link.setPoint(port.x + node.x, port.y + node.y + 21);
					this.links.add(link);
				}
				else{
					this.display.recaculateNodePorts();
				}
			}
			else{
				this.link.setPort(null);
				this.link.setFinalPort(null);
			}
			if(port != null && link != null)
				this.link.getPort().removeLink();
			this.link = null;
		}
		return true;
	}
	public boolean draged(int x, int y){
		if(this.link != null){
			this.link.setPoint(x, y);
			return false;
		}
		return true;
	}
	public NodePort getPortAt(int x, int y){
		for(NodePort port : ports){
			if(port.inside(x-this.x, y-this.y-21)){
				return port;
			}
		}
		return null;
	}
	public void prepaint(Graphics g){
		for(Link link : links){
			link.Draw(g);
		}
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(this.color);
		if(this.isHighlighted){
			g.setColor(this.highliteColor);
			g.fillRoundRect(x - hightliteRadius, y - hightliteRadius, width + (2 * hightliteRadius), height + (2 * hightliteRadius), 20, 20);
		}
		g.setColor(Color.black);
		g.fillRoundRect(x, y, width, height, 20, 20);
		g.setColor(this.color);
		GradientPaint paint = new GradientPaint(x, y, this.color,
				x + this.width, y + this.height, this.thirdColor);
		g2.setPaint(paint);
		g.fillRoundRect(x + 1, y + 1, width - 2, height - 2, 20, 20);
		g.setColor(otherColor);
		g.drawString(this.title, x + 5, y + 15);
		g.drawLine(this.x + 2, this.y + 20, this.x + width - 3, this.y + 20);
		Graphics graphics = g.create();
		graphics.translate(x, y + 21);
		for(NodePort port : ports){
			port.draw(graphics);
		}
		if(this.link != null){
			this.link.Draw(g);
		}
		scrollPane.paintComponents(graphics);
	}

}
