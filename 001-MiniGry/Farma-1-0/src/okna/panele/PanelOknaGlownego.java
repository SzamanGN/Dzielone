package okna.panele;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelOknaGlownego extends JPanel {

	private Image obrazek;

	public PanelOknaGlownego() {
		obrazek = new ImageIcon(PanelOknaGlownego.class.getResource("/obrazki/okna/farma.png")).getImage();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(obrazek, 0, 0, 800, 600, null);
	}

}
