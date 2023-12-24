package app;

import javax.swing.JFrame;

import app.panele.GamePanel;

public class Start {

	public static JFrame windows;
	
	public static void main(String[] args) {
		// full screen mode
		System.out.println("Moja 2D Gra-wersja-0-33 epizod 34");
		
		windows = new JFrame();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setResizable(false);
		windows.setTitle("2D Przygoda");
		//windows.setUndecorated(true);
		
		GamePanel gamePanel =  new GamePanel();
		windows.add(gamePanel);
		
		windows.pack();
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
		windows.setLocationRelativeTo(null);
		windows.setVisible(true);
	}

}
