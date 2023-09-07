package app.narzedzia;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;

import app.modele.Kafelek;
import app.modeleLIst.ModelListyKafelki;

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
	
	public static void zapiszMape(String nazwaPliku, int[][] mapa, ModelListyKafelki kafelki) {
		int wysokoscMapy = mapa.length;
		int szerokoscMapy = mapa[0].length;
		System.out.println("Wysokosc mapy = " + wysokoscMapy + ", szerokosc = " + szerokoscMapy);
		FileWriter fw;
		try {
			fw = new FileWriter(nazwaPliku);
			PrintWriter pw = new PrintWriter(fw);
			String linia;
			// defnicja kafelkow 
			int ilosc = kafelki.getIlosc();
			for(int i = 0; i < ilosc; i++) {
				if(i == 0) {
					linia = "";
				} else {
					linia = "\n";
				}
				linia += "K#" + kafelki.get(i).getNazwa() + ".png";
				pw.print(linia);
			}
			// defnicja mapy
			pw.print("\nP#wysokosc=" + wysokoscMapy);
			pw.print("\nP#szerokosc=" + szerokoscMapy);
			for(int y = 0; y < wysokoscMapy; y++) {
				linia = "\nM#";
				for(int x = 0; x < szerokoscMapy; x++) {
					linia += mapa[y][x];
				}
				System.out.println("zawartosc linia: " + linia);
				pw.print(linia);
			}
			pw.close();
			System.out.println("Zapisano mape " + nazwaPliku);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
