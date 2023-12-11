package app.narzedzia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import app.object.OBJ_Key;
import app.panele.GamePanel;

public class UI {

	public GamePanel gp;
	public Font arial_40, arial_80B;
	public BufferedImage keyImage;
	//doanie widomosci 
	public boolean messageOn = false;
	public String message = "";
	public int mesageCounter = 0;
	public boolean gameFinished = false;
	
	public double playTime;
	public DecimalFormat dFormat = new DecimalFormat("0.00");
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80B = new Font("Arial", Font.BOLD, 80);
		OBJ_Key key = new OBJ_Key(gp);
		keyImage = key.image;
		
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		if(gameFinished == true) {
			
			g2.setFont(arial_40);
			g2.setColor(Color.WHITE);
			
			String text;
			int textLenght;
			int x;
			int y;
			//napis ze znalezion skarb
			text = "You found the  treasuer!";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth /2 - textLenght /2;
			y = gp.screenHeight /2 - (gp.tileSize * 3);
			g2.drawString(text, x, y);
			// finsh time
			text = "You time is: " + dFormat.format(playTime) + "!";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth /2 - textLenght /2;
			y = gp.screenHeight /2 + (gp.tileSize * 4);
			g2.drawString(text, x, y);
			// napis gratulacje 
			g2.setFont(arial_80B);
			g2.setColor(Color.YELLOW);
			text = "Congratuletions!";
			textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth /2 - textLenght /2;
			y = gp.screenHeight /2 + (gp.tileSize * 2);
			g2.drawString(text, x, y);
			//zatzrymanie gry
			gp.gameThread = null;
			
		} else {
			g2.setFont(arial_40);
			g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
			g2.setColor(Color.WHITE);
			g2.drawString("x " + gp.player.hasKey, 74, 65);
			
			// TIME
			playTime += (double) 1/ 60;
			g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 65);
			// message
			if(messageOn == true) {
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
				
				mesageCounter++;
				
				if(mesageCounter > 120) {
					mesageCounter = 0;
					messageOn = false;
				}
			}
		}
		
		
		
	}
}
