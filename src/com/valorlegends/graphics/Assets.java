package com.valorlegends.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int playerWidth = 32, playerHeight = 50;
	
	public static BufferedImage playerSprites;
	public static BufferedImage player;
	
	public static void loadAssets() {
		playerSprites = ImageLoader.loadImage("/textures/vx_chara03_f.png");
		SpriteSheet sheet = new SpriteSheet(playerSprites);
		player = sheet.crop(0, 0, playerWidth, playerHeight);
	}
}
