package com.valorlegends.states;

import java.awt.Graphics;

import com.valorlegends.entity.Player;
import com.valorlegends.util.Handler;
import com.valorlegends.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.lvl");
		handler.setWorld(world);
		player = new Player(handler, 320, 550);
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
