package grastatus;

import java.awt.event.MouseEvent;

import gra.Gra;
import ui.MenuPrzyciski;

public class Status {
	
	protected Gra gra;
	
	public Status(Gra gra) {
		this.gra = gra;
	}
	
	public boolean jestW(MouseEvent e, MenuPrzyciski mp) {
		return mp.getBounds().contains(e.getX(), e.getY());
	}
	
	public Gra getGra() {
		return gra;
	}

}
