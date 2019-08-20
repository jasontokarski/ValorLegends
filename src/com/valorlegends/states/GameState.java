package com.valorlegends.states;

import java.awt.Graphics;

import com.valorlegends.Game;
import com.valorlegends.display.Display;
import com.valorlegends.entity.Player;
import com.valorlegends.graphics.Assets;

public class GameState extends State {

	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 50, 50, 32, 32);
	}
	
	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		for(int x = 0; x < Display.width; x += Display.tileSize) {
			for(int y = 0; y < Display.height; y += Display.tileSize) {
				g.drawImage(Assets.water, y, x, null);
			}
		}
		
		player.render(g);
	}

}
