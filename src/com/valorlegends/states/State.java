package com.valorlegends.states;

import java.awt.Graphics;

import com.valorlegends.util.Handler;

public abstract class State {
	
	//Holds the current state we want to render
	private static State currentState = null;
	
	public static State getState() {
		return currentState;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
