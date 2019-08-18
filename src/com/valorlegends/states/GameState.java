package com.valorlegends.states;

import java.awt.Graphics;

import com.valorlegends.display.Display;
import com.valorlegends.graphics.Assets;

public class GameState extends State {

	public GameState() {
		
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		for(int x = 0; x < Display.width; x += Display.tileSize) {
			for(int y = 0; y < Display.height; y += Display.tileSize) {
				g.drawImage(Assets.water, y, x, null);
			}
		}
		
		g.drawImage(Assets.player, 50, 50, null);
	}

}
