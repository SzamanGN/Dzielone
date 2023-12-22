package app.narzedzia;

import app.entity.NPC_OldMan;
import app.monster.MON_GreenSlime;
import app.object.OBJ_Axe;
import app.object.OBJ_Coin_Bronze;
import app.object.OBJ_Heart;
import app.object.OBJ_Key;
import app.object.OBJ_ManaCrystal;
import app.object.OBJ_Potion_Red;
import app.object.OBJ_Shield_Blue;
import app.panele.GamePanel;

public class AssetSetter {
// klasa do ustawiania obikotw na mapie
	
	public GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		// dodawanie objetkow	
		int i = 0;
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize * 21;
		gp.obj[i].worldY = gp.tileSize * 23;
		i++;
		
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize * 21;
		gp.obj[i].worldY = gp.tileSize * 19;
		i++;
		
		gp.obj[i] = new OBJ_Coin_Bronze(gp);
		gp.obj[i].worldX = gp.tileSize * 26;
		gp.obj[i].worldY = gp.tileSize * 21;
		i++;
		
		gp.obj[i] = new OBJ_Axe(gp);
		gp.obj[i].worldX = gp.tileSize * 32;
		gp.obj[i].worldY = gp.tileSize * 21;
		i++;
		
		gp.obj[i] = new OBJ_Shield_Blue(gp);
		gp.obj[i].worldX = gp.tileSize * 35;
		gp.obj[i].worldY = gp.tileSize * 21;
		i++;
		
		gp.obj[i] = new OBJ_Potion_Red(gp);
		gp.obj[i].worldX = gp.tileSize * 22;
		gp.obj[i].worldY = gp.tileSize * 27;
		i++;
		
		gp.obj[i] = new OBJ_Heart(gp);
		gp.obj[i].worldX = gp.tileSize * 22;
		gp.obj[i].worldY = gp.tileSize * 29;
		i++;
		
		gp.obj[i] = new OBJ_ManaCrystal(gp);
		gp.obj[i].worldX = gp.tileSize * 22;
		gp.obj[i].worldY = gp.tileSize * 31;
		i++;
		
		
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
