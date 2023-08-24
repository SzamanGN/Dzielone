package app.panele;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static app.utliz.Constans.playerConstans.*;
import static app.utliz.Constans.Directions.*;

import app.game.Game;
import app.inputs.KeyboradInputs;
import app.inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	//private float xDelta = 100, yDelta = 100;
	//private BufferedImage img; // subImg;
//	private BufferedImage[][] animations;// idleAni;
//	private int aniTick, aniIndex, aniSpeed = 15;
//	private int playerAction = IDLE;
//	private int playeDirections = -1;
//	private boolean moving = false;

	// private float xDir = 1f, yDir =1f;
	// private int frames = 0;
	// private long lastCheck = 0;
	// private Color color = new Color (150, 20, 90);
	// private Random random;
	
	private Game game;

	public GamePanel(Game game) {

		//importImg();
		//loadAnimations();
		// random = new Random();
		mouseInputs = new MouseInputs(this);
		setPanelSize();
		addKeyListener(new KeyboradInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		this.game = game;

	}

//	private void loadAnimations() {
//
//		animations = new BufferedImage[9][6];
//
////		for(int i = 0; i < idleAni.length; i++) {
////			idleAni[i] = img.getSubimage(i * 64, 0, 64, 40);
////		}
//
//		for (int j = 0; j < animations.length; j++) {
//			for (int i = 0; i < animations[j].length; i++) {
//				animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
//			}
//		}
//
//	}

//	private void importImg() {
//
//		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
//		try {
//			img = ImageIO.read(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);

	}

//	public void changeXdelta(int value) {
//		this.xDelta += value;
//		repaint();
//	}
//
//	public void changeYdelta(int value) {
//		this.yDelta += value;
//	}
//
//	public void setRectPos(int x, int y) {
//		this.xDelta = x;
//		this.yDelta = y;
//	}

//	public void setDirection(int direction) {
//		this.playeDirections = direction;
//		moving = true;
//	}

//	public void setMoving(boolean moving) {
//		this.moving = moving;
//	}
//
//	private void updateAnimationsTick() {
//		aniTick++;
//		if (aniTick >= aniSpeed) {
//			aniTick = 0;
//			aniIndex++;
//			if (aniIndex >= getSpriteAmount(playerAction)) {
//				aniIndex = 0;
//			}
//		}
//
//	}
//
//	private void setAnimations() {
//		if (moving) {
//			playerAction = RUNNIG;
//		} else {
//			playerAction = IDLE;
//		}
//	}
//
//	private void updatePos() {
//		if (moving) {
//			switch (playeDirections) {
//			case LEFT:
//				xDelta -= 5;
//				break;
//			case UP:
//				yDelta -= 5;
//				break;
//			case RIGHT:
//				xDelta += 5;
//				break;
//			case DOWN:
//				yDelta += 5;
//				break;
//			}
//		}
//	}

	public void updateGame() {

//		updateAnimationsTick();
//		setAnimations();
//		updatePos();

	}
	
	public Game getGame() {
		return game;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// updateRectangel();
		// przypisanie koloru
//		g.setColor(color);
//		g.fillRect((int)xDelta, (int)yDelta, 200, 50);
		// repaint();

		// g.drawImage(img,0, 0, null);
		// g.drawImage(img.getSubimage(0, 0, 64, 40), 0, 0, null);
		// g.drawImage(img.getSubimage(0, 0, 64, 40), 0, 0, 128, 80, null);

		// subImg = img.getSubimage(1 * 64, 8 * 40, 64, 40);
		// g.drawImage(subImg,(int) xDelta, (int)yDelta, 128, 80, null);

//		updateAnimationsTick();
//		setAnimations();
//		updatePos();

		// g.drawImage(animations[playerAction][aniIndex],(int) xDelta, (int)yDelta,
		// 256, 160, null);
		
		game.render(g);

	}

}

//	private void updateRectangel() {
//		xDelta += xDir;
//		if(xDelta > 400 || xDelta < 0) {
//			xDir *= -1;
//			color = getRndColor();
//		}
//		
//		
//		yDelta +=  yDir;
//		if(yDelta > 400 || yDelta < 0) {
//			yDir *= -1;
//			color = getRndColor();
//		}
//		
//	}

//	private Color getRndColor() {
//		int r = random.nextInt(255);
//		int g = random.nextInt(255);
//		int b = random.nextInt(255);
//		return new Color(r,b,g);
//	}

//}
