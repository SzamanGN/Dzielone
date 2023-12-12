package app.narzedzia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import app.object.OBJ_Key;
import app.panele.GamePanel;

public class UI {

	public GamePanel gp;
	public Graphics2D g2;
	public Font arial_40, arial_80B, pusriaB;
	//doanie widomosci 
	public boolean messageOn = false;
	public String message = "";
	public int mesageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		//arial_40 = new Font("Arial", Font.PLAIN, 40);
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
		
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		g2.setFont(pusriaB);
		g2.setColor(Color.WHITE);
		// ryswoanie statusu
		if(gp.gameState == gp.playState) {
			// do playStaff later
		}
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		if(gp.gameState == gp.dialogueState) {
			drawDialogueScreen();
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
}
