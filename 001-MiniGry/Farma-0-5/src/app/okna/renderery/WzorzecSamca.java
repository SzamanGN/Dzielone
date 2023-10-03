package app.okna.renderery;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WzorzecSamca extends JPanel {
	protected JLabel eZycie;
	protected JCheckBox cbDorosly;
	protected JCheckBox cbCzyzapladnia;
	protected JPanel panelPozywienia;
	protected JLabel eNajedzenieXx;
	protected JLabel eObrazek;
	protected JLabel lblXX;

	public WzorzecSamca() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		eObrazek = new JLabel("");
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
		
		lblXX = new JLabel("x X");
		lblXX.setIcon(new ImageIcon(RendererKoguta.class.getResource("/obrazki/ziarnoPrzenicy.png")));
		lblXX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPozywienia.add(lblXX);
		
		eNajedzenieXx = new JLabel("Najedzenie : XX");
		eNajedzenieXx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(eNajedzenieXx);

	}

}
