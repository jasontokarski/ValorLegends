package com.valorlegends.tiles;

import com.valorlegends.graphics.Assets;

public class WaterTile extends Tile {
	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	public boolean walkable() {
		return false;
	}
}
