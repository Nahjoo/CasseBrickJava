package fr.nahjoo.com;

import javax.swing.JFrame;

public class Main extends JFrame{

	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Créate By Nahjo_");
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(710,240);
		frame.setAlwaysOnTop(false);
		frame.add(new GameMain());
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
