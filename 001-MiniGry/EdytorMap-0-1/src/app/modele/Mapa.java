package app.modele;

import java.awt.Point;

public class Mapa {

	private Point wymiary;
	private int[][] mapa;
	
	public Mapa(int szerokosc, int wysokosc) {
		wymiary =  new Point(szerokosc, wysokosc);
		mapa =  new int[wymiary.y][wymiary.x];
	}
	
	public void setKafelek(int x, int y, int wartosc) {
		mapa[y][x] = wartosc;
	}
	
	public int[][] getMapa(){
		return mapa;
	}
	public int getWartosc(int x, int y) {
		return mapa[y][x];
	}
}
