package com.valorlegends.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	private int speed, index, timer;
	private long lastTime;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames) {
		//Speed is how many milliseconds in between switching a frame
		this.speed = speed;
		this.frames = frames;
		//Index is our current position of the sprite
		index = 0;
		//Used to get the time in between ticks
		timer = 0;
		//Get the milliseconds that have passed this the start of our program
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		//Get the time in milliseconds since this tick and the previous tick have been called
		timer += System.currentTimeMillis() - lastTime;
		lastTime += System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
}
