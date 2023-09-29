package app.modeleList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.modele.SamiecDrobiu;
import app.okna.renderery.RendererKoguta;

public class ModelListyKogutow {
	
	private DefaultListModel<SamiecDrobiu> model;
	private JList<SamiecDrobiu> lista;
	
	public ModelListyKogutow() {
		model = new DefaultListModel<SamiecDrobiu>();
		lista = new JList<SamiecDrobiu>();
		lista.setModel(model);
		lista.setCellRenderer(new RendererKoguta());
	}

	public void add() {
		model.addElement(new SamiecDrobiu());
		lista.updateUI();
	}
	
	public int getIlosc() {
		return model.getSize();
	}
	
	public JList<SamiecDrobiu> getLista(){
		return lista;
	}
}
