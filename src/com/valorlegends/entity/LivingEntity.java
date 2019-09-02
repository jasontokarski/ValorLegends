package com.valorlegends.entity;

import com.valorlegends.tiles.Tile;
import com.valorlegends.util.Handler;

public abstract class LivingEntity extends Entity {
	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 5.0F;
	public static final int DEFAULT_LIVING_ENT_WIDTH = 32;
	public static final int DEFAULT_LIVING_ENT_HEIGHT = 32;
	
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	public LivingEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		//Collision detection
		if(xMove > 0) { //Move right
			int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			
			//If there is no collision tile, we are free to move
			if(!collisionWithTile(tx, (int) (y + bounds.y)/ Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				//tx * Tile.TILE_WIDTH is setting to pixel coordinates
				//This will compensate for the small distance between our bounding box and a colliding tile
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
			
		} else if(xMove < 0) { //Move left
			int tx = (int)(x + xMove + bounds.x) / Tile.TILE_WIDTH;
			//If there is no collision tile, we are free to move
			if(!collisionWithTile(tx, (int) (y + bounds.y)/ Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
		
	}
	
	public void moveY() {
		//Collision detection
		if(yMove < 0) { //Moving up
			int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
		} else if(yMove > 0) { //Moving down
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).notWalkable();
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
}
