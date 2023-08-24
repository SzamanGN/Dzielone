package app.entities;

import static app.utliz.Constans.playerConstans.IDLE;
import static app.utliz.Constans.playerConstans.*;
import static app.utliz.Constans.playerConstans.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity {

	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 15;
	private int playerAction = IDLE;
	//private int playeDirections = -1;
	private boolean moving = false, attacking;
	private boolean left, up, right, down;
	private float plaeyerSpeed = 2.0f;
	

	public Player(float x, float y) {
		super(x, y);
		loadAnimation();
	}

	public void update() {

		updatePos();
		updateAnimationsTick();
		setAnimations();
		
		
	

	}
	

	public void render(Graphics g) {
		g.drawImage(animations[playerAction][aniIndex],(int) x, (int)y, 256, 160, null);
	}
	
	public void loadAnimation() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			BufferedImage img = ImageIO.read(is);
			animations = new BufferedImage[9][6];
			for (int j = 0; j < animations.length; j++) {
				for (int i = 0; i < animations[j].length; i++) {
					animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
//	public void setDirection(int direction) {
//		this.playeDirections = direction;
//		moving = true;
//	}
	
//	public void setMoving(boolean moving) {
//		this.moving = moving;
//	}
	
	private void updateAnimationsTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= getSpriteAmount(playerAction)) {
				aniIndex = 0;
				attacking = false;
			}
		}
		
	}
	
	private void setAnimations() {
		
		int startAni = playerAction;
		
		if(moving) {
			playerAction =RUNNIG;
		}else 
			playerAction =IDLE;
			
			// dodanie ataku
		if(attacking) 
			playerAction = ATTACK_01;
			
		if (startAni != playerAction)
			resetAniTick();
			
	}
	
	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
		
	}

	private void updatePos() {
		
//		if(moving) {
//			switch(playeDirections) {
//			case LEFT:
//				x -= 1;
//				break;
//			case UP:
//				y -= 1;
//				break;
//			case RIGHT:
//				x += 1;
//				break;
//			case DOWN:
//				y += 1;
//				break;

			//}
//		}
		
		// nowa metdoa na obliczenie pozycji
		moving = false;
		
		if(left && !right) {
			x -= plaeyerSpeed;
			moving = true;
		}else if(right && !left) {
			x += plaeyerSpeed;
			moving = true;
		}
		
		if(up && !down) {
			y -= plaeyerSpeed;
			moving = true;
		}else if(down && !up) {
			y += plaeyerSpeed;
			moving = true;
		}
		
	}
	
	public void setRestDirBooleans() {
		left = false;
		up = false;
		right = false;
		down = false;
	}
	
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}
	
	
	

}
