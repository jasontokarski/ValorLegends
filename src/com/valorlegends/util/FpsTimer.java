package com.valorlegends.util;

/*****************************************
 * 
 * This class is used to ensure that no matter how fast the clockspeed is
 * on a particular computer, everyone will experience in the game in 60
 * frames per second
 *****************************************/
public class FpsTimer {
	private static final int nanoPerSecond = 1000000000;
	private double timePerTick;
	private double delta;
	private long startTime;
	private long endTime;
	
	public FpsTimer(int fps) {
		//Maximum time that may pass per tick
		timePerTick = nanoPerSecond / fps;
		delta = 0;
		endTime = System.nanoTime();
	}

	//Update the amount of time that has passed
	public void update() {
		startTime = System.nanoTime();
		//Delta is the time since the last tick divided by
		//the maximum amount of time that may pass per tick
		delta += (startTime - endTime) / timePerTick;
		endTime = startTime;
	}
	
	//Check if a single tick has occurred
	public boolean check() {
		//If delta is greater than one, then one tick has passed
		if(delta >= 1) {
			delta--;
			return true;
		} else {
			return false;
		}
	}
}
