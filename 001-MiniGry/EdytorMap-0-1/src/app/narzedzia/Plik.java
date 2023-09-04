package app.narzedzia;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;

import app.modele.Kafelek;

public class Plik {
	
	public static DefaultListModel<Kafelek> ladowanieKafelkow(){
		DefaultListModel<Kafelek> model = new DefaultListModel<Kafelek>();
		File folder = new File(".");
		File[] zawartosc = folder.listFiles();
		String nazwaPliku;
		String[] dane;
 		for(File plik : zawartosc) {
			if(plik.isFile()) {
				nazwaPliku = plik.getName();
				dane = nazwaPliku.split("\\."); //nazwa podzielona na 2 elementy nazwa i rozszerzenie pliku
				if(dane.length == 2) {
					if(dane[1].contains("png")) {
						try {
							model.addElement(new Kafelek(
									ImageIO.read(plik),
									dane[0]
									));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
		return model;
	}

}
