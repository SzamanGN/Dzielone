package entities;

import static utilz.Constants.EnemyConstans.*;
import static utilz.HelpMethods.*;
import static utilz.Constants.Directions.*;

import main.Game;
// czas zakoniczenia ogladaani 12 09
public abstract class Enemy extends Entity {
	
	protected int aniIndex;
	protected int enemyState;
	protected int enemyType;
	protected int aniTick;
	protected int aniSpeed = 25;
	protected boolean firstUpdate = true;
	protected boolean inAir;
	protected float fallSpeed;
	protected float gravity = 0.04f * Game.SCALE;
	protected float walkSpeed = 0.35f * Game.SCALE;
	protected int walkDir = LEFT;

	public Enemy(float x, float y, int width, int height, int enemyType) {
		super(x, y, width, height);
		this.enemyType = enemyType;
		initHitbox(x, y, width, height);
	}
	
	protected void firstUpdateCheck(int[][] lvlData) {
			if(!IsEntityOnFloar(hitbox, lvlData))
				inAir = true;
				firstUpdate = false;
	}
	
	protected void  updateInAir(int[][] lvlData) {
		if(CanMoveHere(hitbox.x, hitbox.y + fallSpeed, hitbox.width, hitbox.height, lvlData)) {	
			hitbox.y += fallSpeed;
			fallSpeed += gravity;
		}else {
			inAir = false;
			hitbox.y = GetEntityYPosUderRofOrAboveFloor(hitbox, fallSpeed);
		}
	}
	
	protected void move(int[][] lvlData) {
		float xSpeed = 0;
		
		if(walkDir == LEFT)
			xSpeed = -walkSpeed;
		else
			xSpeed = walkSpeed;
		
		if(CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
			if(IsFloor(hitbox, xSpeed, lvlData)) {
				hitbox.x += xSpeed;
				return;
			}
		chanegeWalkDir();
	}
	
	protected void canSeePlayer() {
		
	}
	
	protected void newState(int enemyState) {
		this.enemyState = enemyState;
		aniTick = 0;
		aniIndex = 0;
	}

	protected void updateAnimationTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(enemyType, enemyState)) {
				aniIndex = 0;
			}		
		}
	}
	
	protected void update(int[][] lvlData) {
		updateMove(lvlData);
		updateAnimationTick();
	}
	
	protected void updateMove(int[][] lvlData) {
		if(firstUpdate) {
			if(!IsEntityOnFloar(hitbox, lvlData))
				inAir = true;
				firstUpdate = false;
		}
		if(inAir) {
			if(CanMoveHere(hitbox.x, hitbox.y + fallSpeed, hitbox.width, hitbox.height, lvlData)) {	
				hitbox.y += fallSpeed;
				fallSpeed += gravity;
			}else {
				inAir = false;
				hitbox.y = GetEntityYPosUderRofOrAboveFloor(hitbox, fallSpeed);
			}
		}else {
			switch (enemyState){
			case IDLE:
				enemyState  = RUNNING;
				break;
			case RUNNING:
				float xSpeed = 0;
				
				if(walkDir == LEFT)
					xSpeed = -walkSpeed;
				else
					xSpeed = walkSpeed;
				
				if(CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
					if(IsFloor(hitbox, xSpeed, lvlData)) {
						hitbox.x += xSpeed;
						return;
					}
				chanegeWalkDir();
				break;
			}
		}
	}
	
	protected void chanegeWalkDir() {
		if(walkDir == LEFT)
			walkDir = RIGHT;
		else
			walkDir = LEFT;
	}

	public int getAniIndex() {
		return aniIndex;
	}
	
	public int getEnemyState() {
		return enemyState;
	}
}
