package modmaker.gui;


import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

public class Quad {
	private Icon icon;
	private int x,y,hight,width;
	public Quad(Icon icon, int x, int y, int width, int hight){
		this.icon = icon;
		this.x = x;
		this.y = y;
		this.hight = hight;
		this.width = width;
	}
	public void render(){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, 0);
		Color.white.bind();
		if(icon != null)
			this.icon.bind();
		else
			Color.white.bind();
		GL11.glBegin(GL11.GL_QUADS);{
			GL11.glTexCoord2d(0, 0);
			GL11.glVertex2d(0, 0);
			GL11.glTexCoord2d(0.99, 0);
			GL11.glVertex2d(this.width, 0);
			GL11.glTexCoord2d(0.99, 0.8);
			GL11.glVertex2d(this.width, this.hight);
			GL11.glTexCoord2d(0, 0.8);
			GL11.glVertex2d(0, this.hight);

		}GL11.glEnd();
		GL11.glPopMatrix();
	}
}
