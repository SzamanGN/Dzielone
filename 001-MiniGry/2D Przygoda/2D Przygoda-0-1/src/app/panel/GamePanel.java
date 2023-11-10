package app.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	// screem settings
	final int orginalTileSize = 16; // 16x16
	final int scale = 3;

	final int tileSize = orginalTileSize * scale; //48*48
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth =  tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576
	private Thread gameThread;
	
	public GamePanel(){
		this.setPreferredSize(new Dimension (screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		}
	
	public void StartGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
