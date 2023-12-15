package app.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.narzedzia.UtilityTool;
import app.panele.GamePanel;

public class Entity {

	public GamePanel gp;
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2,
			attackLeft1, attackLeft2, attackRight1, attackRight2;
	public BufferedImage image, image2, image3;
	public Rectangle solidArea =  new Rectangle(0 , 0, 48, 48);
	public int solidAreaDefaultX,solidAreaDefaultY;
	public boolean collisionOn = false;
	public String dialogues[] = new String[20];
	
	// STATE
	public int worldX, worldY;
	public String  direction = "down";
	public int spriteNum = 1;
	public int dialogueIndex = 0;
	public boolean collision = false;
	public boolean invicible = false;
	public boolean attacking = false;
	
	// COUNTER
	public int spriteCounter = 0;
	public int actionLockCounter = 0;
	public int invicibleCounter = 0;
	
	// CHARACTER ATTRIBUTES
	public int type; // 0 player, 1 NPC, 2 =  Monster
	public String name;
	public int speed;
	public int maxLife;
	public int life;
	
	
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setAction() {
		
	}
	
	public void speak() {
		if(dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}
		
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}
	
	public void update() {
		setAction();
		collisionOn = false;
		gp.colChecker.checkTile(this);
		gp.colChecker.checkObject(this, false);
		gp.colChecker.checkEtity(this, gp.npc);
		gp.colChecker.checkEtity(this, gp.monster);
		boolean contactPlayer = gp.colChecker.checkPlayer(this);
		
		// WYKRYWANIE KONTAKTU 
		if(this.type == 2 && contactPlayer == true) {
			if(gp.player.invicible == false) {
				// we can give damge
				gp.player.life -= 1;
				gp.player.invicible = true;
			}
		}
		
		//IF COLLISON IS FALSE, PLAYER CANN MOVE 
		if(collisionOn ==  false) {
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			}
		}
		
		spriteCounter++;	
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			} else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	
	public BufferedImage setup(String imagePath, int width, int height) {
		
		UtilityTool uTool =  new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResource(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return image;	
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX&&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize< gp.player.worldY + gp.player.screenY) {
			switch(direction) {
			case "up":
				if(spriteNum ==1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
				break;
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
				break;
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image =  right2;
				}
				break;		
			}
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}
	}
}
