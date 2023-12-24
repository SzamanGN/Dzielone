package app.entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import app.narzedzia.UtilityTool;
import app.object.OBJ_Fireall;
import app.object.OBJ_Key;
import app.object.OBJ_Rock;
import app.object.OBJ_Shield_Wood;
import app.object.OBJ_Sword_Normal;
import app.panele.GamePanel;
import app.sterowanie.KeyHandler;

public class Player extends Entity {

	public KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	public int standCounter = 0;
	public boolean attackCanceled = false;
	public ArrayList<Entity> invetory = new ArrayList<>();
	public final int maxInventorySize = 20;

	public Player(GamePanel gp, KeyHandler keyH) {

		super(gp);
		this.gp = gp;
		this.keyH = keyH;

		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		// SOLID AREA
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		// ATTACK AREA
//		attackArea.width = 36;
//		attackArea.height = 36;

		steDefaultValues();
		getPlayerImage();
		getPlayerAttackImage();
		setItems();
	}

	public void steDefaultValues() {
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
//		worldX = gp.tileSize * 10;
//		worldY = gp.tileSize * 13;

		speed = 4;
		direction = "down";

		// PLAYER STATUS
		level = 1;
		maxLife = 6;
		life = maxLife;
		maxMana = 4;
		mana = maxMana;
		ammo = 10;
		strenght = 1; // The more strnght he has , the more damage he give
		dexterity = 1;// The more dextrity he has, les damge recives
		exp = 0;
		nextLevelExp = 5;
		coin = 0;
		currentWeapon = new OBJ_Sword_Normal(gp);
		currentShield = new OBJ_Shield_Wood(gp);
		// dodanie ognistej kuli
		projectile = new OBJ_Fireall(gp);
		// projectile = new OBJ_Rock(gp);
		attack = getAttack();// The total attack value is decided by strenght weapon
		defense = getDefense();// The total defnese value is decided by dexterity and sheald
	}

	// metoda do ustawienia inwentrzu
	public void setItems() {
		invetory.add(currentWeapon);
		invetory.add(currentShield);
		invetory.add(new OBJ_Key(gp));

	}

	// metoda do sprawdzenia ataku
	public int getAttack() {
		attackArea = currentWeapon.attackArea;
		return attack = strenght * currentWeapon.attackValue;
	}

	// metoda do sprawdzenia obrony
	public int getDefense() {
		return defense = dexterity * currentShield.defenseValue;
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

		// dodanie warunokow
		if (currentWeapon.type == type_sword) {

			attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize * 2);
			attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize * 2);
			attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize * 2);
			attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize * 2);
			attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize * 2, gp.tileSize);
			attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize * 2, gp.tileSize);
			attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize * 2, gp.tileSize);
			attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize * 2, gp.tileSize);
		}

		if (currentWeapon.type == type_axe) {

			attackUp1 = setup("/player/boy_axe_up_1", gp.tileSize, gp.tileSize * 2);
			attackUp2 = setup("/player/boy_axe_up_2", gp.tileSize, gp.tileSize * 2);
			attackDown1 = setup("/player/boy_axe_down_1", gp.tileSize, gp.tileSize * 2);
			attackDown2 = setup("/player/boy_axe_down_2", gp.tileSize, gp.tileSize * 2);
			attackLeft1 = setup("/player/boy_axe_left_1", gp.tileSize * 2, gp.tileSize);
			attackLeft2 = setup("/player/boy_axe_left_2", gp.tileSize * 2, gp.tileSize);
			attackRight1 = setup("/player/boy_axe_right_1", gp.tileSize * 2, gp.tileSize);
			attackRight2 = setup("/player/boy_axe_right_2", gp.tileSize * 2, gp.tileSize);
		}

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
			
			// CHECK INTERACTIVE COLISION TILE
			int iTileIndex = gp.colChecker.checkEtity(this, gp.iTile);
			
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

			if (keyH.entertPressed == true && attackCanceled == false) {
				gp.playSE(7);
				attacking = true;
				spriteCounter = 0;
			}
			attackCanceled = false;

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

		// dodanie fireball
		if (gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30
				&& projectile.haveResource(this) == true) {

			// SET DEFALT USER PARAMETERS
			projectile.set(worldX, worldY, direction, true, this);

			// SUBSTRACK THE COS MANA AMONITION ITD
			projectile.subtrackResource(this);

			// ADD IT TO THE LIST
			gp.projectileList.add(projectile);
			// resetowanie licznika strzelania
			shotAvailableCounter = 0;

			// dodanie efektu
			gp.playSE(10);
		}

		// tis is need to be outside of key if statment
		if (invicible == true) {
			invicibleCounter++;
			if (invicibleCounter > 60) {
				invicible = false;
				invicibleCounter = 0;
			}
		}
		// doanie licznika strzalu aby nie moc strzelac za szybbko
		if (shotAvailableCounter < 30) {
			shotAvailableCounter++;
		}
		
		// sprawdzenie zycia gracza
		
		if(life > maxLife) {
			life = maxLife;
		}
		// sprawdzenie many
		if(mana > maxMana) {
			mana = maxMana;
		}

	}

	public void attacking() {
		spriteCounter++;

		if (spriteCounter <= 5) {
			spriteNum = 1;
		}

		if (spriteCounter > 5 && spriteCounter <= 25) {
			spriteNum = 2;

			// SAVE TO CURRENT worldX, wolrdY, solidArea
			int currentWorldX = worldX;
			int currentWorldY = worldY;
			int solidAreaWidth = solidArea.width;
			int solidAreaHight = solidArea.height;

			// Adjust player,s sworldX/y for the attack
			switch (direction) {
			case "up":
				worldY -= attackArea.height;
				break;
			case "down":
				worldY += attackArea.height;
				break;
			case "left":
				worldX -= attackArea.width;
				break;
			case "right":
				worldX += attackArea.width;
				break;
			}

			// attackArea become solidArea
			solidArea.width = attackArea.width;
			solidArea.height = attackArea.height;
			// chceck monster colission wht tje uopdated worldX , wolrdY and solicdArea
			int monsterIndex = gp.colChecker.checkEtity(this, gp.monster);
			damageMonster(monsterIndex, attack);
			// dodanie niszczenia obiktow np drzewa
			int iTileIndex = gp.colChecker.checkEtity(this,	gp.iTile);
			damageInteractiveTile(iTileIndex);

			// After chccking collision retore the orginal date
			worldX = currentWorldX;
			worldY = currentWorldY;
			solidArea.width = solidAreaWidth;
			solidArea.height = solidAreaHight;

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
			// PICK ONLY ITEMS
			if (gp.obj[i].type == type_pickupOnly) {
				gp.obj[i].use(this);
				gp.obj[i] = null;
			} else {
				// INVETORY ITEMS
				String text;
				// sprawdzenie czy inventarz jest pelny i ma miejsce
				if (invetory.size() != maxInventorySize) {
					invetory.add(gp.obj[i]);
					gp.playSE(1);
					text = "Go a " + gp.obj[i].name + "!";
				} else {
					text = "You cannot carry any more!";
				}
				gp.ui.addMessage(text);
				gp.obj[i] = null;
			}
		}

	}

	public void interactNPC(int i) {
		if (gp.keyH.entertPressed == true) {
			if (i != 999) {
				attackCanceled = true;
				gp.gameState = gp.dialogueState;
				gp.npc[i].speak();
			}
		}
	}

	public void contacktMonster(int i) {
		if (i != 999) {
			if (invicible == false && gp.monster[i].dying == false) {
				// jak gracz otrzymuje orbazenia dzwiek
				gp.playSE(6);
				// dodanie ataku potwora
				int damage = gp.monster[i].attack - defense;
				if (damage < 0) {
					damage = 0;
				}
				life -= damage;
				invicible = true;
			}

		}
	}

	public void damageMonster(int i, int attack) {

		if (i != 999) {
			if (gp.monster[i].invicible == false) {
				// jak gracz tafi potwora dzwiek
				gp.playSE(5);
				// dodanie ataku potwora
				int damage = attack - gp.monster[i].defense;
				if (damage < 0) {
					damage = 0;
				}

				gp.monster[i].life -= damage;
				// dodanie wiadomosci o zadawaniu dmg
				gp.ui.addMessage(damage + " damage!");
				gp.monster[i].invicible = true;
				// dodanie reakcji na atak potwora
				gp.monster[i].damageReaction();
				


				if (gp.monster[i].life <= 0) {
					gp.monster[i].dying = true;
					gp.ui.addMessage("Killed the " + gp.monster[i].name + "!");
					gp.ui.addMessage("Exp + " + gp.monster[i].exp);
					exp += gp.monster[i].exp;
					chceckLevelUp();
				}
			}
		}

	}
	
	public void damageInteractiveTile(int i) {
		if(i != 999 && gp.iTile[i].destructible == true && gp.iTile[i].isCorrectItem(this) == true
				&& gp.iTile[i].invicible == false) {
			
			gp.iTile[i].playSE();
			gp.iTile[i].life--;
			gp.iTile[i].invicible = true;
			
			//dodanie generatora particle
			generateParticle(gp.iTile[i], gp.iTile[i]);
			
			if(gp.iTile[i].life == 0) {
				gp.iTile[i] = gp.iTile[i].getDestroyedForm();
			}
		}
	}

	public void chceckLevelUp() {
		if (exp > nextLevelExp) {
			level++;
			nextLevelExp = nextLevelExp * 2;
			maxLife += 2;
			strenght++;
			dexterity++;
			attack = getAttack();
			defense = getDefense();
			// dodanie dzwieku do levelu
			gp.playSE(8);
			// wyswietlenie tekstu
			gp.gameState = gp.dialogueState;
			gp.ui.currentDialogue = "You are level " + level + " now!\n" + "You fell stonger!";

		}
	}

	public void selectItem() {

		int itemIndex = gp.ui.getItemIndexOnSlot();
		// pobranie zaznaczonego itemu
		if (itemIndex < invetory.size()) {
			Entity selectedItem = invetory.get(itemIndex);

			if (selectedItem.type == type_sword || selectedItem.type == type_axe) {
				// wybranie broni
				currentWeapon = selectedItem;
				attack = getAttack();
				getPlayerAttackImage();
			}
			// wybranie tarczy dla gracza
			if (selectedItem.type == type_shield) {
				// wybrania tarcza
				currentShield = selectedItem;
				defense = getDefense();
			}
			// Napoj jednokrotnego uzycia
			if (selectedItem.type == type_consumable) {
				selectedItem.use(this);
				invetory.remove(itemIndex);
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
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
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
