package app.okna.renderery;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WzorzecSamicy extends JPanel {

	protected JLabel eZycie;
	protected JCheckBox cbDorosly;
	protected JCheckBox cbZapladniana;
	protected JPanel panelPozywienia;
	protected JLabel eNajedzenieXx;
	protected JLabel produktObrazek;
	protected JLabel produkt;
	protected JLabel eObrazek;
	

	public WzorzecSamicy() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		eObrazek = new JLabel("");
		eObrazek.setIcon(new ImageIcon(RendererKury.class.getResource("/obrazki/kuraM.png")));
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

		produktObrazek = new JLabel("");
		produktObrazek.setIcon(new ImageIcon(RendererKury.class.getResource("/obrazki/jajko.png")));
		add(produktObrazek);

		produkt = new JLabel("x XX");
		produkt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(produkt);

	}

}
