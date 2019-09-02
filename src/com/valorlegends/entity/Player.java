package com.valorlegends.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.valorlegends.graphics.Assets;
import com.valorlegends.util.Handler;

public class Player extends LivingEntity {
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, LivingEntity.DEFAULT_LIVING_ENT_WIDTH, LivingEntity.DEFAULT_LIVING_ENT_HEIGHT);
		//The collision box should be 0 pixels from the edge in both the x and y directions.
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 29;
		bounds.height = 31;
	}

	@Override
	public void tick() {
		getInput();
		move();
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
		//g.setColor(Color.RED);
		//g.fillRect((int)x + bounds.x, (int) y + bounds.y, bounds.width, bounds.height);
	}
}
