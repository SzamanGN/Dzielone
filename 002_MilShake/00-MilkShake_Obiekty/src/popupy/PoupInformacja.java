package popupy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dane.Nazwa;
import enumy.RodzajPoupu;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class PoupInformacja extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JLabel eObrazek;
	private JLabel eTytul;
	private JLabel lblnazwatresc;

	public PoupInformacja() {
		ustaw(0, RodzajPoupu.Wygaslo);
	}

	public PoupInformacja(int id, RodzajPoupu rodzaj) {
		ustaw(id, rodzaj);
	}
	
	public void ustaw(int id, RodzajPoupu rodzaj) {
		setUndecorated(true);
		setBounds(100, 100, 420, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			eTytul = new JLabel("Tytul\r\n");
			eTytul.setFont(new Font("Tahoma", Font.PLAIN, 24));
			eTytul.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(eTytul, BorderLayout.NORTH);
		}
		{
			eObrazek = new JLabel("");
			eObrazek.setIcon(new ImageIcon(PoupInformacja.class.getResource("/obrazki/zamowienia/shakeD0.png")));
			contentPanel.add(eObrazek, BorderLayout.WEST);
		}
		{
			lblnazwatresc = new JLabel("<html><center><h1>(nazwa))</h1>{tresc}</cnter></html>");
			lblnazwatresc.setFont(new Font("Tahoma", Font.PLAIN, 8));
			lblnazwatresc.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblnazwatresc, BorderLayout.CENTER);
		}
		switch(rodzaj) {
			case Wygaslo:
				setBounds(0, 0, 420, 254);
				contentPanel.setBackground(Color.RED);
				eObrazek.setIcon(new ImageIcon(PoupInformacja.class.getResource("/obrazki/zamowienia/shakeD" + id + ".png")));
				eTytul.setText("Anulowano zlecenie");
				lblnazwatresc.setText("<html><center><h1>" + Nazwa.sheka(id) + "</h1>Wycofano zamowienie z powodu opoznienienia</cnter></html>");
				lblnazwatresc.setForeground(Color.WHITE);
				break;
			case NoweZamowienie:
				setBounds(500, 0, 420, 254);
				contentPanel.setBackground(Color.GREEN);
				eObrazek.setIcon(new ImageIcon(PoupInformacja.class.getResource("/obrazki/zamowienia/shakeD" + id + ".png")));
				eTytul.setText("Nowe zlecenie");
				lblnazwatresc.setText("<html><center><h1>" + Nazwa.sheka(id) + "</h1>Dodano nowe zamowienie.</cnter></html>");
				lblnazwatresc.setForeground(Color.BLACK);
				break;
		}
		zegar();
		setVisible(true);
	}
	
	private void zamknij() {
		dispose();
	}
	
	private void zegar() {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				zamknij();
			}
		}.start();
	}

}
