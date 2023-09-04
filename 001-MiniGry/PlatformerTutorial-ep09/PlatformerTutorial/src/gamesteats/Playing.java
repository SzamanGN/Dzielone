package gamesteats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import entities.EnemyManager;
import entities.Player;
import levels.LevelManager;
import main.Game;
import ui.PauseOverlay;
import utilz.LoadSave;
import static utilz.Constants.Environment.*;

public class Playing extends State implements Statemethods{
	private Player player;
	private LevelManager levelManager;
	private EnemyManager enemyManager;
	private PauseOverlay pauseOverlay;
	private boolean pause = false;
	
	private int xLevelOffset;
	private int leftBorder = (int) (0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int) (0.8 * Game.GAME_WIDTH);
	private int lvlTilesWidght = LoadSave.GetLevelData()[0].length;
	private int maxTilesOffset = lvlTilesWidght - Game.TILES_IN_WIDTH;
	private int maxLvlOffsetX = maxTilesOffset * Game.TILES_SIZE;
	
	// Dodanie tla do w trakcjie gry
	private BufferedImage backgroundImg, bigCloud, smallCloud;
	private int[] smallCloudsPos;
	private Random rmd;
	
	public Playing(Game game) {
		super(game);
		initClasses();
		
		backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PLAY_BG_IMG);
		bigCloud = LoadSave.GetSpriteAtlas(LoadSave.BIG_CLOUDS);
		smallCloud = LoadSave.GetSpriteAtlas(LoadSave.SMALL_CLOUDS);
		smallCloudsPos = new int[8];
		rmd = new Random();
		for(int i = 0; i < smallCloudsPos.length; i++) {
			smallCloudsPos[i] = (int)(90 * Game.SCALE) + rmd.nextInt((int)(100 * Game.SCALE));
		}
	}

	private void initClasses() {
		levelManager = new LevelManager(game);
		enemyManager = new EnemyManager(this);
		player = new Player(200, 200, (int)(64 * Game.SCALE), (int)(40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		//player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		pauseOverlay = new PauseOverlay(this);

	}
	


	@Override
	public void update() {
		if (!pause) {
			levelManager.update();
			player.update();
			enemyManager.update(levelManager.getCurrentLevel().getLevelData());
			checkCloseToBorder();
		} else {
			pauseOverlay.upDate();
		}
	}

	private void checkCloseToBorder() {
		int playerX = (int) (player.getHitbox().x);
		int diff = playerX - xLevelOffset;
		
//		if(diff > rightBorder) 
//			xLevelOffset += diff - rightBorder;
//		else if (diff < leftBorder)
//			xLevelOffset += diff - leftBorder;
//		if(xLevelOffset > maxLvlOffsetX)
//			xLevelOffset = maxLvlOffsetX;
//		else if(xLevelOffset < 0)
//			xLevelOffset = 0;

		
//		}
		if(diff > rightBorder) {
			xLevelOffset += diff - rightBorder;
		}else if (diff < leftBorder) {
			xLevelOffset += diff - leftBorder;
		}
		
		if(xLevelOffset > maxLvlOffsetX) {
			xLevelOffset = maxLvlOffsetX;
		}else if(xLevelOffset < 0) {
			xLevelOffset = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		
		drawClods(g);
		
		levelManager.draw(g, xLevelOffset);
		player.render(g, xLevelOffset);
		enemyManager.draw(g, xLevelOffset);
		
		if(pause) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
			pauseOverlay.draw(g);
			System.out.println("odrywoano pauseOverlay");
		}
	}
	
	private void drawClods(Graphics g) {
		
		for(int i = 0; i < 3; i++) {
		g.drawImage(bigCloud, i * BIG_CLOUD_WIDTH - (int)(xLevelOffset * 0.3), (int)(204 * Game.SCALE), BIG_CLOUD_WIDTH, BIG_CLOUD_HEIGHT, null);
		}
		
		for(int i = 0; i < smallCloudsPos.length; i++) {
		g.drawImage(smallCloud, SMALL_CLOUD_WIDTH * 4 * i - (int)(xLevelOffset * 0.7), smallCloudsPos[i], SMALL_CLOUD_WIDTH, SMALL_CLOUD_HEIGHT, null);
		}
	}

	public void mouseDragged(MouseEvent e) {
		if(pause)
			pauseOverlay.mouseDragged(e);
	}

	@Override
	public void mouseCliked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			player.setAttacking(true);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(pause)
			pauseOverlay.mousePressed(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(pause)
			pauseOverlay.mouseReleased(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(pause)
			pauseOverlay.mouseMoved(e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_S:
			player.setDown(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(true);
			break;
		case KeyEvent.VK_ESCAPE:
			pause = !pause;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(false);
			break;
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_S:
			player.setDown(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			player.setJump(false);
			break;
		}
		
	}
	public void unpauseGame() {
		pause = false;
	}
	
	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	public Player getPlayer() {
		return player;
	}
	

}
