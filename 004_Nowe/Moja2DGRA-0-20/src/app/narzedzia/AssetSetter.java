package app.narzedzia;

import app.entity.NPC_OldMan;
import app.object.OBJ_Door;
import app.panele.GamePanel;

public class AssetSetter {
// klasa do ustawiania obikotw na mapie
	
	public GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		// dodawanie objetkow
		gp.obj[0] = new OBJ_Door(gp);
		gp.obj[0].worldX = gp.tileSize * 21;
		gp.obj[0].worldY = gp.tileSize * 22;
		
		gp.obj[1] = new OBJ_Door(gp);
		gp.obj[1].worldX = gp.tileSize * 23;
		gp.obj[1].worldY = gp.tileSize * 25;
		
	}
	
	public void setNPC() {
		// dodawanie botow
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize * 21;
		gp.npc[0].worldY = gp.tileSize * 21;
		
		gp.npc[1] = new NPC_OldMan(gp);
		gp.npc[1].worldX = gp.tileSize * 11;
		gp.npc[1].worldY = gp.tileSize * 21;
		
		gp.npc[2] = new NPC_OldMan(gp);
		gp.npc[2].worldX = gp.tileSize * 31;
		gp.npc[2].worldY = gp.tileSize * 21;
		
		gp.npc[2] = new NPC_OldMan(gp);
		gp.npc[2].worldX = gp.tileSize * 21;
		gp.npc[2].worldY = gp.tileSize * 11;
		
		gp.npc[3] = new NPC_OldMan(gp);
		gp.npc[3].worldX = gp.tileSize * 21;
		gp.npc[3].worldY = gp.tileSize * 31;
		
	}
}
