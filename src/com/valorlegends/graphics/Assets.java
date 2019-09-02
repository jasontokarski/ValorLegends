package com.valorlegends.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int playerWidth = 32, playerHeight = 50;
	private static final int terrainWidth = 32, terrainHeight = 32;
	
	public static BufferedImage terrainTileset;
	public static BufferedImage water;
	public static BufferedImage grass;
	public static BufferedImage stone;
	public static BufferedImage sand;
	public static BufferedImage playerSprites;
	public static BufferedImage player;
	
	public static void loadAssets() {
		playerSprites = ImageLoader.loadImage("/textures/vx_chara03_f.png");
		terrainTileset = ImageLoader.loadImage("/textures/TerrainTileset.png");
		SpriteSheet playerSheet = new SpriteSheet(playerSprites);
		SpriteSheet terrainSheet = new SpriteSheet(terrainTileset);
		
		//Extract our tile from our sprite sheet as a BufferedImage
		player = playerSheet.crop(0, 0, playerWidth, playerHeight);
		water = terrainSheet.crop(0, 0,terrainWidth , terrainHeight);
		grass = terrainSheet.crop(32, 0, terrainWidth, terrainHeight);
		stone = terrainSheet.crop(64, 0, terrainWidth, terrainHeight);
		sand = terrainSheet.crop(96, 0, terrainWidth, terrainHeight);
	}
}
