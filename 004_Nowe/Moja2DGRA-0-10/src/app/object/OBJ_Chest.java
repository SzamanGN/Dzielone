package app.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import app.panele.GamePanel;

public class OBJ_Chest extends SuperObject{
	
	public GamePanel gp;
	
	public OBJ_Chest(GamePanel gp) {
		name = "Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.fillInStackTrace();
		}

	}
}
