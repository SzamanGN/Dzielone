package aktorzy;

import java.awt.Color;

public class PasekZycia extends Duszek {

	public PasekZycia(int x, int y) {
		super(x, y, 100, 6, Color.GREEN, 0);
	
	}

	public void aktualizacjaZycia(int delta) {
		int zycie = obszar.width + delta;
		if(zycie >= 0) {
			obszar.width = zycie;
		} else {
			obszar.width = 0;
		}
		
	}

}
