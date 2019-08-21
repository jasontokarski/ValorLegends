package com.valorlegends.worlds;

import java.awt.Graphics;

import com.valorlegends.tiles.Tile;
import com.valorlegends.util.FileLoader;

public class World {
	private int width;
	private int height;
	private int spawnX;
	private int spawnY;
	
	private int[][] worldTiles;
	
	public World(String worldPath) {
		loadWorld(worldPath);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILE_WIDTH, y* Tile.TILE_HEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile tile = Tile.tiles[worldTiles[x][y]];
		if(tile == null) {
			return Tile.waterTile;
		}
		return tile;
	}
	
	private void loadWorld(String worldPath) {
		String file = FileLoader.loadFileAsString(worldPath);
		String[] tokens = file.split("\\s+");
		width = FileLoader.parseInt(tokens[0]);
		height = FileLoader.parseInt(tokens[1]);
		spawnX = FileLoader.parseInt(tokens[2]);
		spawnY = FileLoader.parseInt(tokens[3]);
		
		worldTiles = new int[width][height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				worldTiles[x][y] = FileLoader.parseInt(tokens[(x + y) + 4]);
			}
		}
		
	}
}
