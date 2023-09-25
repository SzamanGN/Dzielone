package modele;

import static dodatki.GraczStale.Kierunek.*;
import static dodatki.GraczStale.Kierunek.GORA;
import static dodatki.GraczStale.Kierunek.LEWO;
import static dodatki.GraczStale.Kierunek.PRAWO;
import static dodatki.GraczStale.StaleGracza.BIEGNIE;
import static dodatki.GraczStale.StaleGracza.PobierzDuszkaWielkosc;
import static dodatki.GraczStale.StaleGracza.STOI;
import static dodatki.GraczStale.StaleGracza.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Gracz extends Model {

	private BufferedImage obraz;
	private BufferedImage[][] animacja;
	private int gracz_akcja = STOI;
	private int aniZegar;
	private int aniIndex;
	private int aniPredkosc = 25;
	private boolean ruch = false;
	private boolean atakowanie = false;
	private boolean lewo, gora, prawo, dol;
	private float graczPredkosc = 2.0f;

	public Gracz(float x, float y, int szerokosc, int wysokosc) {
		super(x, y, szerokosc, wysokosc);
		ladowanieAnimacji();
	}

	public void aktilazacja() {
		aktulizacjaPozycji();
		aktulizacjaAnimacjiZegar();
		ustawAnimacje();
		
	}
	
	public void render(Graphics g) {
		g.drawImage(animacja[gracz_akcja][aniIndex], (int) x, (int) y, szerokosc, wysokosc, null);
	}
	
	private void aktulizacjaAnimacjiZegar() {
		aniZegar++;
		if (aniZegar >= aniPredkosc) {
			aniZegar = 0;
			aniIndex++;
			if (aniIndex >=  PobierzDuszkaWielkosc(gracz_akcja)) {
				aniIndex = 0;
				atakowanie = false;
			}
		}
	}
	private void ustawAnimacje() {
		int starAni = gracz_akcja;
		if (ruch) {
			gracz_akcja = BIEGNIE;
		} else {
			gracz_akcja =  STOI;
		}
		if (atakowanie) {
			gracz_akcja = ATAKUJE_1;
		}
		if (starAni != gracz_akcja) {
			resetAniZegar();
		}
	}
	
	private void resetAniZegar() {
		aniZegar = 0;
		aniIndex = 0;
	}
	
	private void aktulizacjaPozycji() {
		ruch = false;
		
		if(lewo && !prawo) {
			x -= graczPredkosc;
			ruch = true;
		} else if (prawo && !lewo) {
			x += graczPredkosc;
			ruch = true;
		}
		
		if (gora && !dol) {
			y -= aniPredkosc;
			ruch =  true;
		} else if (dol && !gora) {
			y += graczPredkosc;
			ruch = true;
		}
		
	}

	private void ladowanieAnimacji() {
		InputStream is = getClass().getResourceAsStream("/obrazki/player_sprites.png");
		try {
			BufferedImage obraz = ImageIO.read(is);
			animacja = new BufferedImage[9][6];
			for (int j = 0; j < animacja.length; j++) {
				for (int i = 0; i < animacja[j].length; i++) {
					animacja[j][i] = obraz.getSubimage(i * 64, j * 40, 64, 40);
				}
			}
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
	

	public void resetowanieKierukow() {
		lewo = false;
		prawo = false;
		gora = false;
		dol = false;
	}
	
	public void ustawAtak(boolean atakowanie) {
		this.atakowanie = atakowanie;
	}

	public boolean isLewo() {
		return lewo;
	}

	public void setLewo(boolean lewo) {
		this.lewo = lewo;
	}

	public boolean isGora() {
		return gora;
	}

	public void setGora(boolean gora) {
		this.gora = gora;
	}

	public boolean isPrawo() {
		return prawo;
	}

	public void setPrawo(boolean prawo) {
		this.prawo = prawo;
	}

	public boolean isDol() {
		return dol;
	}

	public void setDol(boolean dol) {
		this.dol = dol;
	}
	
	
}
