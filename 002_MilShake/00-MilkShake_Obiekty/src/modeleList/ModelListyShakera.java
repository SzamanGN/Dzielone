package modeleList;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modele.Produkt;
import renderery.RedererShakera;

public class ModelListyShakera {

	private DefaultListModel<Produkt> model;
	private JList<Produkt> lista;
	private int licznik;
	private String skladniki;
	private Produkt pusty;

	public ModelListyShakera(JList<Produkt> lista) {
		model = new DefaultListModel<Produkt>();
		lista.setModel(model);
		// renderer
		lista.setCellRenderer(new RedererShakera());
		this.lista = lista;
		pusty = new Produkt(-1, 0, new Color(192, 192, 192), new Color(192, 192, 192));
		for(int i = 0; i < 6; i++) {
			model.addElement(pusty);
		}
		wyczysc();
	}

	public void wyczysc() {
		licznik = 1;
		skladniki = "";
		for(int i = 0; i < 6; i++) {
			model.set(i, pusty);// zamieniamy elementy w liscie
		}
	}
	
	public void dodajSkaldnik(Produkt produkt){
		if (licznik <= 6) {
			model.set(6 - licznik, produkt);
			licznik += 1;
			skladniki += produkt.getId();
		}
	}
	
	public String getSkladniki() {
		return skladniki;
	}
}
