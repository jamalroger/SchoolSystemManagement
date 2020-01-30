package sms;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		
		ConnectionDB.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Home();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
