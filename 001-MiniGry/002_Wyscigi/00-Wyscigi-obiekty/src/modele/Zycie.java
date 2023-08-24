package modele;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Zycie {
	private int ilosc;
	private Image obrazek;
	
	public Zycie(Image obrazek) {
		ilosc = 3;
		this.obrazek = obrazek;
	}

	public void traci() {
		ilosc -= 1;
	}
	
	public boolean isZyje() {
		return ilosc > 0;
	}
	
	public int getIlosc() {
		return ilosc;
	}
	
	public void ustaw(int noawaWartosc) {
		ilosc = noawaWartosc;
	}
	
	public void dodaj() {
		ilosc += 1;
		if(ilosc > 5) {
			ilosc = 5;
		}
	}

	public void draw(Graphics g) {
//		g.setFont(new Font("Tahoma", Font.BOLD, 22));
//		g.setColor(Color.RED);
//		g.drawString(
//				"Ilosc zyc: " + ilosc, 10, 20);
		for(int z = 0; z < ilosc; z++) {
			g.drawImage(
					obrazek, 
					10 + (z * 41),
					10, 
					null);
		}
		
		
	}
}
