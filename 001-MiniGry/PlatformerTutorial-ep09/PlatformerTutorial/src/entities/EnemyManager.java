package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamesteats.Playing;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstans.*;
public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] crabbyArr;
	private ArrayList<Crabby> crabbies;

	public EnemyManager(Playing playing) {
		this.playing = playing;
		crabbies = new ArrayList<Crabby>();
		loadEnemyImgs();
		addEnemies();
		
	}
	
	private void addEnemies() {
		crabbies = LoadSave.getCrabs();
		System.out.println("Size of crabs : " + crabbies.size());
	}

	public void update(int[][] lvlData) {
		for(Crabby c : crabbies)
			c.update(lvlData);
	}
	
	public void draw(Graphics g, int xLevelOffset) {
		drawCrabs(g, xLevelOffset);
	}

	private void drawCrabs(Graphics g, int xLevelOffset) {
		for(Crabby c : crabbies) {
			g.drawImage(crabbyArr[c.getEnemyState()][c.getAniIndex()],
					(int) c.getHitbox().x - xLevelOffset - CRABBY_DRAFOFFSET_X,
					(int) c.getHitbox().y - CRABBY_DRAFOFFSET_Y,
					CRABBY_WIDTH,
					CRABBY_HEIGHT,
					null);
			//c.drawHitbox(g, xLevelOffset);
		}
	}

	private void loadEnemyImgs() {
		
		crabbyArr = new BufferedImage[5][9];
		BufferedImage tmp = LoadSave.GetSpriteAtlas(LoadSave.CRABBY_SPRITE);
		for(int j = 0; j < crabbyArr.length; j++) 
			for(int i = 0; i < crabbyArr[j].length; i++) 
				crabbyArr[j][i] = tmp.getSubimage(
						i * CRABBY_WIDTH_DEFAULT,
						j * CRABBY_HEIGHT_DEFAULT,
						CRABBY_WIDTH_DEFAULT,
						CRABBY_HEIGHT_DEFAULT);

	}
}
