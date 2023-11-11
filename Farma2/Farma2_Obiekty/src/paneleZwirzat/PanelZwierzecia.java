package paneleZwirzat;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelZwierzecia extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JLabel eNajedzie;
	protected JLabel eNapojenie;
	protected JLabel eObrazek;
	
	
	public PanelZwierzecia() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(5, 5));
		
		JPanel panelParametrow = new JPanel();
		add(panelParametrow, BorderLayout.NORTH);
		
		eNajedzie = new JLabel("Najedzenie");
		eNajedzie.setBorder(new EmptyBorder(5, 5, 5, 5));
		eNajedzie.setOpaque(true);
		eNajedzie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelParametrow.add(eNajedzie);
		
		eNapojenie = new JLabel("Napojenie");
		eNapojenie.setOpaque(true);
		eNapojenie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		eNapojenie.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelParametrow.add(eNapojenie);
		
		eObrazek = new JLabel("obrazek");
		eObrazek.setOpaque(true);
		eObrazek.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eObrazek.setHorizontalAlignment(SwingConstants.CENTER);
		add(eObrazek, BorderLayout.CENTER);

	}

	
}
