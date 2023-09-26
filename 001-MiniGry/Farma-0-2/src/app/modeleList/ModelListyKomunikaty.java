package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ModelListyKomunikaty {
	
	private DefaultListModel<String> model;
	private JList<String> lista;
	private int limit;
	
	public ModelListyKomunikaty(JList<String> lista) {
		model = new DefaultListModel<String>();
		limit = 25;
		lista.setModel(model);
		this.lista = lista;
	}
	
	public void dodajKomunikat(String komunikat) {
		model.add(0, komunikat);
		int ilosc = model.size();
		if (ilosc > limit) {
			model.remove(limit);
		}
		lista.updateUI();
	}

}
