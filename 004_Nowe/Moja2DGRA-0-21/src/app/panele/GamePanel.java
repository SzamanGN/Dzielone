package app.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import app.entity.Entity;
import app.entity.Player;
import app.monster.MON_GreenSlime;
import app.narzedzia.AssetSetter;
import app.narzedzia.CollisionChecker;
import app.narzedzia.EventHandler;
import app.narzedzia.UI;
import app.sound.Sound;
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
	
	// FPS
	private int FPS = 60;
	// menager plytek 
	public TileManager tileM =  new TileManager(this);
	// wlasny sluchacz sterowania
	public KeyHandler keyH = new KeyHandler(this);
	//doanie muzyki Sound
	public Sound music = new Sound();
	public Sound se = new Sound();
	//dodanie kolizji
	public CollisionChecker colChecker = new CollisionChecker(this);
	//dodanie ustawienia obiktow
	public AssetSetter aSetter = new AssetSetter(this);
	//doanie Ui klasy
	public UI ui = new UI(this);
	// dodanie EvenHanlder
	public EventHandler eHandler =  new EventHandler(this);
	// dodanie  watku
	public Thread gameThread;
	//dodanie gracza
	public Player player =  new Player(this, keyH);
	//dodanie objektu
	public Entity obj[] = new Entity[10];
	//dodanie NPC
	public Entity npc[] = new Entity[10];
	// doaniae npc potwory
	public Entity monster[] = new Entity[20];
	// dodanie listy obiktow
	public ArrayList<Entity> entytiyList =  new ArrayList<>();
	
	// Game Status
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;
	
	

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	
	// dodawanie do mapy 
	public void setupGame() {
		// dodanie obiktu
		aSetter.setObject();
		// dodoanie NPC
		aSetter.setNPC();
		// dodanie potworow
		aSetter.setMonster();
		//wlaczenie muzyki o indeksie 0 
		//playMusic(0);
		//stopMusic();
		// doadanie statusu gry
		gameState = titleState;
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
		//dodanie statusu
		if(gameState == playState) {
			// PLAYER
			player.update();
			// NPC
			for(int i= 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
			// dodanie upate dla potworow
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					monster[i].update();
				}
			}
		}
		
		if(gameState == pauseState) {
			// nothing at moment
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// Debug
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}
		// Title screen
		if(gameState == titleState) {
			ui.draw(g2);
		// others	
		} else {
			
			// plytki tile TILE
			tileM.draw(g2);
			
			// ADD ENTITIS TO THE LIST
			entytiyList.add(player);
			
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null)
				entytiyList.add(npc[i]);
			}
			
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					entytiyList.add(obj[i]);
				}
			}
			
			// dodanie do rysowania listy potworow
			for(int i = 0; i < monster.length; i++) {
				if(monster[i] != null) {
					entytiyList.add(monster[i]);
				}
			}
			
			// SORT
			Collections.sort(entytiyList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					
					int result = Integer.compare(e1.worldY, e2.worldY); 
					return result;
				}
			});
			
			// DRAW ENTITIS
			for(int i = 0; i < entytiyList.size(); i++) {
				entytiyList.get(i).draw(g2);
			}
			
			// EMPTY ENTITY LIST
			for(int i = 0; i < entytiyList.size(); i++) {
				entytiyList.remove(i);
			}
			
			// doadnie UI
			ui.draw(g2);
		}
	
	
		
		// DEBUG
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.WHITE);
			g2.drawString("Draw time:" + passed, 10, 400);
			System.out.println("Draw time:" + passed);
		}
				
		g2.dispose();
	}
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();	
	}
	
	public void stopMusic() {
		music.stop();
	}

	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
