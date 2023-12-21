package app.object;

import app.entity.Entity;
import app.panele.GamePanel;

public class OBJ_ManaCrystal extends Entity {

	public GamePanel gp;
	
	public OBJ_ManaCrystal(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Mana Crystal";
		image = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);
		image2 = setup("/objects/manacrystal_blank", gp.tileSize, gp.tileSize);	
		
	}

}
