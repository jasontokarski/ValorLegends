package com.valorlegends.entity;

import java.awt.Graphics;

import com.valorlegends.Game;
import com.valorlegends.graphics.Assets;

public class Player extends LivingEntity {
	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		//y axis starts at the top left and moves down
		if(game.getKeyManager().up) {
			y -= 3;
		}
		if(game.getKeyManager().down) {
			y += 3;
		}
		if(game.getKeyManager().left) {
			x -= 3;
		}
		if(game.getKeyManager().right) {
			x += 3;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}
}
