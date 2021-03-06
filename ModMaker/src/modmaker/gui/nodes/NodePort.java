package modmaker.gui.nodes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class NodePort {
	public static final int radius = 6;
	protected Color color1;
	protected Color color2;
	protected int id,x,y;
	protected boolean recive;
	protected Link link;
	protected Node node;
	public int linkcount;
	public NodePort(int x, int y, Color color1, Color color2, int id, boolean recive, Node node){
		this.x = x;
		this.y = y;
		this.color1 = color1;
		this.color2 = color2;
		this.id = id;
		this.recive = recive;
		this.node = node;
	}
	public Point getCoordinates(){
		return new Point(x,y);
	}
	public boolean reciveOrSend(){
		return this.recive;
	}
	public boolean inside(int x, int y){
		if(Math.pow(x - this.x,2) + Math.pow(y - this.y,2) < Math.pow(radius,2)){
			return true;
		}
		return false;
	}
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.black);
		g.fillOval(x-radius, y-radius, radius * 2, radius * 2);
		int distance = (int) Math.sqrt(Math.pow(0-(radius-1), 2) + Math.pow(0-(radius-1), 2))/2;
		g2.setPaint(new GradientPaint(x - distance, y - distance, color1, x, y, color2, true));
		g.fillOval(x-(radius-1), y-(radius-1), (radius * 2)-1, (radius * 2)-1);
	}
	public int getId(){
		return this.id;
	}
	public boolean canConnect(NodePort port){
		return (this.id == port.getId() && port.reciveOrSend() != this.reciveOrSend() && this.canHaveNewConnection() && port.canHaveNewConnection());
	}
	private boolean canHaveNewConnection(){
		if(this.reciveOrSend()){
			return this.linkcount < 1;
		}
		else{
			return true;
		}
	}
	public void removeLink(){
		this.link = null;
	}
	public Link createNewLink(){
		return this.link = new Link(this);
	}
}
