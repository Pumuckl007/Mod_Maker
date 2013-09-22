package modmaker.gui;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Gui {
	private ArrayList<Button> buttons = new ArrayList<Button>();
	private Quad[] assets = new Quad[]{new Quad(new Icon("Bar.png"), 0, 0)};
	public void render(){
		assets[0].render();
		for(Button button : this.buttons){
			button.render();
		}
	}
	public void update(){
		int x = Mouse.getX()/(Display.getWidth()/1200);
		int y = Mouse.getY()/(Display.getHeight()/800);
		for(Button button : this.buttons){
			button.update(x,y);
		}
	}
}
