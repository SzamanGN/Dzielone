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
import app.dodatki.Stale.Kierunek.*;
import app.dodatki.Stale.GraczStale.*;

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
	private int gracz_akcja = STOI;
	private int graczKierunek = -1;
	private boolean ruch = false;

	public PanelGry() {

		mysza = new Mysza(this);

		importowanieObrazkow();
		ladowanieAnimacji();
		ustawienieWielkosciPanela();

		addKeyListener(new Klawiatura(this));
		addMouseListener(mysza);
		addMouseMotionListener(mysza);

	}

	private void ladowanieAnimacji() {
		animacja = new BufferedImage[9][6];
		for (int j = 0; j < animacja.length; j++)
			for (int i = 0; i < animacja[j].length; i++)
				animacja[j][i] = obrazek.getSubimage(i * 64, j * 40, 64, 40);
	}

	private void importowanieObrazkow() {
		InputStream is = getClass().getResourceAsStream("/obrazki/player_sprites.png");

		try {
			obrazek = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void ustawienieWielkosciPanela() {
		Dimension wielkosc = new Dimension(1280, 800);
		setPreferredSize(wielkosc);
	}

	public void ustawKierunek(int kierune) {
		this.graczKierunek = kierune;
		ruch = true;
	}

	public void ustawRuch(boolean ruch) {
		this.ruch = ruch;
	}

	public void rysujKomponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void aktuliazcjaAnimacjjiZegara() {
		aniZegar++;
		if(aniZegar >= aniPredkosc) {
			aniZegar = 0;
			aniIndeks++;
			if(aniIndeks >= PobDuszkaWiel(gracz_akcja)) {
				aniIndeks = 0;
			}
		}
	}

}
