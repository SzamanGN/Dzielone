package app.okna.renderery;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import app.modele.Samiec;
import javax.swing.ImageIcon;

public class RendererKnura extends WzorzecSamca implements ListCellRenderer<Samiec>{
	public RendererKnura() {
		lblXX.setIcon(new ImageIcon(RendererKnura.class.getResource("/obrazki/zagroda/wiadroM.png")));
		eObrazek.setIcon(new ImageIcon(RendererKnura.class.getResource("/obrazki/zagroda/knurD.png")));
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Samiec> list, Samiec knur, int index,
			boolean isSelected, boolean cellHasFocus) {
		if(isSelected) {
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		eZycie.setText("Zycie: " + knur.getZycie());
		cbDorosly.setSelected(knur.getZycie() > 20);
		cbCzyzapladnia.setSelected(knur.czyZapladnia());
		// rodzaje pozywienia
		eNajedzenieXx.setText("Najedzenie: " + knur.getPoziomNajedzenia());
		return this;
	}

}
