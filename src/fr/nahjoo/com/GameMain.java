package fr.nahjoo.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameMain extends JPanel implements ActionListener{
	Player player;
	Balle balle;
	Brick brick;
	Map map;
	Timer timer;
	boolean play = false;
	int score = 0;
	
	
	public GameMain() {
		setFocusable(true);
		map = new Map();
		brick = new Brick(0,0);
		player = new Player(200,530);
		addKeyListener(new KeyAdapt(player));
		balle = new Balle(200,400);
		timer = new Timer(5,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		player.draw(g2d);
		balle.draw(g2d);
		map.draw(g2d);
		g2d.setColor(Color.black);
		g2d.setFont(new Font("serif",Font.BOLD,15));
		g2d.drawString("score : "+score, 400, 550);
		g2d.setFont(new Font("serif",Font.BOLD,15));
		g2d.drawString("vie : "+player.life, 20, 550);
		
		if(player.life < 1) {
			player.setPlay(false);
			balle.x = 200;
			balle.y = 400;
			score = 0;
			map = new Map();
			g2d.setFont(new Font("serif",Font.BOLD,40));
			g2d.setColor(Color.red);
			g2d.drawString("Game Over", 150, 300);
			
			g2d.setFont(new Font("serif",Font.BOLD,20));
			g2d.setColor(Color.red);
			g2d.drawString("press enter to restart", 170, 350);
		}
	}
	
	public void collision() {
		Rectangle rectP = new Rectangle(player.x,player.y,player.getSizeX(),player.getSizeY());
		Rectangle rectB = new Rectangle(balle.x,balle.y,balle.getSizeX(),balle.getSizeY());
		
		if(rectP.intersects(rectB)) {
			balle.backY = true;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(player.isPlay() == true) {
			A:for(int i = 0; i < map.map.length; i++) {
				for(int j = 0; j<map.map[i].length; j++) {
					if(map.map[i][j] == 1) {
						Rectangle rect = new Rectangle(j * map.getWidth(), i * map.getHeight(), map.getWidth(), map.getHeight());
						Rectangle ball = new Rectangle(balle.x, balle.y, balle.getSizeX(), balle.getSizeY());
						
						if(ball.intersects(rect)) {
							map.map[i][j] = 0;
							score++;
							if(balle.x + balle.getSizeX()-1 <= rect.x || balle.x + 1 >= rect.x + rect.width) {
								balle.backX = true;
							}else {
								balle.backY = false;
							}
							break A;
						}
					}
				}
			}
		
		if(score < 1) {
			score = 0;
		}
		if(balle.y > this.getHeight()-balle.getSizeY()) {
			player.setPlay(false);
			balle.x = 200;
			balle.y = 400;
			--score;
			--player.life;
		}
			player.update();
			balle.collision(this.getWidth(), this.getHeight());
			collision();
		}		
		repaint();
	}
}
