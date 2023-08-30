package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.pomoce.Kolor;

public class ModelListyKolorow {
	
	private DefaultListModel<Integer> model;
	
	public ModelListyKolorow(JList<Integer> lista) {
		model = new DefaultListModel<Integer>();
		int ilosc = Kolor.getIlosc();
		for(int i = 0; i < ilosc; i++) {
			model.addElement(i);
		}
		lista.setModel(model);
	}

}
