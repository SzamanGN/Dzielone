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

import dodatki.LadowanieZapis;
import dodatki.MetodyPomoc;
import gra.Gra;

public class Gracz extends Duszek {

	private BufferedImage[][] animacja;
	private int gracz_akcja = STOI;
	private int aniZegar;
	private int aniIndex;
	private int aniPredkosc = 25;
	private boolean ruch = false;
	private boolean atakowanie = false;
	private boolean lewo, gora, prawo, dol;
	private float graczPredkosc = 2.0f;
	private int[][] pozData;
	private float xRysujObszar = 21 * Gra.scalowanie;
	private float yRysujObszar = 4 * Gra.scalowanie;
	
	// dodanie grawitacji i skoku
	private boolean skok;
	private float powietrzePredkosc = 0f;
	private float grawitacja = 0.04f * Gra.scalowanie;
	private float predkoscSkoku = -2.25f * Gra.scalowanie;
	private float upadekPredkoscPoKolizji = 0.5f * Gra.scalowanie;
	private boolean wPowietrzu = false;

	public Gracz(float x, float y, int szerokosc, int wysokosc) {
		super(x, y, szerokosc, wysokosc);
		ladowanieAnimacji();
		ladowanieKolizji( x, y, 20 * Gra.scalowanie, 27 * Gra.scalowanie);
	}

	public void aktilazacja() {
		aktulizacjaPozycji();
		aktulizacjaAnimacjiZegar();
		ustawAnimacje();
		
	}
	
	public void rysuj(Graphics g) {
		g.drawImage(animacja[gracz_akcja][aniIndex], (int) (detekcjaKolizji.x - xRysujObszar), (int) (detekcjaKolizji.y - yRysujObszar), szerokosc, wysokosc, null);
		//rysyujDetekcjeKolizji(g);
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
		if (wPowietrzu) {
			if(powietrzePredkosc < 0) {
				gracz_akcja = SKACZE;
			} else {
				gracz_akcja = UPADA;
			}
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
		
		if(skok) {
			skok();
		}
		
		if (!lewo && !prawo && !wPowietrzu) {
			return;
		}
		
		float xPredkosc = 0;
		
		if (lewo) {
			xPredkosc -= graczPredkosc;
		} else if (prawo) {
			xPredkosc += graczPredkosc;
		}
		
		if (!wPowietrzu) {
			if (MetodyPomoc.isDuszekJestNaPodlodze(detekcjaKolizji, pozData)) {
				wPowietrzu = true;
			}
		}
		
		if(wPowietrzu) {
			if (MetodyPomoc.czyMozeIsc(detekcjaKolizji.x, detekcjaKolizji.y + powietrzePredkosc, detekcjaKolizji.width, detekcjaKolizji.height, pozData)) {
				detekcjaKolizji.y += powietrzePredkosc;
				powietrzePredkosc += grawitacja;
				aktulizacjaXpoz(xPredkosc);
			} else {
				detekcjaKolizji.y = MetodyPomoc.getDuszekYpozycjaPowyzjDachuAlboPonizejPodlogi(detekcjaKolizji, powietrzePredkosc);
				if (powietrzePredkosc > 0) {
					resetWPowietrzu();
				} else {
					powietrzePredkosc = upadekPredkoscPoKolizji;
				}
				aktulizacjaXpoz(xPredkosc);
			}
		} else {
			aktulizacjaXpoz(xPredkosc);
		}
		ruch = true;
	}
	
	private void skok() {
		if (wPowietrzu) {
			return;
		}
		wPowietrzu = true;
		powietrzePredkosc = predkoscSkoku;
		
	}
	
	private void resetWPowietrzu() {
		wPowietrzu = false;
		powietrzePredkosc = 0;
	}
	
	private void aktulizacjaXpoz(float xPredkosc) {
		if (MetodyPomoc.czyMozeIsc(detekcjaKolizji.x + xPredkosc, detekcjaKolizji.y, detekcjaKolizji.width, detekcjaKolizji.height, pozData)) {
			detekcjaKolizji.x += xPredkosc;
		} else {
			detekcjaKolizji.x = MetodyPomoc.getDuszekXpozycjaDoSciany(detekcjaKolizji, xPredkosc);
		}
	}

	private void ladowanieAnimacji() {
			BufferedImage obraz =LadowanieZapis.GetDuszekAtlas(LadowanieZapis.GRACZ_ATLAS);
			animacja = new BufferedImage[9][6];
			for (int j = 0; j < animacja.length; j++) {
				for (int i = 0; i < animacja[j].length; i++) {
					animacja[j][i] = obraz.getSubimage(i * 64, j * 40, 64, 40);
				}
			}
	}
	
	public void laduPozData(int[][] pozData) {
		this.pozData = pozData;
		if (!MetodyPomoc.isDuszekJestNaPodlodze(detekcjaKolizji, pozData)) {
			wPowietrzu = true;
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

	public void setSkok(boolean skok) {
		this.skok = skok;
	}
	
	
}
