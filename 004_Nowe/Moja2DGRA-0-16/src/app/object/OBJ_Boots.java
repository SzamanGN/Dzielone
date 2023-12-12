package app.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import app.panele.GamePanel;

public class OBJ_Boots extends SuperObject {
	
	public GamePanel gp;
	
	public OBJ_Boots(GamePanel gp) {
		name = "Boots";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.fillInStackTrace();
		}

	}
}
