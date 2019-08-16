package com.valorlegends;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.valorlegends.display.Display;
import com.valorlegends.graphics.Assets;
import com.valorlegends.util.FpsTimer;

public class Game implements Runnable {
	private static final int numBuffers = 3;
	private Display display;
	public int width, height;
	public String title;
	private Thread thread;
	public FpsTimer fpsTimer;
	int x = 0;
	
	//Variable to check if our game is running
	boolean running = false;
	
	//Uses buffers to draw graphics to your screen
	//Can be used to prevent flickering, think of it as a hidden screen
	//that gets drawn on before displaying to the screen
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		Assets.loadAssets();
	}
	
	//Check if our game is running, if not start it
	//by creating a new thread
	public synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		fpsTimer = new FpsTimer(60);
		//Game loop will continually update variables and display images
		while(running) {
			fpsTimer.update();
			//If delta is greater than one, then we can tick and render to match
			//60 frames per second
			if(fpsTimer.check()) {
				tick();
				render();
			}
		}
		stop();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			//If buffer strategy doesn't exist, use three buffers
			display.getCanvas().createBufferStrategy(numBuffers);
			return;
		}
		
		//A paint brush used to draw lines, shapes, images to the screen
		//Create our graphics object for drawing
		g = bs.getDrawGraphics();
		
		//Clear our entire screen
		g.clearRect(0, 0, width, height);
		
		//Start Drawing
		
		//Display our player sprite
		g.drawImage(Assets.player, x, 25, null);
		
		//End Drawing
		
		//Display our graphics buffer to the screen
		bs.show();
		//Clean up our graphics object
		g.dispose();
	}
	
	private void tick() {
		x += 1;
	}

}
