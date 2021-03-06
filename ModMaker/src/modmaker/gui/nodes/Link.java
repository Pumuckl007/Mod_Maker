package modmaker.gui.nodes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Link {
	private NodePort port,endport;
	private int x = 0,y = 0;
	public int renderX,renderY;
	private boolean active = true;
	public Link(NodePort port){
		this.port = port;
		x = port.x;
		y = port.y;
	}
	public NodePort getPort(){
		return this.port;
	}
	public void setPoint(Point point){
		this.setPoint(point.x, point.y);
	}
	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point getPoint(){
		return new Point(x,y);
	}
	public void setFinalPort(NodePort port){
		this.endport = port;
		if(port != null && this.port != null){
			if(!port.reciveOrSend()){
				this.port.node.links.remove(this);
				port.node.links.add(this);
				port.node.display.repaint();
			}
			this.port.linkcount ++;
			this.endport.linkcount ++;
			this.active = true;
		}
		else{
			this.active = false;
		}
	}
	public NodePort getEndPort(){
		return this.endport;
	}
	public void setPort(NodePort port){
		this.port = port;
		this.active = port != null;
	}
	public void update(NodePort port){
		if(port == this.port){
			this.renderX = port.x + port.node.x;
			this.renderY = port.y + port.node.y + 21;
		}
		if(port == this.endport){
			this.x = port.x + port.node.x;
			this.y = port.y + port.node.y + 21;
		}
	}
	public boolean active(){
		return this.active;
	}
	public void Draw(Graphics g){
		if(this.active){
			g.setColor(Color.black);
			g.drawLine(renderX, renderY, renderX - (renderX/2) + (x/2), renderY);
			g.drawLine(renderX - (renderX/2) + (x/2), renderY, renderX - (renderX/2) + (x/2), y);
			g.drawLine(renderX - (renderX/2) + (x/2), y, x, y);
		}
	}
}
