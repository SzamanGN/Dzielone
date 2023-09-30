package app.opupy;

import javax.swing.JList;
import app.modele.SamiecDrobiu;
import app.okna.OknoFarmy;

@SuppressWarnings("serial")
public class PopupKogutow extends PopupWzorzecListy {

	private JList<SamiecDrobiu> lista;

	
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
		scrollPane.setViewportView(lista);
		addPopup(lista, popupMenu);
	}
	
}
