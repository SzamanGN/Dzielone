package app.narzedzia;

import java.awt.Rectangle;

import app.panele.GamePanel;

public class EventHandler {

	public GamePanel gp;
	public Rectangle eventRect;
	public int eventRectDefaultX, eventRectDefaultY;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect =  new Rectangle();
		eventRect.x = 23;
		eventRect.y = 23;
		eventRect.width = 2;
		eventRect.height = 2;
		eventRectDefaultX = eventRect.x;
		eventRectDefaultY = eventRect.y;
	}
	
	public void checkEvent() {
		
//		// dotarl do puntu gdzie ubywa zycie
//		if(hit(27, 16, "right") == true) {
//			// event happen
//			damagetPit(gp.dialogueState);
//		}
		
		// TELEPORT 
		
		// dotarl do puntu gdzie ubywa zycie
		if(hit(27, 16, "right") == true) {
			// event happen
			teleport(gp.dialogueState);
		}
		// dotarcie do punktu gdzie zycie jest dodawane
		if(hit(23, 12, "up") == true) {
			healingPool(gp.dialogueState);
		}
		
		
	}
	
	public boolean hit(int eventCol, int eventRow, String regDirection) {
		
		boolean hit =  false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect.x = eventCol * gp.tileSize + eventRect.x;
		eventRect.y = eventRow * gp.tileSize + eventRect.y;
		
		if(gp.player.solidArea.intersects(eventRect)) {
			if(gp.player.direction.contentEquals(regDirection) || regDirection.contentEquals("any")) {
				hit = true;
			}
		}
		// reset 
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect.x = eventRectDefaultX;
		eventRect.y = eventRectDefaultY;
		return hit;
	}
	
	public void teleport(int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "Teleport";
		gp.player.worldX = gp.tileSize * 37;
		gp.player.worldY = gp.tileSize * 10;
	}
	
	public void damagetPit(int gameState) {
		gp.gameState = gameState;
		gp.ui.currentDialogue = "You are in to a pit";
		gp.player.life -= 1;
	}
	
	public void healingPool(int gameState) {
		if(gp.keyH.entertPressed == true) {
			gp.gameState = gameState;
			gp.ui.currentDialogue = "You dring the water. \n You life benn recovery.";
			gp.player.life = gp.player.maxLife;
		}
	}
	
	
}
