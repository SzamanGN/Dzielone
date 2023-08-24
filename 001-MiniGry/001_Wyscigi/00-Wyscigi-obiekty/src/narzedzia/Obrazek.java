package narzedzia;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Obrazek {

	// new ImageIcon(Obrazek.class.getResource("/obrazki/BartekPrzud.png"))
	public static Image ladowanie(String nazwaObrazka) {
		return new ImageIcon(Obrazek.class.getResource("/obrazki/" + nazwaObrazka + ".png")).getImage();
	}
}
