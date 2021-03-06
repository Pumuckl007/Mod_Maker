package modmaker;
import java.awt.Canvas;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class DisplayTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8775371561879791929L;

	public static void main(String[] args) throws LWJGLException, InterruptedException, IOException {
		System.out.println("LWJGL Version: "+Sys.getVersion());
		
		DisplayTest test = new DisplayTest();
		test.setVisible(true);
		Display.setParent(test.c);
		Display.create();		
		
			Display.swapBuffers();
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			GL11.glClearColor(0, 0, 0, 1);
			GL11.glPushAttrib(GL11.GL_TRANSFORM_BIT);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GLU.gluPerspective(45, 1, 0.005F, 100);
			GL11.glPopAttrib();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			Color.white.bind();
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(System.getProperty("user.home") + "/.modmaker/blocks/beacon.png"), GL11.GL_LINEAR).bind();

			GL11.glTranslated(-1, -0.5, -4);
			GL11.glRotated((System.currentTimeMillis()/10) % 360, 1, 0, 0);
			GL11.glRotated(-45, 0, 1, 0);
			GL11.glScaled(1.5, 1.5, 1.5);

			GL11.glBegin(GL11.GL_QUADS);{
				GL11.glTexCoord2d(1, 1);
				GL11.glVertex3d(0, 1, 0);
				GL11.glTexCoord2d(1, 0);
				GL11.glVertex3d(1, 1, 0);
				GL11.glTexCoord2d(0, 0);
				GL11.glVertex3d(1, 1, -1);
				GL11.glTexCoord2d(0, 1);
				GL11.glVertex3d(0, 1, -1);
				GL11.glEnd();
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glTexCoord2d(1, 1);
				GL11.glVertex3d(1, 0, 0);
				GL11.glTexCoord2d(1, 0);
				GL11.glVertex3d(1, 1, 0);
				GL11.glTexCoord2d(0, 0);
				GL11.glVertex3d(1, 1, -1);
				GL11.glTexCoord2d(0, 1);
				GL11.glVertex3d(1, 0, -1);
				GL11.glEnd();
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glTexCoord2d(1, 1);
				GL11.glVertex3d(0, 0,0);
				GL11.glTexCoord2d(1, 0);
				GL11.glVertex3d(0, 1,0);
				GL11.glTexCoord2d(0, 0);
				GL11.glVertex3d(1, 1,0);
				GL11.glTexCoord2d(0, 1);
				GL11.glVertex3d(1, 0,0);
			} GL11.glEnd();

			Display.update();
			GL11.glPopMatrix();
			Thread.sleep(100);
	}
	
	Canvas c;
	
	public DisplayTest() {
		c = new Canvas();
		c.setBackground(java.awt.Color.blue);
		c.setSize(new Dimension(800,800));
		add(c);
		this.pack();
	}
}