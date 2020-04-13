package fr.nahjoo.com;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player extends Entity{
	int velX = 0;
	int velY = 0;
	int life = 2;
	private boolean play;
	private int sizeX = 80;
	private int sizeY = 10;
	
	public Player(int x, int y) {
		super(x,y);
	}
	public void update() {
		x +=velX;
	}
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.green);
		g2d.fillRect(x, y, sizeX, sizeY);
	}
	
	// keyEvent
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_Q) {
			velX = -2;
			play = true;
			
		}else if(key == KeyEvent.VK_D) {
			velX = 2;
			play = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_Q) {
			velX = 0;
			
		}else if(key == KeyEvent.VK_D) {
			velX= 0;
		}else if(key == KeyEvent.VK_ENTER) {
			if(life < 1) {
				play = true;
				life = 2;
			}
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
	
	public boolean isPlay() {
		return play;
	}
	public void setPlay(boolean play) {
		this.play = play;
	}
}
