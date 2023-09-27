package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.modele.Drub;

public class ModelListyDrobiu {

	private DefaultListModel<Drub> model;
	private JList<Drub> lista;
	
	public ModelListyDrobiu(JList<Drub> lista) {
		model = new DefaultListModel<Drub>();
		lista.setModel(model);
		this.lista = lista;
	}
	
	public void add(int rodzaj, int ilosc) {
		model.addElement(new Drub(rodzaj, ilosc));
		lista.updateUI();
	}
	
}
