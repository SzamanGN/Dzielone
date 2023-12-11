package app.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.narzedzia.UtilityTool;
import app.panele.GamePanel;
import app.sterowanie.KeyHandler;

public class Player extends Entity {
	
	public GamePanel gp;
	public KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	//public int hasKey = 0;  // ilosc kluczy 

	public Player(GamePanel gp, KeyHandler keyH) {
	
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		
		steDefaultValues();
		getPlayerImage();
	}
	
	public void steDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
			
		up1 = setup("boy_up_1");
		up2 = setup("boy_up_2");
		down1 = setup("boy_down_1");
		down2 = setup("boy_down_2");
		left1 = setup("boy_left_1");
		left1 = setup("boy_left_2");
		right1 = setup("boy_right_1");
		right2 = setup("boy_right_2");
	}
	
	public BufferedImage setup(String imageName) {
		
		UtilityTool uTool =  new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResource("/player/" + imageName + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return image;	
	}
	
	public void update() {
		
		if(keyH.upPressed ==  true || keyH.downPressed == true 
				|| keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if (keyH.upPressed == true) {
				direction = "up";
				
			} else if (keyH.downPressed == true) {
				direction = "down";
				
			} else if (keyH.leftPressed == true) {
				direction = "left";
				
			} else if (keyH.rightPressed == true) {
				direction = "right";
				
			}
			
			//dodanie wyrkywanie kolizji
			collisionOn = false;
			gp.colChecker.checkTile(this);
			
			// check objects collision
			int objIndex = gp.colChecker.checkObject(this, true);
			pickUpObject(objIndex);// dodanie metody tu
			
			
			// if   collision is fasle player can move
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
	}
	
	
	// metoda do podnoszenia 
	public void pickUpObject(int i) {
		if(i != 999) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.WHITE);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
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
		g2.drawImage(image, screenX, screenY, null);
	}
}
