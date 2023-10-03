package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import app.modele.Samiec;
import app.okna.renderery.RendererKoguta;

public class ModelListyKogutow {
	
	private DefaultListModel<Samiec> model;
	private JList<Samiec> lista;
	
	public ModelListyKogutow() {
		model = new DefaultListModel<Samiec>();
		lista = new JList<Samiec>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setModel(model);
		lista.setCellRenderer(new RendererKoguta());
	}

	public void add() {
		model.addElement(new Samiec());
		lista.updateUI();
	}
	
	public int getIlosc() {
		return model.getSize();
	}
	
	public JList<Samiec> getLista(){
		return lista;
	}
}
