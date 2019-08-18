package com.valorlegends.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int playerWidth = 32, playerHeight = 50;
	private static final int terrainWidth = 32, terrainHeight = 32;
	
	public static BufferedImage terrainTileset;
	public static BufferedImage water;
	public static BufferedImage playerSprites;
	public static BufferedImage player;
	
	public static void loadAssets() {
		playerSprites = ImageLoader.loadImage("/textures/vx_chara03_f.png");
		terrainTileset = ImageLoader.loadImage("/textures/TerrainTileset.png");
		SpriteSheet playerSheet = new SpriteSheet(playerSprites);
		SpriteSheet terrainSheet = new SpriteSheet(terrainTileset);
		player = playerSheet.crop(0, 0, playerWidth, playerHeight);
		water = terrainSheet.crop(0, 0,terrainWidth , terrainHeight);
	}
}
