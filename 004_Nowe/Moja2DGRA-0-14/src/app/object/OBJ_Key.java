package app.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import app.panele.GamePanel;

public class OBJ_Key extends SuperObject {
	
	public GamePanel gp;

	public OBJ_Key(GamePanel gp) {

		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);

		} catch (IOException e) {
			e.fillInStackTrace();
		}
		
	}
}
