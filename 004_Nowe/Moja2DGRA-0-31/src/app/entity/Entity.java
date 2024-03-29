package app.entity;

import java.awt.AlphaComposite;
import java.awt.Color;
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
	public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1,
			attackRight2;
	public BufferedImage image, image2, image3;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public String dialogues[] = new String[20];

	// STATE
	public int worldX, worldY;
	public String direction = "down";
	public int spriteNum = 1;
	public int dialogueIndex = 0;
	public boolean collision = false;
	public boolean invicible = false;
	public boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	public boolean hpBarOn = false;

	// COUNTER
	public int spriteCounter = 0;
	public int actionLockCounter = 0;
	public int invicibleCounter = 0;
	public int shotAvailableCounter = 0;
	public int dayingCounter = 0;
	public int hpBarCounter = 0;

	// CHARACTER ATTRIBUTES
	
	public String name;
	public int speed;
	public int maxLife;
	public int life;
	// dodanie parametrow do many
	public int maxMana;
	public int mana;
	public int ammo;
	// dodanie reszty parametrow
	public int level;
	public int strenght;
	public int dexterity;
	public int attack;
	public int defense;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public Entity currentWeapon;
	public Entity currentShield;
	public Projectile projectile;// DO KULI OGNIA

	// ITEM ATTRIUBUTES
	public int value;
	public int attackValue;
	public int defenseValue;
	public String description = "";
	public int useCost;
	
	// TYPE
	public int type; // 0 player, 1 NPC, 2 = Monster
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_monster = 2;
	public final int type_sword = 3;
	public final int type_axe = 4;
	public final int type_shield = 5;
	public final int type_consumable = 6;
	public final int type_pickupOnly = 7;
	

	public Entity(GamePanel gp) {
		this.gp = gp;
	}

	public void setAction() {

	}

	public void damageReaction() {

	}

	public void speak() {
		if (dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}

		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;

		switch (gp.player.direction) {
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
	
	public void use(Entity entity) {
		
	}
	
	public void checkDrop() {
		
	}
	
	public void dropItem(Entity droppedItem) {
		
		for(int i = 0; i < gp.obj.length; i++) {
			if(gp.obj[i] == null) {
				gp.obj[i] = droppedItem;
				gp.obj[i].worldX = worldX; // this is a dead monster X
				gp.obj[i].worldY = worldY;
				break;
			}
		}
	}
	
	


	public void update() {
		setAction();
		collisionOn = false;
		gp.colChecker.checkTile(this);
		gp.colChecker.checkObject(this, false);
		gp.colChecker.checkEtity(this, gp.npc);
		gp.colChecker.checkEtity(this, gp.monster);
		gp.colChecker.checkEtity(this, gp.iTile);
		boolean contactPlayer = gp.colChecker.checkPlayer(this);

		// WYKRYWANIE KONTAKTU
		if (this.type == 2 && contactPlayer == true) {
			damagePlayer(attack);
		}

		// IF COLLISON IS FALSE, PLAYER CANN MOVE
		if (collisionOn == false) {
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

		spriteCounter++;
		if (spriteCounter > 12) {
			if (spriteNum == 1) {
				spriteNum = 2;
			} else if (spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}

		// tis is need to be outside of key if statment
		if (invicible == true) {
			invicibleCounter++;
			if (invicibleCounter > 40) {
				invicible = false;
				invicibleCounter = 0;
			}
		}
		
		// doanie licznika strzalu aby nie moc strzelac za szybbko
		if(shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		
		
		
	}
	
	public void damagePlayer(int attack) {
		if (gp.player.invicible == false) {
			// we can give damge
			// dodanie dzwieku jak potwor dotknie gracza
			gp.playSE(6);
			// dodanie ataku potwora
			int damage = attack - gp.player.defense;
			if (damage < 0) {
				damage = 0;
			}
			gp.player.life -= damage;
			gp.player.invicible = true;
		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;

		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
				&& worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
				&& worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
				&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			switch (direction) {
			case "up":
				if (spriteNum == 1) {
					image = up1;
				}
				if (spriteNum == 2) {
					image = up2;
				}
				break;
			case "down":
				if (spriteNum == 1) {
					image = down1;
				}
				if (spriteNum == 2) {
					image = down2;
				}
				break;
			case "left":
				if (spriteNum == 1) {
					image = left1;
				}
				if (spriteNum == 2) {
					image = left2;
				}
				break;
			case "right":
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				break;
			}

			// MONSTER HP BAR
			if (type == type_monster && hpBarOn == true) {
				// kastujemujemy zycie do double
				double oneScale = (double) gp.tileSize / maxLife;
				double hpBarValue = oneScale * life;
				g2.setColor(new Color(35, 35, 35));
				g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);
				g2.setColor(new Color(255, 0, 30));
				g2.fillRect(screenX, screenY - 15, (int) hpBarValue, 10);
				// inkremetujemy licznik
				hpBarCounter++;

				if (hpBarCounter > 600) {
					hpBarCounter = 0;
					hpBarOn = false;
				}
			}

			// dodanie warunku
			if (invicible == true) {
				hpBarOn = true;
				// resetwpawnie po ataku
				hpBarCounter = 0;
				// zminie kazda grafie na 70% przejszystosci
				changeAlpha(g2, 0.4f);
				// g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
			}

			if (dying == true) {
				dyingAnimation(g2);
			}

			g2.drawImage(image, screenX, screenY, null);

			// RESET DO ALHA PRZYWRUCI GRAFIKE DO
			changeAlpha(g2, 1f);
			// g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		}
	}

	public void dyingAnimation(Graphics2D g2) {

		dayingCounter++;

		int i = 5;

		if (dayingCounter <= i) {
			changeAlpha(g2, 0f);
		}
		if (dayingCounter > i && dayingCounter <= i * 2) {
			changeAlpha(g2, 1f);
		}
		if (dayingCounter > i * 2 && dayingCounter <= i * 3) {
			changeAlpha(g2, 0f);
		}
		if (dayingCounter > i * 3 && dayingCounter <= i * 4) {
			changeAlpha(g2, 1f);
		}
		if (dayingCounter > i * 4 && dayingCounter <= i * 5) {
			changeAlpha(g2, 0f);
		}
		if (dayingCounter > i * 5 && dayingCounter <= i * 6) {
			changeAlpha(g2, 1f);
		}
		if (dayingCounter > i * 6 && dayingCounter <= i * 7) {
			changeAlpha(g2, 0f);
		}
		if (dayingCounter > i * 7 && dayingCounter <= i * 8) {
			changeAlpha(g2, 0f);
		}
		if (dayingCounter > i * 8) {
			//dying = false;
			alive = false;
		}
	}

	public void changeAlpha(Graphics2D g2, float alphaValue) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
	}

	public BufferedImage setup(String imagePath, int width, int height) {

		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;

		try {
			image = ImageIO.read(getClass().getResource(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
