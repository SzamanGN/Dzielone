package app.opupy;

import javax.swing.JList;
import app.modele.Samiec;
import app.okna.OknoFarmy;
import app.okna.renderery.RendererKoguta;

@SuppressWarnings("serial")
public class PopupKogutow extends PopupWzorzecListy {

	private JList<Samiec> lista;

	
	public PopupKogutow(OknoFarmy oknoFarmy) {
		super(oknoFarmy);
	}

	@Override
	protected void nakarm() {
		int indeks = lista.getSelectedIndex();
		if (indeks >= 0) {
			System.out.println("Nakarmiono koguta: " + indeks);
		}
	}

	@Override
	protected void ustawListe() {
		setTitle("Wykaz kogutow");
		eTytul.setText("Koguty");
		lista = oknoFarmy.listy.koguty.getLista();
		lista.setCellRenderer(new RendererKoguta());
		scrollPane.setViewportView(lista);
		addPopup(lista, popupMenu);
	}
	
}
