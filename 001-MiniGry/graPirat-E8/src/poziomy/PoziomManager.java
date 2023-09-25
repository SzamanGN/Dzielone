package poziomy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dodatki.LadowanieZapis;
import gra.Gra;

public class PoziomManager {
	
	private Gra gra;
	private BufferedImage[] poziomDuszek;
	private Poziom poziomPierwszy;
	
	public PoziomManager(Gra gra) {
		this.gra = gra;
		importujZewnatrzDuszek();
		poziomPierwszy =  new Poziom(LadowanieZapis.GetPoziomData());
	}

	private void importujZewnatrzDuszek() {
		BufferedImage ob = LadowanieZapis.GetDuszekAtlas(LadowanieZapis.POZIOM_ATLAS);
		poziomDuszek = new BufferedImage[48];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 12; i++) {
				int index = j * 12 + i;
				poziomDuszek[index] = ob.getSubimage(j * 32, i * 32, 32, 32);
			}
		}
	}

	public void rysuj(Graphics g) {
		for (int j = 0; j < Gra.plytka_in_wysokosc; j++) {
			for (int i = 0; i < Gra.plytka_in_szerokosc; i++) {
				int index =  poziomPierwszy.getDuszekIndex(i, j);
				g.drawImage(poziomDuszek[index], Gra.plytka_wielkosc * i, Gra.plytka_wielkosc * j, Gra.plytka_wielkosc, Gra.plytka_wielkosc, null);
			}
		}
	}
	
	public void aktulizacja() {
		
	}
}
