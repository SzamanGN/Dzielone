package app.panele;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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
	private BufferedImage[][] animacja;
	private int aniZegar;
	private int aniIndeks;
	private int aniPredkosc = 15;
	// private int graczAkcja = STOI;
	private int graczKiedunek = -1;
	private boolean ruch = false;

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
		setPreferredSize(wielkosc);
	}

}
