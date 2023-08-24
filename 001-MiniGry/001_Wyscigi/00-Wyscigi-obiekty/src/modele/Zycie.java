package modele;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Zycie {
	private int ilosc;
	
	public Zycie() {
		ilosc = 3;
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
	}

	public void draw(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 22));
		g.setColor(Color.RED);
		g.drawString(
				"Ilosc zyc: " + ilosc, 10, 20);
		
	}
}
