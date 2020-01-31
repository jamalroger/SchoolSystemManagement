package sms;

import java.awt.BorderLayout;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import javax.swing.JTextField;
import javax.swing.RowFilter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class EspaceAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable studentTable;
	private DefaultTableModel studentModel;
	private JTable departTable;
	private DefaultTableModel departModel;
	private JTable filTable;
	private DefaultTableModel filModel;
	
	// liste components tab 1
	private JTabbedPane tabbedPane;
	private JTextField cneTextField;
	private JTextField prenomTextField;
	private JTextField NomTextField;
	private JTextField telTextField;
	private JTextField serachStudentTextField;
	private JComboBox<ComboBoxItem>  filComboBox;
	private JComboBox<ComboBoxItem>  DepartcomboBox;
	private JTextField searchDepartTextField;
	private JTextField DepartTextField;
	private JTextField FilTextField;
	private JTextField seachFilTextField;

	private JPanel studentPanel;

	private JPanel departementPanel;

	private JPanel filierePanel;

	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EspaceAdmin(String windwowName) throws SQLException {
		super(windwowName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 533);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.addJtabbePaneComponents();
		this.addJTablesComponents();
		this.addJTextFieldComponentsForStudents();
		this.addJTextFieldComponentsForDepartement();
		this.addJTextFieldComponentsForFiliere();
		this.ActiveSearchFor(studentTable, studentModel, serachStudentTextField);
		this.ActiveSearchFor(filTable, filModel, seachFilTextField);
		this.ActiveSearchFor(departTable, departModel, searchDepartTextField);
		this.addStudents();
		this.getAllfiliere();
		this.getDepartements();
		this.addfilieres();
		this.addDepartemnts();
		this.addButtonaddEvent();
		setVisible(true);
	}
	
	
	
	public void addJtabbePaneComponents() {
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		   // tab 1
		  studentPanel = new JPanel();
		  studentPanel.setToolTipText("Selectionne pour suprimer  ");
		  tabbedPane.addTab("Liste Etudiants", null, studentPanel, null);
		  studentPanel.setLayout(null);
		  
		    // tab 2
		  departementPanel = new JPanel();
		  tabbedPane.addTab("Liste Departements", null, departementPanel, null);
		  departementPanel.setLayout(null);
		
		    // tab 3
		 filierePanel = new JPanel();
		 tabbedPane.addTab("Liste Filieres", null, filierePanel, null);
		 filierePanel.setLayout(null);
		
		
		 
	 }
	  
	 public void addJTablesComponents() {
		 
		 
		 
		  // ////////////////////////////
		  JPanel panel_1 = new JPanel();
		  panel_1.setBounds(148, 62, 545, 300);
		  studentPanel.add(panel_1);
		  panel_1.setLayout(new BorderLayout(0, 0));
		  
		  JScrollPane scrollPane = new JScrollPane();
		  panel_1.add(scrollPane);
		  
		  studentTable = new JTable();
		  
		  studentModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							
						"Cne", "Nom", "Prenom", "Telephone", "Filiere"
					}
				);
		  
		  studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  
		  studentTable.setModel(studentModel);
		  
		  scrollPane.setViewportView(studentTable);
		  
		  studentTable.setFillsViewportHeight(true);
		  
		
          //////////////////////////////////////////////// 
		  JScrollPane scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBounds(34, 85, 627, 260);
		  departementPanel.add(scrollPane_2);
		  
		  departTable = new JTable();
		  departModel = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								
							"code", "libelle"
						}
					);
		  
		  departTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  
		  departTable.setModel(departModel);
		  
		  scrollPane_2.setViewportView(departTable);
		  
		  departTable.setFillsViewportHeight(true);
		  
	

		 ///////////////////////////////////////////		 
		 JScrollPane scrollPane_3 = new JScrollPane();
		 scrollPane_3.setBounds(170, 65, 503, 301);
		 filierePanel.add(scrollPane_3);
		 filTable = new JTable();
		 
		 filModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							
						"code", "libelle","departement"
					}
				);
		 
		 filTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 
		 filTable.setModel(filModel);
		 
		 scrollPane_3.setViewportView(filTable);
		 
		 filTable.setFillsViewportHeight(true);
		 
		 
	 }
	 
	public void addJTextFieldComponentsForStudents() {
		
		 cneTextField = new JTextField();
		 cneTextField.setBounds(12, 83, 114, 19);
		 studentPanel.add(cneTextField);
		 cneTextField.setColumns(10);
		 
		 JLabel lblNewLabel = new JLabel("CNE:");
		 lblNewLabel.setBounds(12, 62, 70, 15);
		 studentPanel.add(lblNewLabel);
		 
		 prenomTextField = new JTextField();
		 prenomTextField.setColumns(10);
		 prenomTextField.setBounds(12, 139, 114, 19);
		 studentPanel.add(prenomTextField);
		 
		 NomTextField = new JTextField();
		 NomTextField.setColumns(10);
		 NomTextField.setBounds(12, 187, 114, 19);
		 studentPanel.add(NomTextField);
		 
		 telTextField = new JTextField();
		 telTextField.setColumns(10);
		 telTextField.setBounds(12, 238, 114, 19);
		 studentPanel.add(telTextField);
		 
		 filComboBox = new JComboBox<ComboBoxItem>();
		 filComboBox.setBounds(12, 268, 114, 24);
		 studentPanel.add(filComboBox);
		 
		 JLabel lblPrenom = new JLabel("Prenom:");
		 lblPrenom.setBounds(12, 114, 70, 15);
		 studentPanel.add(lblPrenom);
		 
		 JLabel lblNom = new JLabel("Nom:");
		 lblNom.setBounds(12, 160, 70, 15);
		 studentPanel.add(lblNom);
		 
		 JLabel lblTelephone = new JLabel("Telephone:");
		 lblTelephone.setBounds(12, 211, 108, 15);
		 studentPanel.add(lblTelephone);
		 
	
		 
		 serachStudentTextField = new JTextField();
		 serachStudentTextField.setBounds(495, 28, 198, 22);
		 studentPanel.add(serachStudentTextField);
		 serachStudentTextField.setColumns(10);
		 
		 JLabel lblRecherche = new JLabel("Recherche");
		 lblRecherche.setBounds(406, 26, 108, 24);
		 studentPanel.add(lblRecherche);
		
		 
	 }
	
	public void addJTextFieldComponentsForFiliere() {
	
	
	 FilTextField = new JTextField();
	 FilTextField.setBounds(22, 93, 114, 19);
	 filierePanel.add(FilTextField);
	 FilTextField.setColumns(10);
	 
	  DepartcomboBox = new JComboBox<ComboBoxItem>();
	 DepartcomboBox.setBounds(22, 124, 114, 24);
	 filierePanel.add(DepartcomboBox);
	 
	 JLabel lblNewLabel_2 = new JLabel("Libelle :");
	 lblNewLabel_2.setBounds(22, 66, 70, 15);
	 filierePanel.add(lblNewLabel_2);
	 
	
	 
	 seachFilTextField = new JTextField();
	 seachFilTextField.setBounds(444, 34, 214, 19);
	 filierePanel.add(seachFilTextField);
	 seachFilTextField.setColumns(10);
	 
	 JLabel lblNewLabel_3 = new JLabel("Recherche :");
	 lblNewLabel_3.setBounds(328, 34, 98, 15);
	 filierePanel.add(lblNewLabel_3);
	 
}

	public void addJTextFieldComponentsForDepartement() {
	
	
	
	   JLabel lblNewLabel_1 = new JLabel("Recherche :");
	  lblNewLabel_1.setBounds(406, 44, 104, 29);
	  departementPanel.add(lblNewLabel_1);
	  
	  searchDepartTextField = new JTextField();
	  searchDepartTextField.setBounds(511, 49, 150, 19);
	  departementPanel.add(searchDepartTextField);
	  searchDepartTextField.setColumns(10);
	  
	  DepartTextField = new JTextField();
	  DepartTextField.setBounds(34, 54, 209, 19);
	  departementPanel.add(DepartTextField);
	  DepartTextField.setColumns(10);
	  
	  
	  
	  JLabel lblFiliere = new JLabel("Departement:");
	  lblFiliere.setBounds(34, 27, 190, 15);
	  departementPanel.add(lblFiliere);
	  
	  
	 
	
	
	
}
	
	public void addButtonaddEvent() {
		
		
		  JLabel erorrDepartlabel = new JLabel("");
		  erorrDepartlabel.setForeground(Color.RED);
		  erorrDepartlabel.setBounds(166, 27, 253, 15);
		  departementPanel.add(erorrDepartlabel);
			// add departement
		  JButton addDepartButton = new JButton("Ajouter");
		  addDepartButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		try {
					
					boolean check = Validation.isAllEmptyDepartForm(DepartTextField.getText());
		 			if(!check) {
		 				
		 				addDepart(DepartTextField.getText());
		 				getDepartements();
		 				erorrDepartlabel.setText("");
		 				
		 			}else {
		 				
		 				erorrDepartlabel.setText("erreurs les donnees sont incorect");
					}
					
				} catch (SQLException e) {
					erorrDepartlabel.setText("erreur de systeme");
				}
		  	}
		  });
		  
		  
		  addDepartButton.setBounds(255, 54, 117, 19);
		  departementPanel.add(addDepartButton);
		  
		// delete departement
		  JButton btnNewButton_5 = new JButton("Suprimer");
		  btnNewButton_5.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		int row = departTable.getSelectedRow();
			    try {
			    	
			    	if(row!=-1) {
			    		DeleteDepart(Integer.parseInt((String) departModel.getValueAt(row, 0)));
			    		getDepartements();
			    		departModel.removeRow(row);
			    	} else {
			    		JOptionPane.showMessageDialog(null, "selectione une ligne");
			    	}
			    		
					
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		  	}
		  });
		  btnNewButton_5.setBounds(34, 357, 104, 25);
		  departementPanel.add(btnNewButton_5);
		  
		
		  
		  	 JLabel ErrorFiliereLable = new JLabel("");
			 ErrorFiliereLable.setForeground(Color.RED);
			 ErrorFiliereLable.setBounds(33, 34, 254, 15);
			 filierePanel.add(ErrorFiliereLable);
			 
			 
			 // add filiere
		    JButton addFilButton = new JButton("Ajouter");
			 addFilButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		try {
			 			ComboBoxItem item =(ComboBoxItem)DepartcomboBox.getSelectedItem();
			 			boolean check = Validation.isAllEmptyFilForm(FilTextField.getText(), item);
			 			if(!check) {
			 				
			 				addfil(FilTextField.getText(), item.getCode());
			 				getAllfiliere();
			 				ErrorFiliereLable.setText("");
			 				
			 			}else {
			 				
			 				ErrorFiliereLable.setText("erreurs les donnees sont incorect");
						}
						
					} catch (SQLException e) {
						
						ErrorFiliereLable.setText("une erreurs System");
					}
			 		
			 	}
			 });
			 
			 
			 addFilButton.setBounds(22, 160, 117, 25);
			 filierePanel.add(addFilButton);
			 
			 // delete filiere
			 JButton btnSuprimer = new JButton("Suprimer");
			 btnSuprimer.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		
			 		int row = filTable.getSelectedRow();
		 		    try {
		 		    	
						
						if(row!=-1) {
							DeleteFiliere(Integer.parseInt((String) filModel.getValueAt(row, 0)));
							getAllfiliere();
							filModel.removeRow(row);  
				    	} else {
				    		JOptionPane.showMessageDialog(null, "selectione une ligne");
				    	}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
			 	}
			 });
			 
			 
			 
			 
			 
			 btnSuprimer.setBounds(170, 378, 117, 25);
			 filierePanel.add(btnSuprimer);
			 
			
			 
			 JLabel errorFormStudent = new JLabel("");
			 errorFormStudent.setForeground(Color.RED);
			 errorFormStudent.setBounds(27, 28, 322, 18);
			 studentPanel.add(errorFormStudent);
			 
			 
			  // add students
			 JButton addStudentButton = new JButton("Ajouter");
			 addStudentButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		errorFormStudent.setText("");
			 		try {
			 			   ComboBoxItem item =(ComboBoxItem)filComboBox.getSelectedItem();
			 			    boolean check = Validation.isAllEmptyStudentsForm(cneTextField.getText(), NomTextField.getText(), prenomTextField.getText(), item, telTextField.getText());
			 			            if(!check) {
			 			              
			 			            	addStudent(cneTextField.getText(),prenomTextField.getText() , NomTextField.getText(),telTextField.getText(),item.getCode());
			 			            	
			 			            }
			 			            else {
			 			            	
										errorFormStudent.setText("erreurs les donnees sont incorrect");
									}
			 			            
			 			            	
						
					} catch (SQLException e) {
						
						erorrDepartlabel.setText("erreur de systeme");
					}
			 		
			 	}
			 });
			 addStudentButton.setBounds(9, 304, 117, 36);
			 studentPanel.add(addStudentButton);
			 
			 
			 
			 
			 // delete student
			 JButton deletestudentButton = new JButton("Suprimer");
			 deletestudentButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		int row = studentTable.getSelectedRow();
			 		    try {
			 		    	
							if(row!=-1) {
								DeleteStudent((String)studentModel.getValueAt(row, 0));
								studentModel.removeRow(row);
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "selectione une ligne");
					    	}
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
			 		
			 		
			 	}
			 });
			 deletestudentButton.setBounds(143, 374, 117, 24);
			 studentPanel.add(deletestudentButton);
			 
			 
			 
			 
		  
		
		
	}
	
	public void addStudents() throws SQLException {
	 
		
		ResultSet res = ConnectionDB.excuteQuery("select * from etudiants");
		studentModel.setRowCount(0);
		while(res.next()) {
			
			 String filiere = getFiliere(res.getInt(4));
			 studentModel.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(5),filiere});
		}
		

		
 }
	public void addfilieres() throws SQLException {
	 
		
		ResultSet res = ConnectionDB.excuteQuery("select * from filiere");
		filModel.setRowCount(0);
		while(res.next()) {
			 String departement  = getDepartement(res.getInt(2));
			 filModel.addRow(new Object[]{res.getString(1),res.getString(3),departement});
		}
		

		
}
 

 
	public void addDepartemnts() throws SQLException {
	 
		
		ResultSet res = ConnectionDB.excuteQuery("select * from departements");
		departModel.setRowCount(0);
		while(res.next()) {
			
			 departModel.addRow(new Object[]{res.getString(1),res.getString(2)});
		}
		

		
}
 
	public void addStudent(String cne,String nom,String prenom,String tele, int fil) throws SQLException {
		
			 PreparedStatement  stt = ConnectionDB.prepareQuery("insert into etudiants(cne,nom,prenom,codefil,tele) values(?,?,?,?,?)");
			 
								stt.setString(1, cne);
								stt.setString(2, nom);
								stt.setString(3, prenom);
								stt.setString(5, tele);
								stt.setInt(4, fil);
								stt.execute();
								addStudents();
				
							  
}
 
	public void addDepart(String lib) throws SQLException {
		
	 PreparedStatement  stt = ConnectionDB.prepareQuery("insert into departements(lib) values(?)");
	 
						stt.setString(1, lib);
						addDepartemnts();
						stt.execute();
		
					  
}
 
 
	public void addfil(String lib,int codeDep) throws SQLException {
		
	 PreparedStatement  stt = ConnectionDB.prepareQuery("insert into filiere(lib,codeDep) values(?,?)");
	 
						stt.setString(1, lib);
						stt.setInt(2, codeDep);
						stt.execute();
					    addfilieres();
}
 
	public String getFiliere(int code) throws SQLException {
	 
	 ResultSet res = ConnectionDB.excuteQuery("select lib from filiere where code="+code);
		      res.next();
		      
	  return res.getString(1);
	 
}

	public String getDepartement(int code) throws SQLException {
	 
	 ResultSet res = ConnectionDB.excuteQuery("select lib from departements where code="+code);
		      res.next();
		      
	  return res.getString(1);
	 
}


	public void	 DeleteStudent(String cne) throws SQLException {
	 
	    ConnectionDB.excuteQuery("delete  from etudiants where cne="+cne);
	    PreparedStatement stt = ConnectionDB.prepareQuery("delete  from etudiants where cne=?");
		  stt.setString(1, cne);
		  stt.execute();
    
	
    
}


	public void DeleteFiliere(Integer code) throws SQLException {
	 
    PreparedStatement stt = ConnectionDB.prepareQuery("delete  from filiere where code=?");
	  stt.setInt(1, code);
	  stt.execute();
		  
}

	public void DeleteDepart(Integer code) throws SQLException {
	 
    PreparedStatement stt = ConnectionDB.prepareQuery("delete  from departements where code=?");
    				  stt.setInt(1, code);
    				  stt.execute();
		  
}

	public void getAllfiliere() throws SQLException {
				filComboBox.removeAllItems();
				filComboBox.addItem(new ComboBoxItem(0, "filieres"));
				ResultSet res = ConnectionDB.excuteQuery("select code,lib from filiere");
     			while(res.next()) {
     				int code = res.getInt(1);
     				String libString =res.getString(2);
     				filComboBox.addItem(new ComboBoxItem(code, libString));
     			
    	 }
     
}




	public void getDepartements() throws SQLException {
		
	DepartcomboBox.removeAllItems();
	DepartcomboBox.addItem(new ComboBoxItem(0, "departements"));
	
	ResultSet res = ConnectionDB.excuteQuery("select code,lib from departements");
	
		while(res.next()) {
				int code = res.getInt(1);
				String libString = res.getString(2);
				DepartcomboBox.addItem(new ComboBoxItem(code, libString));
				
}

}

	public void ActiveSearchFor(JTable table,TableModel model,JTextField textField) {
	
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
    table.setRowSorter(sorter);
    
	 textField.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
           search(textField.getText());
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
           search(textField.getText());
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
           search(textField.getText());
        }
        
        public void search(String str) {
           if (str.length() == 0) {
              sorter.setRowFilter(null);
           } else {
           	
              sorter.setRowFilter(RowFilter.regexFilter(str));
           }
        }
     });
		 
}
}






