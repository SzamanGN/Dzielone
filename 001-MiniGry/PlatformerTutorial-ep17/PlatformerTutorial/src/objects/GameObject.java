package objects;

import static utilz.Constants.ANI_SPEDD;
import static utilz.Constants.ObjectConstats.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public class GameObject {

	protected int x;
	protected int y;
	protected int objType;
	protected boolean doAnimation;
	protected boolean active = true;
	protected int aniTick;
	protected int aniIndex;
	protected int xDrawOffset;
	protected int yDrawOffset;
	protected Rectangle2D.Float hitbox;
	
	public GameObject(int x, int y, int objType) {
		this.x = x;
		this.y = y;
		this.objType = objType;
	}
	
	protected void initHitbox( int width, int height) {
		hitbox = new Rectangle2D.Float(x, y, (int)(width * Game.SCALE),(int) (height * Game.SCALE));
	}

	protected void drawHitbox(Graphics g, int xLvlOffset) {
		// For debugging the hitbox
		g.setColor(Color.PINK);
		g.drawRect((int) hitbox.x - xLvlOffset, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
	}
	
	protected void updateAnimationTick() {
		aniTick++;
		if (aniTick >= ANI_SPEDD) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(objType)) {
				aniIndex = 0;
				if(objType == BARREL || objType == BOX) {
					doAnimation =  false;
					active = false;
				}

			}
		}
	}
	
	public void reset() {
		aniIndex = 0;
		aniTick = 0;
		active = true;
		if(objType == BARREL || objType == BOX) {
			doAnimation =  false;
		} else {
			doAnimation =  true;
		}
		
		doAnimation = true;
	}

	public int getObjType() {
		return objType;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active =  active;
	}

	public int getxDrawOffset() {
		return xDrawOffset;
	}

	public void setxDrawOffset(int xDrawOffset) {
		this.xDrawOffset = xDrawOffset;
	}

	public int getyDrawOffset() {
		return yDrawOffset;
	}


	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public int getAniIndex() {
		return aniIndex;
	}
	
	public void setAnimation(boolean doAnimation) {
		this.doAnimation = doAnimation;
	}
}
