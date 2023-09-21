package panele;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import kontrolery.Klawiatura;
import kontrolery.Myszka;

import static dodatki.GraczStale.Kierunek.*;
import static dodatki.GraczStale.StaleGracza.*;

public class PanelGry extends JPanel {

	private Myszka myszka;
	private float xDelta = 100;
	private float yDelta = 100;
	private BufferedImage obraz;
	private BufferedImage[][] animacja;
	private int aniZegar;
	private int aniIndex;
	private int aniPredkosc = 15;
	private boolean ruch = false;

	private int gracz_akcja = STOI;
	private int graczKierune = -1;

	public PanelGry() {

		myszka = new Myszka();
		importowanieObrazkow();
		ladowanieAnimacji();

		ustawWielkoscPanela();
		addKeyListener(new Klawiatura(this));
		addMouseListener(myszka);
		addMouseMotionListener(myszka);

	}

	private void ustawWielkoscPanela() {
		Dimension wielkosc = new Dimension(1280, 800);
		setPreferredSize(wielkosc);
	}

	private void ladowanieAnimacji() {
		animacja = new BufferedImage[9][6];
		for (int j = 0; j < animacja.length; j++) {
			for (int i = 0; i < animacja[j].length; i++) {
				animacja[j][i] = obraz.getSubimage(i * 64, j * 40, 64, 40);
			}
		}
	}

	private void importowanieObrazkow() {
		InputStream is = getClass().getResourceAsStream("/obrazki/player_sprites.png");
		try {
			obraz = ImageIO.read(is);
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

	
	public void ustawKierunek(int kierunek) {
		this.graczKierune = kierunek;
		ruch = true;
	}
	
	public void ustawRuch(boolean ruch) {
		this.ruch = ruch;
	}
	
	private void aktulizacjaAnimacjiZegar() {
		aniZegar++;
		if (aniZegar >= aniPredkosc) {
			aniZegar = 0;
			aniIndex++;
			if (aniIndex >=  PobierzDuszkaWielkosc(gracz_akcja)) {
				aniIndex = 0;
			}
		}
	}
	
	private void ustawAnimacje() {
		if (ruch) {
			gracz_akcja = BIEGNIE;
		} else {
			gracz_akcja =  STOI;
		}
	}
	
	private void aktulizacjaPopzycji() {
		if (ruch) {
			switch (graczKierune) {
			case LEWO:
				xDelta -= 5;
				break;
			case GORA:
				yDelta -= 5;
				break;
			case PRAWO:
				xDelta += 5;
				break;
			case DOL:
				yDelta += 5;
			}
		}
	}
	
	public void aktulizacjaGry() {
		aktulizacjaAnimacjiZegar();
		ustawAnimacje();
		aktulizacjaPopzycji();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		g.drawImage(animacja[gracz_akcja][aniIndex], (int) xDelta, (int) yDelta, 256, 160, null);
	}

}
