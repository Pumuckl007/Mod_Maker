package modmaker;

import java.io.IOException;

import org.lwjgl.LWJGLException;

import modmaker.gui.Gui;



public class Start {
	public static Gui gui;
	public static Main main;
	public static void main(String[] args) throws LWJGLException, InterruptedException, IOException{
		main = new Main();
		gui = new Gui();
	}
}
