package app.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import app.entity.Player;
import app.narzedzia.AssetSetter;
import app.narzedzia.CollisionChecker;
import app.object.SuperObject;
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
	// menager plytek 
	public TileManager tileM =  new TileManager(this);
	// wlasny sluchacz sterowania
	public KeyHandler keyH = new KeyHandler();
	// dodanie  watku
	public Thread gameThread;
	//dodanie kolizji
	public CollisionChecker colChecker = new CollisionChecker(this);
	//dodanie ustawienia obiktow
	public AssetSetter aSetter = new AssetSetter(this);
	//dodanie gracza
	public Player player =  new Player(this, keyH);
	//dodanie objektu
	public SuperObject obj[] = new SuperObject[10];

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	
	// dodawanie do mapy 
	public void setupGame() {
		aSetter.setObject();
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

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
		
		// plytki tile
		tileM.draw(g2);
		// objects ojekty
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		// gracz
		player.draw(g2);
		
		g2.dispose();
	}

}
