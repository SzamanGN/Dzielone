package kurnik;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class PopupKurnik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private JPanel przestzrenKurnika;

	public PopupKurnik() {
		ustaw(null);
	}

	public PopupKurnik(MouseAdapter mouseAdapter) {
		ustaw(mouseAdapter);
	}

	private void ustaw(MouseAdapter mouseAdapter) {
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
				przestzrenKurnika = new JPanel();
				scrollPane.setViewportView(przestzrenKurnika);

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
		dodanieGrzedy(mouseAdapter);
		
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}

	private void zamknij() {
		dispose();
	}

	public void dodanieGrzedy(MouseAdapter mouseAdapter) {
		int ilosc = przestzrenKurnika.getComponentCount();
		przestzrenKurnika.add(new Grzeda(ilosc, mouseAdapter));
	}

	public boolean isJajo(int ktoryPanel, int indeksKury, int indeksJajka) {
		// ((Grzeda) getComponent(ktoryPanel)).isJajo(indeksKury, indeksJajka);
		return true;
	}

}
