package app.modeleLIst;

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

//	private void ladowanieKafelkow() {
//		
//		
//	}

}
