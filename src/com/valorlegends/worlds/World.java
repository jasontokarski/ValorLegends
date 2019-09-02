package com.valorlegends.worlds;

import java.awt.Graphics;

import com.valorlegends.tiles.Tile;
import com.valorlegends.util.FileLoader;
import com.valorlegends.util.Handler;

public class World {
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	private Handler handler;
	
	private int[][] worldTiles;
	
	public World(Handler handler, String worldPath) {
		this.handler = handler;
		loadWorld(worldPath);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		//Height and Width is twenty 32x32 tiles
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y* Tile.TILE_HEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		
		if(x < 0 || y < 0 || x >= 20 || y >= 20) {
			return Tile.waterTile;
		}
		
		Tile tile = Tile.tiles[worldTiles[x][y]];
		
		if(tile == null) {
			return Tile.waterTile;
		}
		return tile;
	}
	
	private void loadWorld(String worldPath) {
		String file = FileLoader.loadFileAsString(worldPath);
		String[] tokens = file.split("\\s+");
		
		//First four parameters of our .lvl file
		width = FileLoader.parseInt(tokens[0]);
		height = FileLoader.parseInt(tokens[1]);
		spawnX = FileLoader.parseInt(tokens[2]);
		spawnY = FileLoader.parseInt(tokens[3]);
		
		//An array to hold all the tiles in our map
		worldTiles = new int[width][height];
		
		int tileIndex = 4;
		
		//Build our tile array
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				worldTiles[x][y] = FileLoader.parseInt(tokens[tileIndex++]);
			}
		}
		
		tileIndex = 0;
	}
}
