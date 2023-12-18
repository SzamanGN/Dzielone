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
		
		int i = 0;
		
		gp.monster[i]= new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 21;
		gp.monster[i].worldY = gp.tileSize * 38;
		i++;
		
		gp.monster[i]= new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 23;
		gp.monster[i].worldY = gp.tileSize * 42;
		i++;
		
		
		gp.monster[i]= new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 24;
		gp.monster[i].worldY = gp.tileSize * 37;
		i++;
		
		gp.monster[i]= new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 34;
		gp.monster[i].worldY = gp.tileSize * 42;
		i++;
		
		gp.monster[i]= new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize * 38;
		gp.monster[i].worldY = gp.tileSize * 42;
		i++;
		
		
	}
}
