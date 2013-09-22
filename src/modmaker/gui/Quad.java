package modmaker.gui;

import org.lwjgl.opengl.GL11;

public class Quad {
	private Icon icon;
	private int x,y,hight,width;
	public Quad(Icon icon, int x, int y){
		this.icon = icon;
		this.x = x;
		this.y = y;
		this.hight = icon.getTexture().getImageHeight();
		this.width = icon.getTexture().getImageWidth();
	}
	public void render(){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, 0);
		this.icon.bind();
		GL11.glBegin(GL11.GL_QUADS);{
			GL11.glTexCoord2d(0, 0);
			GL11.glVertex2d(0, 0);
			GL11.glTexCoord2d(1, 0);
			GL11.glVertex2d(this.width, 0);
			GL11.glTexCoord2d(1, 1);
			GL11.glVertex2d(this.width, this.hight);
			GL11.glTexCoord2d(0, 1);
			GL11.glVertex2d(0, this.hight);
			
		}GL11.glEnd();
		GL11.glPopMatrix();
	}
}
