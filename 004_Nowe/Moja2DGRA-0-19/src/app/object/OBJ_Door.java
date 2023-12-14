package app.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import app.panele.GamePanel;

public class OBJ_Door extends SuperObject {

	public GamePanel gp;
	public OBJ_Door(GamePanel gp) {
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.fillInStackTrace();
		}
		collision = true;
	}
}
