package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.modele.SamiecDrobiu;

public class ModelListyKogutow {
	
	private DefaultListModel<SamiecDrobiu> model;
	private JList<SamiecDrobiu> lista;
	
	public ModelListyKogutow(JList<SamiecDrobiu> lista) {
		model = new DefaultListModel<SamiecDrobiu>();
		lista.setModel(model);
		this.lista = lista;
	}

	public void add() {
		model.addElement(new SamiecDrobiu());
		lista.updateUI();
	}
	
	public int getIlosc() {
		return model.getSize();
	}
}
