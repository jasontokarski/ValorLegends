package com.valorlegends.entity;

import java.awt.Graphics;

public abstract class LivingEntity extends Entity {
	protected int health;
	
	public LivingEntity(float x, float y) {
		super(x, y);
		health = 100;
	}
}
