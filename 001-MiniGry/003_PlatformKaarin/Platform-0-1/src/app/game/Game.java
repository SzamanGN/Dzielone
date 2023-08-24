package app.game;

import java.awt.Graphics;

import app.entities.Player;
import app.okna.GameWindow;
import app.panele.GamePanel;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	private Player player;
	
	public Game() {
		
		initClasses();
		
		System.out.println("Show the Game Class");
		// dodanie okna gry
		gamePanel = new GamePanel(this);
		gameWindow =  new GameWindow(gamePanel);
		gamePanel.requestFocus();
		
		
		// ostanie do zalodowania
		startGameLoop();
	}

	private void initClasses() {
		player = new Player(200, 200);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		//gamePanel.updateGame(); usuwamy nic juz tam nie ma 
		player.update();
	}
	
	public void render(Graphics g) {
		player.render(g);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	
	public void windowsFocusLost() {
		player.setRestDirBooleans();
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		//long lastFrame = System.nanoTime();
		//long now = System.nanoTime();
		
		long privesTime = System.nanoTime();
		
		int frames =0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		
		double deltaU = 0;
		double deltaF = 0;
		
		while(true) {		
			//now = System.nanoTime();
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - privesTime) / timePerUpdate;
			deltaF += (currentTime - privesTime) / timePerFrame;
			privesTime = currentTime;
			
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
//			if(now - lastFrame >= timePerFrame) {
//				gamePanel.repaint();
//				lastFrame = now;
//				frames++;
//			}
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + "| UPS : " + updates);
				frames = 0;
				updates = 0;
			}
			
		}
	}



}
