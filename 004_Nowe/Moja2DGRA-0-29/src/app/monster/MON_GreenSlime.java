package app.monster;

import java.util.Random;

import app.entity.Entity;
import app.panele.GamePanel;

public class MON_GreenSlime extends Entity {

	public GamePanel gp;

	public MON_GreenSlime(GamePanel gp) {
		super(gp);
		this.gp = gp;

		// ustawnie parametrow
		type = type_monster;
		name = "Green Slime";
		speed = 1;
		maxLife = 4;
		life = maxLife;
		attack = 5;
		defense = 0;
		exp = 2;
		
		
		// ustawnie wymiarow solid
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

		getImage();
		setAction();
	}

	public void getImage() {
		up1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/greenslime_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/greenslime_down_2", gp.tileSize, gp.tileSize);
	}

	public void setAction() {
		actionLockCounter++;

		if (actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; // pick up o number from 1 to 100

			if (i <= 25) {
				direction = "up";
			}

			if (i > 25 && i <= 50) {
				direction = "down";
			}

			if (i > 50 && i <= 75) {
				direction = "left";
			}

			if (i > 75 && i <= 100) {
				direction = "right";
			}

			actionLockCounter = 0;
		}
	}

	public void damageReaction() {
		
		actionLockCounter = 0;
		direction = gp.player.direction;
		
	}
}
