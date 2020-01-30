package sms;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;


import java.awt.event.ActionEvent;

public class EspaceStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EspaceStudent(String cne,String nom,String prenom,String tele,String fil) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CNE:");
		lblNewLabel.setBounds(73, 34, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOM:");
		lblNewLabel_1.setBounds(73, 61, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRENOM:");
		lblNewLabel_2.setBounds(73, 88, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FILIERE:");
		lblNewLabel_3.setBounds(73, 115, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel cneLabel = new JLabel(cne);
		cneLabel.setBounds(177, 37, 273, 12);
		contentPane.add(cneLabel);
		
		JLabel nomLabel = new JLabel(nom);
		nomLabel.setBounds(177, 61, 261, 15);
		contentPane.add(nomLabel);
		
		JLabel prenomLabel = new JLabel(prenom);
		prenomLabel.setBounds(177, 88, 261, 15);
		contentPane.add(prenomLabel);
		
		JLabel filiereLabel = new JLabel(fil);
		filiereLabel.setBounds(177, 115, 261, 15);
		contentPane.add(filiereLabel);
		
		JLabel lblNewLabel_8 = new JLabel("TELEPHONE:");
		lblNewLabel_8.setBounds(73, 137, 117, 25);
		contentPane.add(lblNewLabel_8);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnQuitter.setBounds(321, 232, 117, 25);
		contentPane.add(btnQuitter);
		
		JLabel teleLabel = new JLabel(tele);
		teleLabel.setBounds(177, 142, 251, 15);
		contentPane.add(teleLabel);
		setVisible(true);
	}	
}
