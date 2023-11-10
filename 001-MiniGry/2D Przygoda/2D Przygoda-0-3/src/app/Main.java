package app;

import javax.swing.JFrame;

import app.panel.GamePanel;

public class Main {

	public static void main(String[] args) {
		System.out.println("2D Przygoda-0-3 ");
		
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Przygoda");
		
		GamePanel gamePanel =  new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

}
