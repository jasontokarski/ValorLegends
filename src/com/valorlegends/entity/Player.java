package com.valorlegends.entity;

import java.awt.Graphics;

import com.valorlegends.graphics.Assets;

public class Player extends LivingEntity {

	public Player(float x, float y) {
		super(x, y);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, null);
	}
}
