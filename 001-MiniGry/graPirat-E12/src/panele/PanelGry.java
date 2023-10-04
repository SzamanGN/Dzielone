package panele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import gra.Gra;
import kontrolery.Klawiatura;
import kontrolery.Myszka;

import static dodatki.Stale.Kierunek.*;
import static dodatki.Stale.StaleGracza.*;

public class PanelGry extends JPanel {

	private Myszka myszka;
	private Gra gra;

	public PanelGry(Gra gra) {
		myszka = new Myszka(this);
		this.gra = gra;

		ustawWielkoscPanela();
		addKeyListener(new Klawiatura(this));
		addMouseListener(myszka);
		addMouseMotionListener(myszka);

	}

	private void ustawWielkoscPanela() {
		Dimension wielkosc = new Dimension(Gra.gra_szerkosc, Gra.gra_wysokosc);
		setPreferredSize(wielkosc);
	}


	
	public void aktulizacjaGry() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gra.rysuj(g);
	}
	
	public Gra getGra() {
		return gra;
	}

}
