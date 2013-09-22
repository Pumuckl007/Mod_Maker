package modmaker;

import java.io.File;

import modmaker.gui.Gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Start {
	public static void main(String[] args){
		try {
			int hight = 800;
			if(args.length > 0){
				hight = new Integer(args[0]);
			}
			Display.setDisplayMode(new DisplayMode((hight/2)*3, hight));
			Display.setTitle("Mod Maker");
			Display.create();
			GL11.glOrtho(0, 1200, 800, 0, -1, 1);
			File f = new File(System.getProperty("user.dir"));
			System.out.println(System.getProperty("user.dir"));
			System.out.println(f.getAbsolutePath());
			Gui gui = new Gui();
			while(!Display.isCloseRequested()){
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
				gui.render();
				Display.sync(60);
				Display.update();
			}
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Display.destroy();
	}
}
