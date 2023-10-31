package panelAkcji;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAkcji extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public PanelAkcji(MouseAdapter mouseAdapter) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(20);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(192, 192, 192));
		
		JButton bSklep = new JButton("Sklep");
		bSklep.addMouseListener(mouseAdapter);
		bSklep.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(bSklep);
		
		JButton bWyjdz = new JButton("Wyjdz");
		bWyjdz.addMouseListener(mouseAdapter);
		bWyjdz.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(bWyjdz);

	}
	
	

}
