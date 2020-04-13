package fr.nahjoo.com;

public class Brick extends Entity {
	private int sizeX = 80;
	private int sizeY = 30;
	
	public Brick(int x, int y) {
		super(x,y);
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
