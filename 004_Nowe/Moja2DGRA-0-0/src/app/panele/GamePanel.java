package app.panele;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	// SCREEN SETTINGS
	private final int orginalTileSize = 16; // 16x16 tile
	private final int scale = 3;
	
	private final int tileSize = orginalTileSize * scale;
	private final int maxScreenCol = 16;
	private final int maxScreenRow = 12;
	private final int screenWidth = tileSize * maxScreenCol; // 768
	private final int screenHeight = tileSize * maxScreenRow; // 
	
	private Thread gameThread;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth , screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
	}
	
	public void startGameThread() {
		gameThread =  new Thread(this);
		gameThread.start();
	}


	@Override
	public void run() {
		
	}

}
