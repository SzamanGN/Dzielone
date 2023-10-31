package magazyn;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.Produkt;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PopapMagazyn extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ModelListyProduktow magazyn;
	
	public PopapMagazyn() {
		ustaw(new ModelListyProduktow()); // zabezpiecznie przed wyjatkiem bledu dodanie pustej listy nie moze byc null!!!
	}

	public PopapMagazyn(ModelListyProduktow magazyn) {
		ustaw(magazyn);
	}

	private void ustaw(ModelListyProduktow magazyn) {
		setTitle("Magazyn");
		setBounds(100, 100, 621, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JLabel lblNewLabel = new JLabel("Zawartosc magazynu");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				scrollPane.setColumnHeaderView(lblNewLabel);
			}
			{
				JList<Produkt> lProdukty = magazyn.getLista(); //  wazne wlozenie listy do JLIsty
				// render
				lProdukty.setCellRenderer(new RenderProduktwMagzynie());
				this.magazyn = magazyn;
				lProdukty.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(lProdukty);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bWyjdz = new JButton("Wyjdz");
				bWyjdz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						wyjdz();
					}
				});
				bWyjdz.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bWyjdz.setActionCommand("OK");
				buttonPane.add(bWyjdz);
				getRootPane().setDefaultButton(bWyjdz);
			}
		}
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
		
	}
	
	private void wyjdz() {
		dispose();
	}

}
