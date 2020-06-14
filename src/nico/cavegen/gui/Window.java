package nico.cavegen.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import nico.cavegen.Reference;

public class Window {

	private static JFrame frame;
	
	public static void create(CaveGenerator caveGenerator) {
		frame = new JFrame("Cave generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		caveGenerator.setPreferredSize(new Dimension(Reference.WORLD_SIZE * Reference.TILE_SIZE, Reference.WORLD_SIZE * Reference.TILE_SIZE));
		caveGenerator.setFocusable(true);
		caveGenerator.addKeyListener(caveGenerator);
		frame.add(caveGenerator);
		caveGenerator.requestFocusInWindow();
		frame.pack();
		frame.setVisible(true);
	}
}
