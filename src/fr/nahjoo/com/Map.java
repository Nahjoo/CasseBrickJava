package fr.nahjoo.com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
	int map[][] = {{1,1,1,1,1,1},
				   {1,1,1,1,1,1},
				   {1,1,1,1,1,1},
				   {1,1,1,1,1,1},
				   {1,1,1,1,1,1},
				   {1,1,1,1,1,1},
				  };
	Brick brick;
	private int width = 80;
	private int height = 30;
	
	public Map() {
		
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 1) {
					g2d.setColor(Color.blue);
					g2d.fillRect(j * width, i * height, width, height);
					
					g2d.setStroke(new BasicStroke(1));
					g2d.setColor(Color.white);
					g2d.drawRect(j * width, i * height, width, height);
				}
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
