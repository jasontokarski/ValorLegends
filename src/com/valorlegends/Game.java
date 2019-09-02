package com.valorlegends;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.valorlegends.display.Display;
import com.valorlegends.graphics.Assets;
import com.valorlegends.input.KeyManager;
import com.valorlegends.states.GameState;
import com.valorlegends.states.State;
import com.valorlegends.util.FpsTimer;
import com.valorlegends.util.Handler;

public class Game implements Runnable {
	private static final int numBuffers = 3;
	private Display display;
	public int width, height;
	public String title;
	private Thread thread;
	public FpsTimer fpsTimer;
	
	//Input
	private KeyManager keyManager;
	
	//Variable to check if our game is running
	boolean running = false;
	
	//Uses buffers to draw graphics to your screen
	//Can be used to prevent flickering, think of it as a hidden screen
	//that gets drawn on before displaying to the screen
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		keyManager = new KeyManager();
		//Get the frame of our frame and have an eventlistener listen for keys
		display.getFrame().addKeyListener(keyManager);
		Assets.loadAssets();
		handler = new Handler(this);
		gameState = new GameState(handler);
		State.setState(gameState);
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
	
	//Allow other classes to access our keymanager
	public KeyManager getKeyManager() {
		return keyManager;
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
		
		//End Drawing
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//Display our graphics buffer to the screen
		bs.show();
		//Clean up our graphics object
		g.dispose();
	}
	
	private void tick() {
		//Keymanager must be ticked to receive input at any time
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}

}
