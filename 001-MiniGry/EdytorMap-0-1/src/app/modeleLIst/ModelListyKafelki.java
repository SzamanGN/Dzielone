package app.modeleLIst;

import java.awt.Image;
import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.modele.Kafelek;
import app.narzedzia.Plik;

public class ModelListyKafelki {
	
	private DefaultListModel<Kafelek> model;
	private JList<Kafelek> lista;
	
	public ModelListyKafelki(JList<Kafelek> lista) {
//		model = new DefaultListModel<Kafelek>();
		model = Plik.ladowanieKafelkow();
		//ladowanieKafelkow();
		lista.setModel(model);
		this.lista = lista;
	}

	public ArrayList<Image> getObrazki(){
		ArrayList<Image> obrazki = new ArrayList<Image>();
		int ilosc = model.getSize();
		for(int o = 0; o < ilosc; o++) {
			obrazki.add(model.get(o).getImg());
		}
		System.out.println("Ilosc obrazkow = " + obrazki.size());
		return obrazki;
	}

	public int getIlosc() {
		return model.size();
	}

	public Kafelek get(int ktory) {
		return model.get(ktory);
	}
	

}
