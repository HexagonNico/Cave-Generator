package nico.cavegen.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import nico.cavegen.cellularautomaton.World;

public class CaveGenerator extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private World world;
	
	public CaveGenerator() {
		this.world = new World();
		this.world.randomFill();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.world.smooth();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.world.draw(g);
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		this.world.randomFill();
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
