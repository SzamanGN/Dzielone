package oknoGlowne;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panelAkcji.PanelAkcji;
import panelInformacyjny.PanelInformacyjny;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import magazyn.ModelListyProduktow;
import magazyn.PopapMagazyn;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknoGlowne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelInformacyjny panelInforamcyjny;
	private PanelAkcji panelAkcji;
	private JPanel panel;
	private JLabel lMagazyn;
	private JLabel lKurnik;
	private JLabel lZagroda;
	private ModelListyProduktow magazyn;

	
	public OknoGlowne() {
		setResizable(false);
		setTitle("Farma2 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		
		panelInforamcyjny =  new PanelInformacyjny();
		contentPane.add(panelInforamcyjny, BorderLayout.NORTH);
		
		panelAkcji =  new PanelAkcji(akcjeMouseAdapter());
		contentPane.add(panelAkcji, BorderLayout.SOUTH);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		panel.setBorder(new EmptyBorder(4, 5, 5, 5));
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel, BorderLayout.CENTER);
		
		lMagazyn = new JLabel("Magazyn");
		lMagazyn.putClientProperty("budynek", "Magazyn");// dodajemy parametr do komponetu
		lMagazyn.addMouseListener(budynekMouseAdapter());
		lMagazyn.setBorder(new LineBorder(new Color(0, 0, 0)));
		lMagazyn.setPreferredSize(new Dimension(300, 400));
		lMagazyn.setHorizontalAlignment(SwingConstants.CENTER);
		lMagazyn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lMagazyn);
		
		lKurnik = new JLabel("Kurnik");
		lKurnik.putClientProperty("budynek", "Kurnik");// dodajemy parametr do komponetu
		lKurnik.addMouseListener(budynekMouseAdapter());
		lKurnik.setPreferredSize(new Dimension(300, 400));
		lKurnik.setHorizontalAlignment(SwingConstants.CENTER);
		lKurnik.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lKurnik.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(lKurnik);
		
		lZagroda = new JLabel("Zagroda");
		lZagroda.putClientProperty("budynek", "Zagroda"); // dodajemy parametr do komponetu
		lZagroda.addMouseListener(budynekMouseAdapter());
		lZagroda.setPreferredSize(new Dimension(300, 400));
		lZagroda.setHorizontalAlignment(SwingConstants.CENTER);
		lZagroda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lZagroda.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(lZagroda);
		
		ladowanieDanychStartowych();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void ladowanieDanychStartowych() {
		magazyn = new ModelListyProduktow();
		magazyn.add(0, 2);
		magazyn.add(1, 5);
		magazyn.add(2, 2);
		magazyn.add(3, 8);
		
	}
	
	private MouseAdapter budynekMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch ((String) ((JLabel) arg0.getSource()).getClientProperty("budynek")) { // oczytujemy parametr od komponetu
					case "Magazyn":
						new PopapMagazyn(magazyn);
						System.out.println("Wybrano magazyn");
						break;
					case "Kurnik":
						System.out.println("Wybrano Kurnik");
						break;
					case "Zagroda":
						System.out.println("Wybrano Zagroda");
						break;
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				((JLabel) arg0.getSource()).setBorder(new LineBorder(Color.RED)); // wazne kastowniae label do mouse adaptera
			}
			@Override
			public void mouseExited(MouseEvent e) {
				((JLabel) e.getSource()).setBorder(new LineBorder(new Color(0, 0, 0)));
			}
		};
	}
	
	private MouseAdapter akcjeMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switch (((JButton) arg0.getSource()).getActionCommand()) {
					case "Sklep":
						System.out.println("Wybrano sklep");
						break;
					case "Wyjdz":
						System.out.println("Wybrano wyjdz");
						System.exit(0);
						break;
				}
			}
		};
	}
	
	

}
