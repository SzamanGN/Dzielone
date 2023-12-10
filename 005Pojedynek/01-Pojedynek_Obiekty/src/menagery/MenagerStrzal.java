package menagery;

import java.awt.Graphics;
import java.util.ArrayList;

import aktorzy.Strzala;

public class MenagerStrzal {
	
	private ArrayList<Strzala> wykaz;
	
	public MenagerStrzal() {
		wykaz = new ArrayList<Strzala>();
	}

	public void add(Strzala strzala) {
		wykaz.add(strzala);
	}
	
	public int getIlosc() {
		return wykaz.size();
	}
	
	public Strzala get(int ktora) {
		return wykaz.get(ktora);
	}
	
	public void remove(Strzala strzala) {
		wykaz.remove(strzala);
	}

	public void rysowanie(Graphics g) {
		wykaz.forEach((s) -> s.rysowanie(g));
	}

	public void tikZegara() {
		wykaz.forEach((s) -> s.tikZegara());
	}
}
