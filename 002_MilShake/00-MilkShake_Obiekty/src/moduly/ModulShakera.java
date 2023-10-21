package moduly;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ModulShakera extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ModulShakera() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lNaglowek = new JLabel("Sheaker\r\n");
		lNaglowek.setHorizontalAlignment(SwingConstants.CENTER);
		lNaglowek.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lNaglowek, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton bWyczysc = new JButton("Wyczysc");
		bWyczysc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(bWyczysc);
		
		JButton btnGotowy = new JButton("Gotowy\r\n");
		btnGotowy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnGotowy);
		
		JPanel pBaza = new JPanel();
		pBaza.setBorder(new EmptyBorder(25, 25, 25, 25));
		FlowLayout flowLayout_1 = (FlowLayout) pBaza.getLayout();
		flowLayout_1.setHgap(0);
		flowLayout_1.setVgap(0);
		add(pBaza, BorderLayout.CENTER);
		
		JPanel panelShaker = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelShaker.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		panelShaker.setBackground(new Color(128, 128, 128));
		panelShaker.setBorder(new EmptyBorder(0, 5, 5, 5));
		panelShaker.setPreferredSize(new Dimension(210, 305));
		pBaza.add(panelShaker);
		
		JList lShaker = new JList();
		lShaker.setVisibleRowCount(6);
		lShaker.setBackground(new Color(192, 192, 192));
		lShaker.setPreferredSize(new Dimension(200, 300));
		panelShaker.add(lShaker);

	}

}
