package modmaker.gui;

import java.awt.image.BufferedImage;

public class ImageShaders {
	public static BufferedImage grayScale(BufferedImage image){
		int width = image.getWidth();
		int height = image.getHeight();
		for(int x = 0; x < width; x ++)
			for(int y = 0; y < height; y++){
				int rgb = image.getRGB(x, y);
				int a = rgb >> 24;
				int or = 0xFF;
				int r = ((rgb << 8) >> 36)&or;
				int g = ((rgb << 16) >> 24)&or;
				int b = ((rgb << 24) >>16)&or;
				int average =  ( r + g + b ) / 3;
				rgb = ((a << 24) | (average << 16) | (average << 8) | average);
				image.setRGB(x, y, rgb);
			}
		return image;
	}
	public static BufferedImage invert(BufferedImage image){
		int width = image.getWidth();
		int height = image.getHeight();
		for(int x = 0; x < width; x ++)
			for(int y = 0; y < height; y++){
				int rgb = image.getRGB(x, y);
				int a = rgb >> 24;
				int or = 0xFF;
				int r = ((rgb << 8) >> 36)&or;
				int g = ((rgb << 16) >> 24)&or;
				int b = ((rgb << 24) >>16)&or;
				rgb = ((a << 24) | ((~r & 0xff) << 16) | ((~g & 0xff) << 8) | (~b & 0xff));
				image.setRGB(x, y, rgb);
			}
		return image;
	}
}
