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
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	public static void loadAssets() {
		playerSprites = ImageLoader.loadImage("/textures/vx_chara03_f.png");
		terrainTileset = ImageLoader.loadImage("/textures/TerrainTileset.png");
		SpriteSheet playerSheet = new SpriteSheet(playerSprites);
		SpriteSheet terrainSheet = new SpriteSheet(terrainTileset);
		
		player_up = new BufferedImage[3];
		player_down = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		
		player_down[0] = playerSheet.crop(0, 0, playerWidth, playerHeight);
		player_down[1] = playerSheet.crop(32, 0, playerWidth, playerHeight);
		player_down[2] = playerSheet.crop(64, 0, playerWidth, playerHeight);
		
		player_left[0] = playerSheet.crop(0, 48, playerWidth, playerHeight);
		player_left[1] = playerSheet.crop(32, 48, playerWidth, playerHeight);
		player_left[2] = playerSheet.crop(64, 48, playerWidth, playerHeight);
		
		player_right[0] = playerSheet.crop(0, 96, playerWidth, playerHeight);
		player_right[1] = playerSheet.crop(32, 96, playerWidth, playerHeight);
		player_right[2] = playerSheet.crop(64, 96, playerWidth, playerHeight);
		
		player_up[0] = playerSheet.crop(0, 144, playerWidth, playerHeight);
		player_up[1] = playerSheet.crop(32, 144, playerWidth, playerHeight);
		player_up[2] = playerSheet.crop(64, 144, playerWidth, playerHeight);
		
		//Extract our tile from our sprite sheet as a BufferedImage
		water = terrainSheet.crop(0, 0,terrainWidth , terrainHeight);
		grass = terrainSheet.crop(32, 0, terrainWidth, terrainHeight);
		stone = terrainSheet.crop(64, 0, terrainWidth, terrainHeight);
		sand = terrainSheet.crop(96, 0, terrainWidth, terrainHeight);
	}
}
