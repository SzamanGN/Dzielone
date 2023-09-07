package app.okna.panele;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import app.modele.Mapa;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class PanelMapy extends JPanel {
	private ArrayList<Image> obrazki;
	private Mapa mapa;
	private Point zaznaczenie;
	private int aktualnyObrazek;

	public PanelMapy(ArrayList<Image> obrazki) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				zaznaczenie.x = e.getX() / 32;
				zaznaczenie.y = e.getY() / 32;
				repaint();
			}
		});
		this.obrazki = obrazki;
		zaznaczenie = new Point(0, 0);
		aktualnyObrazek = 0;
		setPreferredSize(new Dimension(320, 320));
		mapa = new Mapa(10, 10);
		System.out.println("Warotosc komorki [0][0]= " + mapa.getWartosc(0, 0));
		System.out.println("(mapa) Ilosc obrazkow = " + this.obrazki.size());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// rysowanie mapy
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				g.drawImage(
						obrazki.get(mapa.getWartosc(x, y)),
						x * 32,
						y * 32,
						null
						);
			}
		}
		
		// rysowanie zaznaczenia
		g.drawImage(
				obrazki.get(aktualnyObrazek),
				zaznaczenie.x * 32,
				zaznaczenie.y * 32,
				null
				);
	}

	public void setKafelekId(int selectedIndex) {
		aktualnyObrazek = selectedIndex;
		repaint();
	}

	public void ustawKafelek(int y, int x) {
		mapa.setKafelek(x, y, aktualnyObrazek);
		repaint();
	}

	public int[][] getMapa(){
		return mapa.getMapa();
	}
}
