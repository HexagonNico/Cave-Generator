package nico.cavegen;

import javax.swing.Timer;

import nico.cavegen.gui.CaveGenerator;
import nico.cavegen.gui.Window;

public class Main {

	private static Timer timer;
	
	public static void main(String[] args) {
		CaveGenerator generator = new CaveGenerator();
		Window.create(generator);
		
		timer = new Timer(200, generator);
		timer.start();
	}
}
