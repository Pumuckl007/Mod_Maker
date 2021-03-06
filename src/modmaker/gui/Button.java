package modmaker.gui;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Button {
	private int x,y,hight,width;
	private Icon[] icon;
	private ButtonAction call;
	private int state = 0;
	private boolean pressed;
	private String id;
	public Button(int x, int y,int lenght, int width, Icon off, Icon offActive, Icon on, Icon onActive, ButtonAction call, String id){
		this.x = x;
		this.y = y;
		icon = new Icon[]{off,offActive,on,onActive};
		this.id = id;
	}
	public void update(int x,int y){
		if(!Mouse.isButtonDown(0))
			pressed = false;
		if(x- this.x > 0 && x- this.x < width){
			if(y - this.y > 0 && y- this.y < width){
				if(state >= 1){
					state = 1;
				}
				else{
					state = 3;
				}
				if(Mouse.isButtonDown(0) && !pressed){
					pressed = true;
					call.activate(this.id);
					if(state >= 1){
						state = 3;
					}
					else{
						state = 1;
					}
				}
			}
			else{
				if(state >= 1){
					state = 0;
				}
				else{
					state = 2;
				}
			}
		}
		else{
			if(state >= 1){
				state = 0;
			}
			else{
				state = 2;
			}
		}
	}
	public void render(){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, 0);
		this.icon[state].bind();
		GL11.glBegin(GL11.GL_QUADS);{
			GL11.glTexCoord2d(0, 0);
			GL11.glVertex2d(0, 0);
			GL11.glTexCoord2d(0, 1);
			GL11.glVertex2d(0, this.width);
			GL11.glTexCoord2d(1, 1);
			GL11.glVertex2d(this.hight, this.width);
			GL11.glTexCoord2d(1, 0);
			GL11.glVertex2d(this.hight, 0);
		}GL11.glEnd();
		GL11.glPopMatrix();
	}
}
