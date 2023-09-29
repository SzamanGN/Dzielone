package app.okna.renderery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import app.modele.SamiecDrobiu;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;

public class RendererKoguta extends JPanel implements ListCellRenderer<SamiecDrobiu>{

	private static final long serialVersionUID = 1L;
	private JLabel eZycie;
	private JCheckBox cbDorosly;
	private JCheckBox cbCzyzapladnia;
	private JPanel panelPozywienia;
	private JLabel eNajedzenieXx;

	/**
	 * Create the panel.
	 */
	public RendererKoguta() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel eObrazek = new JLabel("");
		eObrazek.setIcon(new ImageIcon(RendererKoguta.class.getResource("/obrazki/kogutM.png")));
		add(eObrazek);
		
		eZycie = new JLabel("Zycie: XX");
		eZycie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(eZycie);
		
		cbDorosly = new JCheckBox("Dorosly");
		cbDorosly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(cbDorosly);
		
		cbCzyzapladnia = new JCheckBox("Zapladnia");
		cbCzyzapladnia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(cbCzyzapladnia);
		
		panelPozywienia = new JPanel();
		add(panelPozywienia);
		
		JLabel lblXX = new JLabel("x X");
		lblXX.setIcon(new ImageIcon(RendererKoguta.class.getResource("/obrazki/ziarnoPrzenicy.png")));
		lblXX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPozywienia.add(lblXX);
		
		eNajedzenieXx = new JLabel("Najedzenie : XX");
		eNajedzenieXx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(eNajedzenieXx);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends SamiecDrobiu> list, SamiecDrobiu kogut, int index,
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
