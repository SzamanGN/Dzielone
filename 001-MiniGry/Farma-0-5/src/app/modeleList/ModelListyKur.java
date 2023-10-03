package app.modeleList;
import app.okna.renderery.RendererKury;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import app.modele.Samica;

public class ModelListyKur {
	
	private DefaultListModel<Samica> model;
	private JList<Samica> lista;
	
	public ModelListyKur() {
		model = new DefaultListModel<Samica>();
		lista = new JList<Samica>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setModel(model);
		// renderer
		lista.setCellRenderer(new RendererKury());
	}
	
	public void add() {
		model.addElement(new Samica());
		lista.updateUI();
	}
	
	public int getIlosc() {
		return model.getSize();
	}

	public JList<Samica> getLista(){
		return lista;
	}
}
