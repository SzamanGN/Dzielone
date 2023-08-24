package app.okna;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import app.panele.GamePanel;

public class GameWindow extends JFrame {

	private JFrame jFrame;

	public GameWindow(GamePanel gamePanel) {
		jFrame = new JFrame();
		jFrame.setTitle("Platform-01");
		
		//jFrame.setSize(400, 400);
		jFrame.add(gamePanel);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		//jFrame.setLocationRelativeTo(null);
		jFrame.pack();
		jFrame.addWindowFocusListener(new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				//System.out.println("Bay bay");
				gamePanel.getGame().windowsFocusLost();
				
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jFrame.setVisible(true);
	}

}
