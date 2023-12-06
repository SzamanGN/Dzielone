package app.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import app.panele.GamePanel;

public class TileManager {
	
	private GamePanel gp;
	private Tile[] tile;
	private int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum =  new int [gp.maxScreenCol][gp.maxScreenRow];
		
		getTileImage();
		loadMap("/maps/map01.txt");
	}
	
	public void  getTileImage() {
		
		try {
			tile[0] =  new Tile();
			tile[0].image = ImageIO.read(getClass().getResource("/tiles/grass.png"));
			
			tile[1] =  new Tile();
			tile[1].image = ImageIO.read(getClass().getResource("/tiles/wall.png"));
			
			tile[2] =  new Tile();
			tile[2].image = ImageIO.read(getClass().getResource("/tiles/water.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filepath) {
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				String line =  br.readLine();
				
				while(col < gp.maxScreenCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					
					mapTileNum[col][row] = num;
					col++;
				} 
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();			
		} catch(Exception e) {
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		//pokazanie na tle
//		g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
			
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x , y, gp.tileSize, gp.tileSize, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
		
	}
	
}
