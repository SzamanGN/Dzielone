package gamesteats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Player;
import levels.LevelManager;
import main.Game;
import ui.PauseOverlay;
import utilz.LoadSave;

public class Playing extends State implements Statemethods{
	private Player player;
	private LevelManager levelManager;
	private PauseOverlay pauseOverlay;
	private boolean pause = false;
	
	private int xLevelOffset;
	private int leftBorder = (int) (0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int) (0.8 * Game.GAME_WIDTH);
	private int lvlTilesWidght = LoadSave.GetLevelData()[0].length;
	private int maxTilesOffset = lvlTilesWidght - Game.TILES_IN_WIDTH;
	private int maxLvlOffsetX = maxTilesOffset * Game.TILES_SIZE;
	
	public Playing(Game game) {
		super(game);
		initClasses();
	}

	private void initClasses() {
		levelManager = new LevelManager(game);
		player = new Player(200, 200, (int)(64 * Game.SCALE), (int)(40 * Game.SCALE));
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
		pauseOverlay = new PauseOverlay(this);

	}
	


	@Override
	public void update() {
		if (!pause) {
			levelManager.update();
			player.update();
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
		levelManager.draw(g, xLevelOffset);
		player.render(g, xLevelOffset);
		
		if(pause) {
			g.setColor(new Color(0, 0, 0, 150));
			g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
			pauseOverlay.draw(g);
			System.out.println("odrywoano pauseOverlay");
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