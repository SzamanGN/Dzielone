package kurnik;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modele.Produkt;
import silnik.Silnik;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class PopupKurnik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JPanel przestrzenKurnika;
	private Silnik silnik;

	public PopupKurnik() {
		ustaw(new Silnik());
	}

	public PopupKurnik(Silnik silnik) {
		ustaw(silnik);
	}

	private void ustaw(Silnik pobranySilnik) {
		silnik = pobranySilnik;
		setBounds(100, 100, 1291, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblNewLabel = new JLabel("Kurnik");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel, BorderLayout.NORTH);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JPanel panelInformacyjny = new JPanel();
				scrollPane.setColumnHeaderView(panelInformacyjny);
				{
					JLabel lblNewLabel_1 = new JLabel("Panel informacyjny :");
					lblNewLabel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
					panelInformacyjny.add(lblNewLabel_1);
				}
			}
			{
				przestrzenKurnika = new JPanel();
				scrollPane.setViewportView(przestrzenKurnika);

			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton pZamknij = new JButton("Zamknij");
				pZamknij.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						zamknij();
					}
				});
				pZamknij.setFont(new Font("Tahoma", Font.PLAIN, 14));
				pZamknij.setActionCommand("OK");
				buttonPane.add(pZamknij);
				getRootPane().setDefaultButton(pZamknij);
			}
		}
		dodanieGrzedy(jajoMouseAdapter());
		
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}

	private void zamknij() {
		dispose();
	}

	public void dodanieGrzedy(MouseAdapter mouseAdapter) {
		int ilosc = przestrzenKurnika.getComponentCount();
		przestrzenKurnika.add(new Grzeda(ilosc, mouseAdapter));
	}

	public boolean isJajo(int ktoryPanel, int indeksKury, int indeksJajka) {
		//Grzeda grzenda = (Grzeda) przestrzenKurnika.getComponent(ktoryPanel);
		return ((Grzeda) przestrzenKurnika.getComponent(ktoryPanel)).isJajo(indeksKury, indeksJajka);
	}
	
	private void usuniecieJajka(int ktoryPanel, int indeksKury, int indeksJajka) {
		((Grzeda) przestrzenKurnika.getComponent(ktoryPanel)).usunJajo(indeksKury, indeksJajka);
	}
	
	private MouseAdapter jajoMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int ktoryPanel = (int) ((JLabel) arg0.getSource()).getClientProperty("ktoryPanel");
				int indeksKury = (int) ((JLabel) arg0.getSource()).getClientProperty("indeskKury");
				int indeksJajka = (int) ((JLabel) arg0.getSource()).getClientProperty("indeksJajka");
				System.out.println(String.format("Kotry panel = %d, indeks ktory = %d, indeks jajak = %d" ,
						ktoryPanel,
						indeksKury,
						indeksJajka
						));
				if (isJajo(ktoryPanel, indeksKury, indeksJajka)) {
					System.out.println("Jest jajo");
					// dodanie jajka do magazynu
					silnik.dodajProduktDoMagazynu(0, 1);
					// ususniecie obrazka jajka
					usuniecieJajka(ktoryPanel, indeksKury, indeksJajka);
				} else {
					System.out.println("Nie ma jaja");
				}
			}
		};
	}
}
