package app.okna.popupy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormularzInwestycji extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	/**
	 * Create the frame.
	 */
	public FormularzInwestycji() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ikona Inwestycji");
		chckbxNewCheckBox.setBounds(72, 22, 229, 23);
		layeredPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("Wprowadz Nazwe Inwetsycji");
		lblNewLabel.setBounds(10, 76, 187, 14);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Koszt Miesieczny Inwestcji");
		lblNewLabel_1.setBounds(10, 128, 145, 14);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Koszt Inwestycji");
		lblNewLabel_2.setBounds(10, 101, 145, 14);
		layeredPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(156, 73, 145, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 97, 145, 20);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 125, 145, 20);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.setBounds(24, 217, 89, 23);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Usun");
		btnNewButton_1.setBounds(128, 217, 89, 23);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Anuluj");
		btnNewButton_2.setBounds(325, 217, 89, 23);
		layeredPane.add(btnNewButton_2);
	}
	
}
