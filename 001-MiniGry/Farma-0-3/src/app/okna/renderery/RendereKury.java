package app.okna.renderery;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import app.modele.SamicaDrobiu;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;

public class RendereKury extends JPanel implements ListCellRenderer<SamicaDrobiu> {

	private static final long serialVersionUID = 1L;

	private JLabel eZycie;
	private JCheckBox cbDorosly;
	private JCheckBox cbZapladniana;
	private JPanel panelPozywienia;
	private JLabel eNajedzenieXx;
	private JLabel lbIloscJajek;
	
	public RendereKury() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel eObrazek = new JLabel("");
		eObrazek.setIcon(new ImageIcon(RendereKury.class.getResource("/obrazki/kuraM.png")));
		add(eObrazek);
		
		eZycie = new JLabel("Zycie: XX");
		eZycie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(eZycie);
		
		cbDorosly = new JCheckBox("Dorosly");
		cbDorosly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(cbDorosly);
		
		cbZapladniana = new JCheckBox("Zapladniana");
		cbZapladniana.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(cbZapladniana);
		
		panelPozywienia = new JPanel();
		add(panelPozywienia);
		
		eNajedzenieXx = new JLabel("Najedzenie : XX");
		eNajedzenieXx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(eNajedzenieXx);
		
		JLabel eObrazek_1 = new JLabel("");
		eObrazek_1.setIcon(new ImageIcon(RendereKury.class.getResource("/obrazki/jajko.png")));
		add(eObrazek_1);
		
		lbIloscJajek = new JLabel("x XX");
		lbIloscJajek.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbIloscJajek);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends SamicaDrobiu> list, SamicaDrobiu kura, int index,
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
		lbIloscJajek.setText("x " + kura.getIloscJajek());
		return this;
	}

}
