package com.valorlegends.entity;

import java.awt.Graphics;

import com.valorlegends.Game;
import com.valorlegends.graphics.Assets;

public class Player extends LivingEntity {
	private Game game;
	
	public Player(Game game, float x, float y, int width, int height) {
		super(x, y, width, height);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}

	private void getInput() {
		xSpeed = 0;
		ySpeed = 0;
		
		if(game.getKeyManager().up) {
			ySpeed = -speed;
		}
		if(game.getKeyManager().down) {
			ySpeed = speed;
		}
		if(game.getKeyManager().left) {
			xSpeed = -speed;
		}
		if(game.getKeyManager().right) {
			xSpeed = speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
	}
}
