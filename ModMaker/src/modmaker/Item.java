package modmaker;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.lwjgl.BufferUtils;
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
	private ImageIcon overwriteImage;
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
	public void setImage(ImageIcon icon){
		this.overwriteImage = icon;
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
			Canvas c = new Canvas();
			c.setSize(800, 800);
			c.setVisible(true);
			try {
				Display.setParent(c);
				Display.create();
				Display.swapBuffers();
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


				Texture texture;
				if(this.overwriteImage != null){
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					BufferedImage bi = new BufferedImage(
							this.overwriteImage.getIconWidth(),
							this.overwriteImage.getIconHeight(),
							BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					this.overwriteImage.paintIcon(null, g, 0,0);
					g.dispose();
					ImageIO.write(bi,"png", os); 
					InputStream input = new ByteArrayInputStream(os.toByteArray());
					texture = TextureLoader.getTexture("PNG", input);
				}
				else
					texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(this.image.getAbsolutePath()), GL11.GL_LINEAR);
				Color.white.bind();
				GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
				texture.bind();
				GL11.glTranslated(-1, -0.5, -4);
				GL11.glRotated(35, 1, 0, 0);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
			GL11.glReadBuffer(GL11.GL_FRONT);
			int width = Display.getDisplayMode().getWidth();
			int height= Display.getDisplayMode().getHeight();
			int bpp = 4;
			ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
			GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer );
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			for(int x = 0; x < width; x++)
				for(int y = 0; y < height; y++)
				{
					int i = (x + (width * y)) * bpp;
					int r = buffer.get(i) & 0xFF;
					int g = buffer.get(i + 1) & 0xFF;
					int b = buffer.get(i + 2) & 0xFF;
					int a = 0xFF;
					if(r == 0 && g == 0 && b == 0){
						a = 0x00;
					}
					image.setRGB(x, height - (y + 1), (a << 24) | (r << 16) | (g << 8) | b);

				}
			for(int x = 0; x < width; x ++)
				for(int y = 0; y < height; y++){
					int rgb = image.getRGB(x, y);
					int a = rgb >> 24;
					int r = (rgb << 8) >> 24;
					int g = (rgb << 16) >> 16;
					int b = (rgb << 24) >>8;
					rgb = ((a << 24) | (r+g+b)/3);
					image.setRGB(x, y, rgb);
				}
			Display.destroy();
			return new ImageIcon(image);
		}
		if(this.overwriteImage != null){
			return this.overwriteImage;
		}
		return new ImageIcon(this.image.getAbsolutePath());
	}
}
