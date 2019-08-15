package com.valorlegends.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	//Used for displaying a window
	private JFrame frame;
	//Graphics will drawn to the canvas
	//When we add the canvas element to the JFrame, then we can see it.
	private Canvas canvas;
	
	private String title;
	private int width;
	private int height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		initDisplay();
	}
	
	private void initDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		//Ensures the entire application will close, not just the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//Center the frame to the center when first opening
		frame.setLocationRelativeTo(null);
		//Make our frame visible
		frame.setVisible(true);
		
		canvas = new Canvas();
		//Canvas accepts a dimension object
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		//Add our canvas to our frame
		frame.add(canvas);
		//Resize our window so canvas can be fully displayed
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
}
