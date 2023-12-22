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
import tiles_interactive.IT_DryTree;

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
	
	public void setInetractiveTile() {
		
		int i = 0;
		//01 drzewa z mozliwoscia sciecia
		gp.iTile[i] = new IT_DryTree(gp, 27, 12);
//		gp.iTile[i].worldX = gp.tileSize * 27;  // zmina mteody i parametry przeniesione wyzje !!
//		gp.iTile[i].worldY = gp.tileSize * 12;
		i++;
		//02
		gp.iTile[i] = new IT_DryTree(gp, 28, 12);
		i++;
		// 03
		gp.iTile[i] = new IT_DryTree(gp, 29, 12);
		i++;
		//04
		gp.iTile[i] = new IT_DryTree(gp, 30, 12);
		i++;
		//05
		gp.iTile[i] = new IT_DryTree(gp, 31, 12);
		i++;
		//06
		gp.iTile[i] = new IT_DryTree(gp, 32, 12);
		i++;
		// 07
		gp.iTile[i] = new IT_DryTree(gp, 33, 12);
		i++;
		
		
		
		//dodatkowe drzewa
		gp.iTile[i] = new IT_DryTree(gp, 30, 20);
		i++;
		// 03
		//gp.iTile[i] = new IT_DryTree(gp, 30, 21);
		//i++;
		//04
		gp.iTile[i] = new IT_DryTree(gp, 30, 22);
		i++;
		//05
		gp.iTile[i] = new IT_DryTree(gp, 20, 20);
		i++;
		//06
		gp.iTile[i] = new IT_DryTree(gp, 20, 21);
		i++;
		// 07
		gp.iTile[i] = new IT_DryTree(gp, 20, 22);
		i++;
		
		gp.iTile[i] = new IT_DryTree(gp, 22, 24);
		i++;
		//06
		gp.iTile[i] = new IT_DryTree(gp, 23, 24);
		i++;
		// 07
		gp.iTile[i] = new IT_DryTree(gp, 24, 24);
		i++;
		
	}
}