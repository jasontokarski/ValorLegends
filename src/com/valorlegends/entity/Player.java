package com.valorlegends.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.valorlegends.graphics.Animation;
import com.valorlegends.graphics.Assets;
import com.valorlegends.util.Handler;

public class Player extends LivingEntity {
	
	//Animations
	private Animation animationDown;
	private Animation animationUp;
	private Animation animationLeft;
	private Animation animationRight;
	private Animation currentAnimation;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, LivingEntity.DEFAULT_LIVING_ENT_WIDTH, LivingEntity.DEFAULT_LIVING_ENT_HEIGHT);
		//The collision box should be 0 pixels from the edge in both the x and y directions.
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 24;
		bounds.height = 30;
		
		//Animate every 500 milliseconds
		animationDown = new Animation(700, Assets.player_down);
		animationUp = new Animation(700, Assets.player_up);
		animationLeft = new Animation(700, Assets.player_left);
		animationRight = new Animation(700, Assets.player_right);
		currentAnimation = new Animation(700, Assets.player_down);
	}

	@Override
	public void tick() {
		//Update animation tick variable
		//currentAnimation.tick();
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
		
		if(xMove > 0 || xMove < 0 || yMove > 0 || yMove < 0) {
			currentAnimation.tick();
		}
	}
	
	@Override
	public void render(Graphics g) {
		//Image position is negative 4 to compensate for unaligned sprite
		g.drawImage(getCurrentAnimationFrame(), (int)x-4, (int)y, width, height, null);
		//g.setColor(Color.RED);
		//g.fillRect((int)x + bounds.x, (int) y + bounds.y, bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		
		if(xMove < 0) { //Moving animation to the left
			currentAnimation = animationLeft;
		} else if(xMove > 0) { //Moving animation right
			currentAnimation = animationRight;
		} else if (yMove < 0) { //Moving up, (y negative direction)
			currentAnimation = animationUp;
		} else if(yMove > 0) { //Moving animation down
			currentAnimation = animationDown;
		} 
		
		return currentAnimation.getCurrentFrame();
	}
}
