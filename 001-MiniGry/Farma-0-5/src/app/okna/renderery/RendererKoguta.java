package app.okna.renderery;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import app.modele.Samiec;

public class RendererKoguta  extends WzorzecSamca implements ListCellRenderer<Samiec>{
	
	
	public RendererKoguta() {
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Samiec> list, Samiec kogut, int index,
			boolean isSelected, boolean cellHasFocus) {
		if(isSelected) {
			setBackground(Color.YELLOW);
		} else {
			setBackground(Color.LIGHT_GRAY);
		}
		eZycie.setText("Zycie: " + kogut.getZycie());
		cbDorosly.setSelected(kogut.getZycie() > 20);
		cbCzyzapladnia.setSelected(kogut.czyZapladnia());
		// rodzaje pozywienia
		eNajedzenieXx.setText("Najedzenie: " + kogut.getPoziomNajedzenia());
		return this;
	}

}
