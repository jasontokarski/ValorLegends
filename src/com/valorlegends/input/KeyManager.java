package com.valorlegends.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	//Check which arrow key is being pressed
	public boolean up, down, left, right;
	
	//Tick is called many times per second
	public void tick() {
		//If w,a,s,d is pressed save that keyevent as the index of the keys and up will be equal to true
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	public KeyManager() {
		//256 Ascii values can be entered, true for pressed false for not pressed
		keys = new boolean[256];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
