package app.entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.narzedzia.UtilityTool;
import app.panele.GamePanel;
import app.sterowanie.KeyHandler;

public class Player extends Entity {

	public KeyHandler keyH;
	public final int screenX;
	public final int screenY;

	public Player(GamePanel gp, KeyHandler keyH) {

		super(gp);
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
		getPlayerAttackImage();
	}

	public void steDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
//		worldX = gp.tileSize * 10;
//		worldY = gp.tileSize * 13;

		speed = 4;
		direction = "down";

		// PLAYER STATUS
		maxLife = 6;
		life = maxLife;
	}

	public void getPlayerImage() {

		up1 = setup("/player/boy_up_1", gp.tileSize, gp.tileSize);
		up2 = setup("/player/boy_up_2", gp.tileSize, gp.tileSize);
		down1 = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/player/boy_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/player/boy_left_1", gp.tileSize, gp.tileSize);
		left2 = setup("/player/boy_left_2", gp.tileSize, gp.tileSize);
		right1 = setup("/player/boy_right_1", gp.tileSize, gp.tileSize);
		right2 = setup("/player/boy_right_2", gp.tileSize, gp.tileSize);
	}

	public void getPlayerAttackImage() {
		attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize);
		attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize * 2);
		attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize * 2);
		attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize * 2);
		attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize * 2, gp.tileSize);
		attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize * 2, gp.tileSize);
		attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize * 2, gp.tileSize);
		attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize * 2, gp.tileSize);

	}

	public void update() {

		if (attacking == true) {
			attacking();
		} else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true || keyH.entertPressed == true) {

			if (keyH.upPressed == true) {
				direction = "up";

			} else if (keyH.downPressed == true) {
				direction = "down";

			} else if (keyH.leftPressed == true) {
				direction = "left";

			} else if (keyH.rightPressed == true) {
				direction = "right";

			}

			// dodanie wyrkywanie kolizji
			collisionOn = false;
			gp.colChecker.checkTile(this);

			// check objects collision
			int objIndex = gp.colChecker.checkObject(this, true);
			pickUpObject(objIndex);// dodanie metody tu

			// Chceck NPC collison
			int npcIndex = gp.colChecker.checkEtity(this, gp.npc);
			interactNPC(npcIndex);

			// Chceck NPC monster
			int monsterIndex = gp.colChecker.checkEtity(this, gp.monster);
			contacktMonster(monsterIndex);

			// CHECK EVENT
			gp.eHandler.checkEvent();

			// if collision is fasle player can move
			if (collisionOn == false && keyH.entertPressed == false) {
				switch (direction) {
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

			// przenisienie wulaczenia entera
			// reset przycisku
			gp.keyH.entertPressed = false;

			spriteCounter++;

			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}

		// tis is need to be outside of key if statment
		if (invicible == true) {
			invicibleCounter++;
			if (invicibleCounter > 60) {
				invicible = false;
				invicibleCounter = 0;
			}
		}
	}

	public void attacking() {
		spriteCounter++;

		if (spriteCounter <= 5) {
			spriteNum = 1;
		}

		if (spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;
		}

		if (spriteCounter > 25) {
			spriteNum = 1;
			spriteCounter = 0;
			attacking = false;
		}

	}

	// metoda do podnoszenia
	public void pickUpObject(int i) {
		if (i != 999) {
		}
	}

	public void interactNPC(int i) {
		if (gp.keyH.entertPressed == true) {
			if (i != 999) {
				gp.gameState = gp.dialogueState;
				gp.npc[i].speak();
		} else {
				attacking = true;
			}
		}
	}

	public void contacktMonster(int i) {
		if (i != 999) {
			if (invicible == false) {
				life -= 1;
				invicible = true;
			}

		}
	}

	public void draw(Graphics2D g2) {
//		g2.setColor(Color.WHITE);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		int tempScreenX = screenX;
		int tempScreenY = screenY;

		switch (direction) {
		case "up":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = up1;
				}
				if (spriteNum == 2) {
					image = up2;
				}
			}
			if (attacking == true) {
				tempScreenY = screenY - gp.tileSize;
				if (spriteNum == 1) {
					image = attackUp1;
				}
				if (spriteNum == 2) {
					image = attackUp2;
				}
			}
			break;
		case "down":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = down1;
				}
				if (spriteNum == 2) {
					image = down2;
				}
			}
			if (attacking == true) {
				if (spriteNum == 1) {
					image = attackDown1;
				}
				if (spriteNum == 2) {
					image = attackDown2;
				}
			}
			break;
		case "left":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
			}
			if (attacking == true) {
				tempScreenX = screenX - gp.tileSize;
				if (spriteNum == 1) {
					image = attackLeft1;
				}
				if (spriteNum == 2) {
					image = attackLeft2;
				}
			}
			break;
		case "right":
			if (attacking == false) {
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				break;
			}
			if (attacking == true) {
				if (spriteNum == 1) {
					image = attackRight1;
				}
				if (spriteNum == 2) {
					image = attackRight2;
				}
				break;
			}
		}
		// dodanie warunku
		if (invicible == true) {
			// zminie kazda grafie na 70% przejszystosci
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}

		g2.drawImage(image, tempScreenX, tempScreenY, null);

		// RESET DO ALHA PRZYWRUCI GRAFIKE DO NORAMLNEJ
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		// DEBUG TXT
//		g2.setFont(new Font("Arial", Font.PLAIN, 26));
//		g2.setColor(Color.WHITE);
//		g2.drawString("ivicible:" + invicibleCounter, 10, 400);

	}
}
