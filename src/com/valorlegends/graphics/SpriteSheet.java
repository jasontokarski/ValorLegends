package com.valorlegends.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	//Crop a sub-image from our spritesheet
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
