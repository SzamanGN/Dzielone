package app.panele;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import static app.utliz.Constans.playerConstans.*;
import static app.utliz.Constans.Directions.*;

import app.game.Game;
import app.inputs.KeyboardInputs;
import app.inputs.MouseInputs;
import static app.game.Game.*;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private Game game;

	public GamePanel(Game game) {
		mouseInputs = new MouseInputs(this);
		this.game = game;
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
	}

	public void updateGame() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}

	public Game getGame() {
		return game;
	}

}

//	private void updateRectangel() {
//		xDelta += xDir;
//		if(xDelta > 400 || xDelta < 0) {
//			xDir *= -1;
//			color = getRndColor();
//		}
//		
//		
//		yDelta +=  yDir;
//		if(yDelta > 400 || yDelta < 0) {
//			yDir *= -1;
//			color = getRndColor();
//		}
//		
//	}

//	private Color getRndColor() {
//		int r = random.nextInt(255);
//		int g = random.nextInt(255);
//		int b = random.nextInt(255);
//		return new Color(r,b,g);
//	}

//}
