package app.okna.panele;

import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class PanelEdytoraKafelka extends JPanel {
	
	private Point piksel;
	private int rozmiar;

	public PanelEdytoraKafelka() {
		setBackground(new Color(0, 0, 0));
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				piksel.x = e.getX() / rozmiar;
				piksel.y = e.getY() / rozmiar;
				repaint();
			}
		});
		piksel = new Point(0, 0);
		rozmiar = 10;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// zaznaczanie piksela
		g.setColor(Color.WHITE);
		g.drawRect(
				piksel.x * rozmiar, 
				piksel.y * rozmiar, 
				rozmiar, 
				rozmiar);
	}
	

}
