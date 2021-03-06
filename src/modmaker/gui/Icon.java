package modmaker.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.PNGDecoder;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Icon {
	private FileInputStream file;
	private Texture texture;
	private ByteBuffer bytebuffer;
	public Icon(String texture){
		File file = new File(texture);
		if(file.exists()){
			try {
				this.file = new FileInputStream(texture);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			this.bytebuffer = this.loadTextureToByteBuffer();
			try {
				this.texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(texture), GL11.GL_NEAREST);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println(texture);
		}
	}
	private ByteBuffer loadTextureToByteBuffer(){
		ByteBuffer buf = null;
		try {
			InputStream in;
			// Open the PNG file as an InputStream
			in = this.file;
			// Link the PNG decoder to this stream
			PNGDecoder decoder = new PNGDecoder(in);


			// Decode the PNG file in a ByteBuffer
			buf = ByteBuffer.allocateDirect(
					4 * decoder.getWidth() * decoder.getHeight());
			decoder.decode(buf, decoder.getWidth() * 4, PNGDecoder.RGBA);
			buf.flip();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return buf;
	}
	public Texture getTexture() {
		return texture;
	}
	public ByteBuffer getBytebuffer() {
		return bytebuffer;
	}
	public void bind(){
		texture.bind();
	}
}
