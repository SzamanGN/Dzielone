package app.modeleList;
import app.okna.renderery.RendereKury;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import app.modele.SamicaDrobiu;

public class ModelListyKur {
	
	private DefaultListModel<SamicaDrobiu> model;
	private JList<SamicaDrobiu> lista;
	
	public ModelListyKur() {
		model = new DefaultListModel<SamicaDrobiu>();
		lista = new JList<SamicaDrobiu>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setModel(model);
		// renderer
		lista.setCellRenderer(new RendereKury());
	}
	
	public void add() {
		model.addElement(new SamicaDrobiu());
		lista.updateUI();
	}
	
	public int getIlosc() {
		return model.getSize();
	}

	public JList<SamicaDrobiu> getLista(){
		return lista;
	}
}
