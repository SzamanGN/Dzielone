package app.object;

import app.entity.Entity;
import app.entity.Projectile;
import app.panele.GamePanel;

public class OBJ_Rock extends Projectile {
	
	private GamePanel gp;

	public OBJ_Rock(GamePanel gp) {
		super(gp);
		this.gp = gp;

		name = "Rock";
		speed = 8;
		maxLife = 80;
		life = maxLife;
		attack = 2;
		useCost = 1;
		alive = false;
		getImage();
	}

	private void getImage() {

		up1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		up2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		down1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		down2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		right1 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/rock_down_1", gp.tileSize, gp.tileSize);

	}
	
	public boolean haveResource(Entity user) {
		boolean haveResource = false;
		if(user.ammo >= useCost) {
			haveResource = true;
		}
		return haveResource;
	}
	
	public void subtrackResource(Entity user) {
		user.ammo -= useCost;
	}
}
