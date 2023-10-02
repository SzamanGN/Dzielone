package grastatus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import gra.Gra;

public class Menu  extends Status implements Statusmetod {

	public Menu(Gra gra) {
		super(gra);
	}

	@Override
	public void aktulizajca() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rysuj(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("MENU", Gra.gra_szerkosc / 2, 200);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Grastatus.status = Grastatus.GRAJ;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
