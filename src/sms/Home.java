package sms;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

public class Home extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel errorLabel;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Home() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 143, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setEchoChar('*');
		textField_1.setBounds(25, 201, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement stt = ConnectionDB.prepareQuery("select  * from users where username=? and password=? limit 1");
				try {
						stt.setString(1, textField.getText());
						stt.setString(2, String.copyValueOf(textField_1.getPassword()));
					
						boolean check = stt.executeQuery().first();
				
						if(check) {
							new EspaceAdmin(textField.getText());
							dispose();
							
						} else {
							
							errorLabel.setText("username or password inccorect");
							
						}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		btnNewButton.setBounds(25, 233, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Utilisateur :");
		lblNewLabel.setBounds(35, 117, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(39, 175, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("System de gestion des etudiants");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(25, 0, 387, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblEspaceAdministration = new JLabel("Espace administration");
		lblEspaceAdministration.setBounds(25, 49, 165, 15);
		contentPane.add(lblEspaceAdministration);
		
		JLabel lblEspaceEtudiant = new JLabel("Espace etudiant");
		lblEspaceEtudiant.setBounds(261, 49, 165, 15);
		contentPane.add(lblEspaceEtudiant);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(261, 143, 165, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(261, 201, 165, 20);
		contentPane.add(textField_3);
		
		JLabel lblCne = new JLabel("CNE :");
		lblCne.setBounds(272, 117, 117, 14);
		contentPane.add(lblCne);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(271, 175, 89, 14);
		contentPane.add(lblNom);
		
		JButton btnEntrer = new JButton("Entrer");
		btnEntrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PreparedStatement stt = ConnectionDB.prepareQuery("select  * from etudiants where cne=? and nom=? limit 1");
				try {
						stt.setString(1, textField_2.getText());
						stt.setString(2, textField_3.getText());
					
						boolean check = stt.executeQuery().first();
						
						if(check) { 
							ResultSet res = stt.getResultSet();
							 String filiere = getFiliere(res.getInt(4));
							new EspaceStudent(res.getString(1),res.getString(2),res.getString(3),res.getString(5),filiere);
							dispose();
							
						} else {
							
							errorLabel.setText("Student not exist's");
							
						}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrer.setBounds(261, 233, 102, 23);
		contentPane.add(btnEntrer);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(62, 76, 290, 20);
		contentPane.add(errorLabel);
		
		setVisible(true);
	}
	
	public String getFiliere(int code) throws SQLException {
		
	
		 
		 ResultSet res = ConnectionDB.excuteQuery("select lib from filiere where code="+code);
			      res.next();
			      
		  return res.getString(1);
		 
	}
}
