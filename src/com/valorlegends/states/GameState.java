package com.valorlegends.states;

import java.awt.Graphics;

import com.valorlegends.Game;
import com.valorlegends.display.Display;
import com.valorlegends.entity.Player;
import com.valorlegends.graphics.Assets;
import com.valorlegends.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 50, 50, 32, 32);
		world = new World("res/worlds/world1.lvl");
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
