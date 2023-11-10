package app.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import app.sterowanie.KeyHandler;

public class GamePanel extends JPanel implements Runnable {

	private int FPS = 60;

	private KeyHandler keyH = new KeyHandler();

	// set player default position
	private int playerX = 100;
	private int playerY = 100;
	private int playerSpeed = 4;

	// screem settings
	final int orginalTileSize = 16; // 16x16
	final int scale = 3;

	final int tileSize = orginalTileSize * scale; // 48*48
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576
	private Thread gameThread;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		StartGameThread();

	}

	public void StartGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
	
		double drawInterval = 1000000000 / FPS; // 0,01666 second
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			

			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics g2 = (Graphics) g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	}

	public void update() {

		if (keyH.upPressed == true) {
			playerY -= playerSpeed;
		} else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		} else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		} else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}

	}

}
