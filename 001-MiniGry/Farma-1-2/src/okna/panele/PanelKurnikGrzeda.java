package okna.panele;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;

public class PanelKurnikGrzeda extends JPanel {

	private Image tlo;
	
	public PanelKurnikGrzeda() {
		setPreferredSize(new Dimension(1179, 284));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		// doadnie tla grzedy
		tlo = new ImageIcon(PanelKurnikGrzeda.class.getResource("/obrazki/kurnik/tloGrzedy.png")).getImage();	
		
		PanelKoguta  kogut = new PanelKoguta();
		add(kogut);
		add(new PanelKury());
		add(new PanelKury());
		add(new PanelKury());
		add(new PanelKury());
		add(new PanelKury());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, 1179, 284, null);
	}
	
	
	

}
