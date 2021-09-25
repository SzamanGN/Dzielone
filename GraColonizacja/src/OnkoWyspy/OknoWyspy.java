package OnkoWyspy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OknoWyspy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public OknoWyspy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nazwa wyspy");
		lblNewLabel.setBounds(31, 11, 76, 14);
		layeredPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(103, 8, 86, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Zabadaj");
		btnNewButton.setBounds(42, 239, 89, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wruc do mapy");
		btnNewButton_1.setBounds(357, 239, 115, 23);
		layeredPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Obrazek wyspy");
		lblNewLabel_1.setBounds(199, 117, 86, 14);
		layeredPane.add(lblNewLabel_1);
	}

}
