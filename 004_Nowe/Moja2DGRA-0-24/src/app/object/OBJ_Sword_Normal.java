package app.object;

import app.entity.Entity;
import app.panele.GamePanel;

public class OBJ_Sword_Normal  extends Entity{

	public OBJ_Sword_Normal(GamePanel gp) {
		super(gp);
		
		name = "Normale Sword";
		down1 = setup("/objects/sword_normal", gp.tileSize, gp.tileSize);
		attackValue = 4;
	}

}
