package tiles_interactive;

import app.entity.Entity;
import app.panele.GamePanel;

public class Interactivetile extends Entity {

	public GamePanel gp;
	public boolean destructible = false;
	
	public Interactivetile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}
	
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;	
		return isCorrectItem;
	}
	
	public void playSE() {
		
	}
	
	public Interactivetile getDestroyedForm() {
		Interactivetile tile = null;
		return tile;		
	}
	
	public void update() {
		if (invicible == true) {
			invicibleCounter++;
			if (invicibleCounter > 20) {
				invicible = false;
				invicibleCounter = 0;
			}
		}
	}

}
