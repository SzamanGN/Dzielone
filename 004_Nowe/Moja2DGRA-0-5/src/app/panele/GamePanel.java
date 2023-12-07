package app.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import app.entity.Player;
import app.narzedzia.CollisionChecker;
import app.sterowanie.KeyHandler;
import app.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	// SCREEN SETTINGS
	public final int orginalTileSize = 16; // 16x16 tile
	public final int scale = 3;

	public final int tileSize = orginalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768
	public final int screenHeight = tileSize * maxScreenRow; // 576
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	// FPS
	private int FPS = 60;
	
	public TileManager tileM =  new TileManager(this);
	private KeyHandler keyH = new KeyHandler();
	private Thread gameThread;
	public CollisionChecker colChecker = new CollisionChecker(this);
	public Player player =  new Player(this, keyH);

	// set player default position
//	private int playerX = 100;
//	private int playerY = 100;
//	private int plaeyerSpeed = 4; 

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

//	@Override
//	public void run() {
//		while (gameThread != null) {
//			
//			double drawInterval = 1000000000/ FPS; //0,1666 
//			double nextDrawTime = System.nanoTime() + drawInterval;
//			
//
//			// System.out.println("Game is running");
//
//			// update: character position
//			update();
//
//			// draw:the screen with the update information
//			repaint();
//			
//			try {
//				double remainingTime = nextDrawTime -System.nanoTime();
//				remainingTime = remainingTime / 1000000;
//				
//				if(remainingTime < 0) {
//					remainingTime = 0;
//				}
//				
//				Thread.sleep((long)remainingTime);
//				
//				nextDrawTime += drawInterval;
//				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	// druga metoda
	
	
	public void run() {
		
		double drawInterval = 1000000000/ FPS; //0,1666
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime ) / drawInterval;
			timer += (currentTime - lastTime );
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if(timer > 1000000000) {
				//System.out.println("FPS " + drawCount); // ja wylaczam widocznosc
				drawCount = 0;
				timer = 0;
			}
		}
		
	}
	
	public void update() {
		player.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}

}