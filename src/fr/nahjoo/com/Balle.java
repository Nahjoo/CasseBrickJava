package fr.nahjoo.com;

import java.awt.Color;
import java.awt.Graphics2D;

public class Balle extends Entity{
	private int sizeX = 20;
	private int sizeY = 20;

	boolean backX = true;
	boolean backY = true;

	public Balle(int x, int y) {
		super(x,y);
		this.x = 200;
		this.y = 400;
	}
	public void update() {
		
	}
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fillOval(x,y, sizeX, sizeY);
	}
	
	public void collision(int width, int height) {
		if(x < 1) {
			backX = false;
		} 
		if(x > width-sizeX) {
			backX = true;
		}
		
		if(y < 1) {
			backY = false;
		}
		if(y > height-sizeY) {
			backY = false;
		}
		
		if(!backX) {
			x++;
			
		} else {
			--x;
		}
		if(!backY) {
			y++;
		}
		else {
			--y;
		}
	}
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}	
}
