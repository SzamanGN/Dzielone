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

import static dodatki.GraczStale.Kierunek.*;
import static dodatki.GraczStale.StaleGracza.*;

public class PanelGry extends JPanel {

	private Myszka myszka;
	private Gra gra;

	public PanelGry(Gra gra) {
		this.gra = gra;
		
		myszka = new Myszka(this);

		ustawWielkoscPanela();
		addKeyListener(new Klawiatura(this));
		addMouseListener(myszka);
		addMouseMotionListener(myszka);

	}

	private void ustawWielkoscPanela() {
		Dimension wielkosc = new Dimension(1280, 800);
		setPreferredSize(wielkosc);
	}


	
	public void aktulizacjaGry() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		for(int i = 0; i < 64; i++) {
			for(int j = 0; j < 40; j++) {
				g.fillRect(i * 20, j * 20, 20, 20);
			}
		}
		gra.render(g);
	}
	
	public Gra getGra() {
		return gra;
	}

}
