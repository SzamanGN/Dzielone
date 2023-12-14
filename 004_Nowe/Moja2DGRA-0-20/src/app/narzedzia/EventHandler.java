package app.narzedzia;

import java.awt.Rectangle;

import app.panele.GamePanel;

public class EventHandler {

	public GamePanel gp;
	public EventRect eventRect[][];
	
	public int previousEventX, previousEventY;
	public  boolean canTouchEvent = true;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect =  new EventRect[gp.maxWorldCol][gp.maxWorldRow];
		
		int col = 0;
		int row = 0;
		
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[col][row] =  new EventRect();
			eventRect[col][row].x = 23;
			eventRect[col][row].y = 23;
			eventRect[col][row].width = 2;
			eventRect[col][row].height = 2;
			eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
			eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
			
			col++;
			
			if(col ==  gp.maxWorldCol) {
				col = 0;
				row++;
			}
		}
	}
	
	public void checkEvent() {
		
		// CHECK IF THE PLAYER IS MORE THAN 1 TILE FROM LAST EVENT
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tileSize) {
			canTouchEvent = true;
		}
		
		if(canTouchEvent == true) {
			
			// dotarl do puntu gdzie ubywa zycie 
			// 1 punkt na mapie
			if(hit(27, 16, "right") == true) {
				// event happen
				damagetPit(27, 16, gp.dialogueState);
			}
			
			// 2 punkt na mapie
			if(hit(23, 19, "any") == true) {
				// event happen
				damagetPit(27, 16, gp.dialogueState);
			}
			
			// TELEPORT 
			
			// dotarl do puntu gdzie ubywa zycie
//			if(hit(27, 16, "right") == true) {
//				// event happen
//				teleport(gp.dialogueState);
//			}
			

			// dotarcie do punktu gdzie zycie jest dodawane
			if(hit(23, 12, "up") == true) {
				healingPool(23, 12, gp.dialogueState);
			}
		}		

		
		
	}
	
	public boolean hit(int col, int row, String regDirection) {
		
		boolean hit =  false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect[col][row].x = col * gp.tileSize + eventRect[col][row].x;
		eventRect[col][row].y = row * gp.tileSize + eventRect[col][row].y;
		
		if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
			if(gp.player.direction.contentEquals(regDirection) || regDirection.contentEquals("any")) {
				hit = true;
				// zmiany w evencie
				previousEventX = gp.player.worldX;
				previousEventY =  gp.player.worldY;
				
			}
		}
		// reset 
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
		eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
		return hit;
	}
	
	public void teleport(int col,int row,int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "Teleport";
		gp.player.worldX = gp.tileSize * 37;
		gp.player.worldY = gp.tileSize * 10;
		
	}
	
	public void damagetPit(int col,int row, int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "You are in to a pit";
		gp.player.life -= 1;
//		eventRect[col][row].eventDone = true;
		canTouchEvent = false;
	}
	
	public void healingPool(int col,int row,int gameState) {
		if(gp.keyH.entertPressed == true) {
			gp.gameState = gameState;
			gp.ui.currentDialogue = "You dring the water. \n You life benn recovery.";
			gp.player.life = gp.player.maxLife;
			eventRect[col][row].eventDone = true;
		}
	}
	
	
}
