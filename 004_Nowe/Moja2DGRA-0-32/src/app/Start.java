package app;

import javax.swing.JFrame;

import app.panele.GamePanel;

public class Start {

	public static void main(String[] args) {
		// BREAKING OBJECTS
		System.out.println("Moja 2D Gra-wersja-0-32 epizod 33");
		
		JFrame windows = new JFrame();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setResizable(false);
		windows.setTitle("2D Przygoda");
		
		GamePanel gamePanel =  new GamePanel();
		windows.add(gamePanel);
		
		windows.pack();
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
		windows.setLocationRelativeTo(null);
		windows.setVisible(true);
	}

}