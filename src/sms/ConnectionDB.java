package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	
	public static Connection con;
	
	public static void  connect() {
		
		try {
			 con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms?user=root&password=root");
		     System.out.println("connected");
		   
		     
		} catch(SQLException e) {
			
			 System.out.println("not connected");
			System.out.println(e);
			
			}
	}
	
	public static synchronized ResultSet excuteQuery(String query) throws SQLException {
		
		Statement stt = con.createStatement();;
		ResultSet res=null;
		
		  try {
				res = stt.executeQuery(query);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
			return res;
	}
	
	
	public static PreparedStatement prepareQuery(String query) {
		
		PreparedStatement stt=null;
		
		try {
			
			stt =  con.prepareStatement(query);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return stt;
	}


}
