package modeleLIst;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ModelListyKomunikaty {
	
	private DefaultListModel<String> model;
	private JList<String> lista;
	private int limit;
	
	public ModelListyKomunikaty(JList<String> lista) {
		model = new DefaultListModel<String>();
		lista.setModel(model);
		// renderer do listy
		this.lista = lista;
		limit = 20;
	}
	
	public void add(String komunikat) {
		model.add(0, komunikat);
		if (model.size() > limit) {
			model.remove(limit);
		}
		lista.updateUI();
	}
	
	
}
