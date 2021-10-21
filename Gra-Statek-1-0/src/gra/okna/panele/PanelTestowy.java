package gra.okna.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelTestowy extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTestowy() {
		setPreferredSize(new Dimension(600, 400));
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 600, 400);
	}

}
