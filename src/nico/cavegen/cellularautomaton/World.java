package nico.cavegen.cellularautomaton;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nico.cavegen.Reference;

public class World {

	private boolean[][] grid;
	
	public World() {
		this.grid = new boolean[Reference.WORLD_SIZE][Reference.WORLD_SIZE];
	}
	
	public void randomFill() {
		Random rand = new Random();
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(i == 0 || j == 0 || i == grid.length-1 || j == grid[i].length-1) {
					this.grid[i][j] = true;
				} else {
					this.grid[i][j] = rand.nextFloat() > Reference.FILL_LEVEL;
				}
			}
		}
	}
	
	public void smooth() {
		boolean[][] another = this.copyGrid();
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				int nearby = this.countNearby(i, j);
				
				if(nearby > 4)
					another[i][j] = true;
				else if(nearby < 4)
					another[i][j] = false;
			}
		}
		this.grid = another;
	}
	
	public void draw(Graphics graphics) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j])
					graphics.setColor(new Color(0.5f, 0.5f, 0.5f));
				else
					graphics.setColor(new Color(0.7f, 0.7f, 0.7f));
				graphics.fillRect(i * Reference.TILE_SIZE, j * Reference.TILE_SIZE, Reference.TILE_SIZE, Reference.TILE_SIZE);
			}
		}
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(!grid[i][j] && grid[i][j-1]) {
					graphics.setColor(new Color(0.3f, 0.3f, 0.3f));
					graphics.fillRect(i * Reference.TILE_SIZE, j * Reference.TILE_SIZE, Reference.TILE_SIZE, Reference.TILE_SIZE * 3);
				}
			}
		}
	}
	
	private int countNearby(int ic, int jc) {
		int sum = 0;
		for(int i=ic-1;i<=ic+1;i++) {
			for(int j=jc-1;j<=jc+1;j++) {
				if(i >= 0 && j >= 0 && i < grid.length && j < grid[i].length) {
					if(grid[i][j] && (i != ic || j != jc)) {
						sum++;
					}
				} else {
					sum++;
				}
			}
		}
		return sum;
	}
	
	private boolean[][] copyGrid() {
		boolean[][] another = new boolean[Reference.WORLD_SIZE][Reference.WORLD_SIZE];
		for(int i=0;i<another.length;i++) {
			for(int j=0;j<another[i].length;j++) {
				another[i][j] = this.grid[i][j];
			}
		}
		return another;
	}
}
