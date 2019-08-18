package com.valorlegends.entity;

import java.awt.Graphics;

public abstract class Entity {
	protected float x, y;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	//This is where any entity will be drawn to the screen
	public abstract void render(Graphics g);
}
