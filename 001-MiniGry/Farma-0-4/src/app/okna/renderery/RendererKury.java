package app.okna.renderery;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import app.modele.Samica;

public class RendererKury extends WzorzecSamicy implements ListCellRenderer<Samica> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Samica> list, Samica kura, int index,
			boolean isSelected, boolean cellHasFocus) {
		if  (isSelected) {
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		eZycie.setText("zycie: " + kura.getZycie());
		cbDorosly.setSelected(kura.isJestDorosly());
		eNajedzenieXx.setText("Najedzenie: " + kura.getPoziomNajedzenia());
		cbZapladniana.setSelected(kura.isZaplodniona());
		produkt.setText("x " + kura.getIloscJajek());
		return this;
	}

}
