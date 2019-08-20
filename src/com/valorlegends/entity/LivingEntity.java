package com.valorlegends.entity;

public abstract class LivingEntity extends Entity {
	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 5.0F;
	public static final int DEFAULT_LIVING_ENT_WIDTH = 32;
	public static final int DEFAULT_LIVING_ENT_HEIGHT = 32;
	
	protected int health;
	protected float speed;
	protected float xSpeed;
	protected float ySpeed;
	
	public LivingEntity(float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xSpeed = 0;
		ySpeed = 0;
	}
	public void move() {
		x += xSpeed;
		y += ySpeed;
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

	public float getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}

	public float getySpeed() {
		return ySpeed;
	}

	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
}
