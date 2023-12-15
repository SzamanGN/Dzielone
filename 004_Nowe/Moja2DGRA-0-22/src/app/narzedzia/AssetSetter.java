package app.narzedzia;

import app.entity.NPC_OldMan;
import app.monster.MON_GreenSlime;
import app.panele.GamePanel;

public class AssetSetter {
// klasa do ustawiania obikotw na mapie
	
	public GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		// dodawanie objetkow	
	}
	
	public void setNPC() {
		// dodawanie botow
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize * 21;
		gp.npc[0].worldY = gp.tileSize * 21;
		
//		gp.npc[0] = new NPC_OldMan(gp);
//		gp.npc[0].worldX = gp.tileSize * 9;
//		gp.npc[0].worldY = gp.tileSize * 10;
		
	}
	
	public void setMonster() {
		
		gp.monster[0]= new MON_GreenSlime(gp);
		gp.monster[0].worldX = gp.tileSize * 23;
		gp.monster[0].worldY = gp.tileSize * 36;
		
		gp.monster[1]= new MON_GreenSlime(gp);
		gp.monster[1].worldX = gp.tileSize * 23;
		gp.monster[1].worldY = gp.tileSize * 37;
		
//		gp.monster[0]= new MON_GreenSlime(gp);
//		gp.monster[0].worldX = gp.tileSize * 11;
//		gp.monster[0].worldY = gp.tileSize * 10;
//		
//		gp.monster[1]= new MON_GreenSlime(gp);
//		gp.monster[1].worldX = gp.tileSize * 11;
//		gp.monster[1].worldY = gp.tileSize * 11;
		
		
	}
}