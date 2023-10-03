package app.opupy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.menagery.MenagerList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class PopupTest extends JDialog {

	private static final long serialVersionUID = 1L;
	private MenagerList listy;
	

	public PopupTest() {
		setTitle("PoupTestowy");
		listy = new MenagerList();
		setBounds(100, 100, 649, 560);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton bZakmnij = new JButton("Zamknij");
				bZakmnij.setFont(new Font("Tahoma", Font.PLAIN, 20));
				bZakmnij.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						zamknij();
					}
				});
				bZakmnij.setToolTipText("");
				bZakmnij.setActionCommand("Cancel");
				buttonPane.add(bZakmnij);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JLabel eTytul = new JLabel("Tytul");
				eTytul.setFont(new Font("Tahoma", Font.PLAIN, 22));
				eTytul.setHorizontalAlignment(SwingConstants.CENTER);
				scrollPane.setColumnHeaderView(eTytul);
			}
			{
				JList list = new JList();
				scrollPane.setViewportView(list);
				{
					JPopupMenu popupMenu = new JPopupMenu();
					addPopup(list, popupMenu);
					{
						JMenuItem pmiNakarm = new JMenuItem("Nakarm");
						pmiNakarm.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						popupMenu.add(pmiNakarm);
					}
				}
			}
		}
		
		setModal(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void zamknij() {
		System.out.println("Zamykanie poupu");
		dispose();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
