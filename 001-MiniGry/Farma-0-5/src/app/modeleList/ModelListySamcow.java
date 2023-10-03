package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import app.modele.Samiec;

public class ModelListySamcow {

	private DefaultListModel<Samiec> model;
	private JList<Samiec> lista;

	public ModelListySamcow() {
		model = new DefaultListModel<Samiec>();
		lista = new JList<Samiec>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setModel(model);
	}

	public void add() {
		model.addElement(new Samiec());
		lista.updateUI();
	}

	public int getIlosc() {
		return model.getSize();
	}

	public JList<Samiec> getLista() {
		return lista;
	}
}
