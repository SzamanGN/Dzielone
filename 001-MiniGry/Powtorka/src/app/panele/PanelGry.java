package app.panele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import app.narzedzia.Klawiatura;
import app.narzedzia.Mysza;

@SuppressWarnings("hiding")
public class PanelGry extends JPanel {
	
	private Mysza mysza;
	private float xDelta = 100;
	private float yDelta = 100;
	private float xDir = 1f;
	private float yDir = 1f;
	private Color kolor;
	private Random losowa;
	
	//chwilowa 
	private ArrayList<MojKwadrat> kwadraty;
	
	
	public PanelGry() {
		kwadraty = new ArrayList<>();
		kolor = new Color(150, 20, 90);
		losowa = new Random();
		mysza =  new Mysza(this);
		addKeyListener(new Klawiatura(this));
		addMouseListener(mysza);
		addMouseMotionListener(mysza);
		
	}

	public void zmienYDelta(int ilosc) {
		this.yDelta += ilosc;
	}
	
	public void zmienXDelta(int ilosc) {
		this.xDelta += ilosc;
	}
	
	public void ustawKwadratPozycje(int x, int y ) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	public void pojawienieRec(int x, int y) {
		kwadraty.add(new MojKwadrat(x, y));
	}
	
	public void rysujKomponent(Graphics g) {
		super.paintComponent(g);
		
		//tymczaosoway kwardrat
		for (MojKwadrat kwadrat : kwadraty ) {
			kwadrat.aktulizacjaMojKwadrat();
			kwadrat.rysuj(g);
		}
		
		aktulizujKwadrat();
	}

	private void aktulizujKwadrat() {
		xDelta += xDir;
		if( xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			kolor = getLosowyKolor();
		}
		
		yDelta += yDir;
		if( yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			kolor = getLosowyKolor();
		}
		
	}

	private Color getLosowyKolor() {
		int r = losowa.nextInt(255);
		int g = losowa.nextInt(255);
		int b = losowa.nextInt(255);
		return new Color(r, g, b);
	}

}
