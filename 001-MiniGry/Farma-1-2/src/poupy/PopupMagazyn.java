package poupy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Produkt;
import modeleLIst.ModelListProduktow;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopupMagazyn extends JDialog {

	private ModelListProduktow produkty;

	
	public PopupMagazyn(ModelListProduktow produkty) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton pSklep = new JButton("Sklep");
				pSklep.setFont(new Font("Tahoma", Font.PLAIN, 25));
				pSklep.setActionCommand("OK");
				buttonPane.add(pSklep);
				getRootPane().setDefaultButton(pSklep);
			}
			{
				JButton pWyjdz = new JButton("Wyjdz");
				pWyjdz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						wyjdz();
					}
				});
				pWyjdz.setFont(new Font("Tahoma", Font.PLAIN, 25));
				pWyjdz.setActionCommand("Cancel");
				buttonPane.add(pWyjdz);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JLabel lblNewLabel = new JLabel("Zawartosc magazynu");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				scrollPane.setColumnHeaderView(lblNewLabel);
			}
			{
				JList<Produkt> lProdukty = produkty.getLista();
				this.produkty = produkty;
				lProdukty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(lProdukty);
			}
		}
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void wyjdz() {
		dispose();
	}

}
