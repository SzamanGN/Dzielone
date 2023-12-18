package app.narzedzia;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import app.entity.Entity;
import app.object.OBJ_Heart;
import app.panele.GamePanel;

public class UI {

	public GamePanel gp;
	public Graphics2D g2;
	public Font arial_40, arial_80B, pusriaB;
	// dodanie obrazkow zycia
	public BufferedImage heart_full, heart_half, heart_blank;
	//doanie widomosci 
	public boolean messageOn = false;
//	public String message = "";
//	public int mesageCounter = 0;
	public ArrayList<String> message =  new ArrayList<>();
	public ArrayList<Integer> messageCounter = new ArrayList<>();;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	public int titleScreenState = 0; // 0 is the firest screen , 1 is teh 2 screen
	public int slotCol = 0;
	public int slotRow = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		InputStream is = getClass().getResourceAsStream("/font/Purisa Bold.ttf");
		try {
			pusriaB = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arial_80B = new Font("Arial", Font.BOLD, 80);
		//OBJ_Key key = new OBJ_Key(gp);
		//keyImage = key.image;
		
		// CREAT HUD OBJECT
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
		
		
	}
	
	public void addMessage(String text) {
//		message = text;
//		messageOn = true;
		
		message.add(text);
		messageCounter.add(0);
		
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(pusriaB);
		g2.setColor(Color.WHITE);
		
		// Title state
		if(gp.gameState == gp.titleState) {
			drawTtitleScreen();
		}
		// PLAY STATE
		if(gp.gameState == gp.playState) {
			// do playStaff:
			// zycie
			drawPlayerLife();
			drawMessage();
		}
		// PUASE STATE
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		// DIALOG STATE
		if(gp.gameState == gp.dialogueState) {
			drawPlayerLife();
			drawDialogueScreen();
		}	
		//CHRACTER STATE
		if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory();
		}
	}
	
	public void drawPlayerLife() {
		// testowy parametr do sprawdzenia
		//gp.player.life = 3;
		// DRAW BLANK HEART
		int x = gp.tileSize / 2;
		int y = gp.tileSize / 2;
		int i = 0;
		// DRAW MAX LIFE
		while(i < gp.player.maxLife / 2) {
			g2.drawImage(heart_blank, x, y, null);
			i++;
			x += gp.tileSize;
		}
		
		// RESET
		x = gp.tileSize / 2;
		y = gp.tileSize / 2;
		i = 0;
		
		// DRAW CURRENT LIFE
		while(i < gp.player.life) {
			g2.drawImage(heart_half, x, y, null);
			i++;
			if( i < gp.player.life) {
				g2.drawImage(heart_full, x, y, null);
			}
			i++;
			x += gp.tileSize;
		}
	}
	
	public void drawMessage() {
		// kordynaty wiadomosci 
		int messageX = gp.tileSize;
		int messageY = gp.tileSize * 4;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20f));
		
		for(int i = 0; i < message.size();i ++) {
			if(message.get(i) != null) {
				g2.setColor(Color.BLACK);
				g2.drawString(message.get(i), messageX + 2, messageY + 2);
				g2.setColor(Color.WHITE);
				g2.drawString(message.get(i), messageX, messageY);
				
				int counter = messageCounter.get(i) + 1;// msessage counter ++
				messageCounter.set(i, counter);
				messageY += 50;
				// dodanie znikniecia po czasie 
				if(messageCounter.get(i) > 180) {
					message.remove(i);
					messageCounter.remove(i);
				}
				
			}
		}
		
	}
	
	public void drawTtitleScreen() {
		
		if(titleScreenState == 0) {
			
			// title name
			g2.setColor(new Color(0, 0, 0)); // tlo zmiana koloru
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
			String text = "Moja 2D przygoda";
			int x = getXforCenteredText(text);
			int y = gp.tileSize * 3;
			// shadow do napisow
			g2.setColor(Color.GRAY);
			g2.drawString(text, x + 5, y + 5);
			// main color
			g2.setColor(Color.WHITE);
			g2.drawString(text, x, y);
			
			//blue boy image
			x = gp.screenWidth / 2 - (gp.tileSize * 2) /2;
			y += gp.tileSize * 2;
			g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
			
			// menu
			// new game
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
			text = "NEW GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize * 3;
			g2.drawString(text, x, y);
			// strzalka wyboru
			if(commandNum == 0) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			// load game
			text = "LOAD GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize * 1;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			// QUIT
			text = "QUIT";
			x = getXforCenteredText(text);
			y += gp.tileSize * 1;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x - gp.tileSize, y);
			}	
		} else if (titleScreenState == 1) {
			// class selection screen
			g2.setColor(Color.WHITE);
			g2.setFont(g2.getFont().deriveFont(42F));
			
			String text = "Select you class!";
			int x = getXforCenteredText(text);
			int y = gp.tileSize * 2;
			g2.drawString(text, x, y);
			
			text = "Fighter";
			x = getXforCenteredText(text);
			y += gp.tileSize * 2;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			
			text = "Thief";
			x = getXforCenteredText(text);
			y += gp.tileSize* 2;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			
			text = "Sorcer";
			x = getXforCenteredText(text);
			y += gp.tileSize* 2;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			
			text = "Back";
			x = getXforCenteredText(text);
			y += gp.tileSize* 2;
			g2.drawString(text, x, y);
			if(commandNum == 3) {
				g2.drawString(">", x - gp.tileSize, y);
			}
		}

		
	}
	
	public void drawPauseScreen() {
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80));
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight /2;
		
		g2.drawString(text, x, y);
	}
	
	public void drawDialogueScreen() {
		// window
		int x = gp.tileSize * 2;
		int y = gp.tileSize / 2;
		int widht = gp.screenWidth - (gp.tileSize * 4);
		int height = gp.tileSize * 4;
		drawSubWindow(x, y, widht, height);
	
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
		
	}
	
	public void drawCharacterScreen() {
		// CREATA A FRAME
		final int frameX = gp.tileSize;
		final int frameY = gp.tileSize;
		final int frameWidth = gp.tileSize * 5;
		final int frameHeight = gp.tileSize * 10;
		// wywwolanie metody rysowaania
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		// TEXT
		g2.setColor(Color.WHITE);
		g2.setFont(g2.getFont().deriveFont(20f));
		//g2.setFont(arial_40);
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 35;
		
		// NAMES
		g2.drawString("Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Life", textX, textY);
		textY += lineHeight;
		g2.drawString("Strenght", textX, textY);
		textY += lineHeight;
		g2.drawString("Dexterity", textX, textY);
		textY += lineHeight;
		g2.drawString("AttaCK", textX, textY);
		textY += lineHeight;
		g2.drawString("Defense", textX, textY);
		textY += lineHeight;
		g2.drawString("Exp", textX, textY);
		textY += lineHeight;
		g2.drawString("Next Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Coin", textX, textY);
		textY += lineHeight + 20;
		g2.drawString("Weapon", textX, textY);
		textY += lineHeight + 15;
		g2.drawString("Shield", textX, textY);
		textY += lineHeight;
		
		// VALUE
		int taliX = (frameX + frameWidth) - 30;
		// RESET TEXT Y
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.strenght);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.dexterity);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.attack);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.defense);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.exp);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.nextLevelExp);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.coin);
		textX = getXforAllghtToRightText(value, taliX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		// dodanie obrazkow miecza i tarczy
		// miecz
		g2.drawImage(gp.player.currentWeapon.down1, taliX - gp.tileSize, textY - 14, null);
		textY += gp.tileSize;
		// tarcza
		g2.drawImage(gp.player.currentShield.down1, taliX - gp.tileSize, textY - 14, null);
		textY += gp.tileSize;
		
		
	}
	
	public void drawInventory() {
		// FRAME SLOT
		int frameX = gp.tileSize * 9;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize * 6;
		int frameHeight = gp.tileSize * 5;
		drawSubWindow(frameX, frameY,frameWidth, frameHeight);
		
		//SLOT
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		
		// DRAW PLAYER ITEMS
		for(int i = 0; i < gp.player.invetory.size(); i++) {
			g2.drawImage(gp.player.invetory.get(i).down1, slotX, slotY, null);
			
			slotX += gp.tileSize;
			// czas 16:50
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXstart;
				slotY += gp.tileSize;
			}
			
		}
		
		// CURSOR
		int cursorX = slotXstart + (gp.tileSize * slotCol);
		int cursorY = slotY + (gp.tileSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		
		// DRAW CURSOR
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(3)); // zmniejszenie obwudki
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
		
		
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0, 0, 0, 210);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, width - 10, height- 10, 25, 25);
	}
	
	public int getXforCenteredText(String text) {
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth /2 - lenght /2;
		return x;
	}
	
	public int getXforAllghtToRightText(String text, int tailX) {
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = tailX - lenght;
		return x;
	}
}
