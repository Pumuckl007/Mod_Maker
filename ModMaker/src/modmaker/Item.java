package modmaker;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Item {
	public ArrayList<Recipy> recipies = new ArrayList<Recipy>();
	private String name;
	private File image;
	private Integer id = 12345;
	private Integer metadat = 0;
	private ItemType type;
	public Item(String name, ItemType type){
		this.name = name;
		this.image = new File("resources/textures/Tea-Bag.JPEG");
		this.type = type;
	}
	public ItemType getType(){
		return this.type;
	}
	public String[] getItemForTable(){
		return new String[]{this.type.toString(), name, this.id.toString(), "Edit", "Delete"};
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Integer getMetadat() {
		return metadat;
	}
	public void setMetadat(int metadat) {
		this.metadat = metadat;
	}
	public void setImage(String file){
		this.image = new File(file);
	}
	public void setImageFile(File file){
		this.image = file;
	}
	public URL getImage(){
		try {
			return image.toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ImageIcon getImageIcon(){
		if(this.type == ItemType.Block){
			try {
				Display.setDisplayMode(new DisplayMode(800,800));
				Display.setLocation(-200, -200);
				Display.create();
				GLU.gluPerspective(45, 1, 0.001F, 100);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
				GL11.glClearColor(255, 255, 255, 255);
				Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(this.image.getAbsolutePath()));
				Color.white.bind();
				texture.bind();
				GL11.glTranslated(0, 0, -1);
				GL11.glBegin(GL11.GL_QUADS);{
					GL11.glTexCoord2d(0, 0);
					GL11.glVertex2d(0, 0);
					GL11.glTexCoord2d(0, 1);
					GL11.glVertex2d(0, 1);
					GL11.glTexCoord2d(1, 1);
					GL11.glVertex2d(1, 1);
					GL11.glTexCoord2d(0, 1);
					GL11.glVertex2d(0, 1);
				} GL11.glEnd();
				Display.update();
			} catch (Exception e) {
				e.printStackTrace();
			}
			GL11.glReadBuffer(GL11.GL_FRONT);
			int width = Display.getDisplayMode().getWidth();
			int height= Display.getDisplayMode().getHeight();
			int bpp = 4;
			ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
			GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer );
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			for(int x = 0; x < width; x++)
				for(int y = 0; y < height; y++)
				{
					int i = (x + (width * y)) * bpp;
					int r = buffer.get(i) & 0xFF;
					int g = buffer.get(i + 1) & 0xFF;
					int b = buffer.get(i + 2) & 0xFF;
					image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16) | (g << 8) | b);
				}
			Image imageIcon = new ImageIcon(this.image.getAbsolutePath()).getImage();
			Display.destroy();
			return new ImageIcon(image);
		}
		return new ImageIcon(this.image.getAbsolutePath());
	}
}
