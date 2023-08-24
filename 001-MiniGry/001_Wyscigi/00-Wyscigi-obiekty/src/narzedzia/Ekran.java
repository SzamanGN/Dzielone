package narzedzia;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Ekran {

	private static Dimension rozmiarEkranu = Toolkit.getDefaultToolkit().getScreenSize();
	private static Rectangle obszarEkranu = new Rectangle(0, 0, rozmiarEkranu.width, rozmiarEkranu.height);
	
	public static int getSzerkosc() {
		return rozmiarEkranu.width;
	}
	
	public static int getWysokosc() {
		return rozmiarEkranu.height;
	}

	public static Rectangle getObszar() {
		return obszarEkranu;
	}
}
