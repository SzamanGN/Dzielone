package app.panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import app.narzedzia.Klawiatura;
import app.narzedzia.Mysza;

@SuppressWarnings("hiding")
public class PanelGry extends JPanel {

	private Mysza mysza;
	private float xDelta = 100;
	private float yDelta = 100;
	private BufferedImage obrazek;
	private BufferedImage wycietyObrazek;

	public PanelGry() {

		mysza = new Mysza(this);

		importowanieObrazkow();
		ustawienieWielkosciPanela();

		addKeyListener(new Klawiatura(this));
		addMouseListener(mysza);
		addMouseMotionListener(mysza);

	}

	private void importowanieObrazkow() {
		InputStream is = getClass().getResourceAsStream("/obrazki/player_sprites.png");

		try {
			obrazek = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void ustawienieWielkosciPanela() {
		Dimension wielkosc = new Dimension(1280, 800);
		setMinimumSize(wielkosc);
		setPreferredSize(wielkosc);
		setMaximumSize(wielkosc);
	}

	public void zmienYDelta(int ilosc) {
		this.yDelta += ilosc;
	}

	public void zmienXDelta(int ilosc) {
		this.xDelta += ilosc;
	}

	public void ustawKwadratPozycje(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}

	public void rysujKomponent(Graphics g) {
		super.paintComponent(g);

		wycietyObrazek = obrazek.getSubimage(1 * 64, 8 * 40, 64, 40);
		g.drawImage(wycietyObrazek, (int)xDelta, (int)yDelta, 128, 80, null);

	}

}
