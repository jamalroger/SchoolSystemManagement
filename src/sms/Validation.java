package sms;

public class Validation {
	
	public static boolean verifyTele(String teleString) {
		 
		if(teleString.length()!=10)
			return false;
		try {
			
			Integer.parseInt(teleString);
			
		} catch (Exception e) {
			
			return false;
		}
		
		return  true;
	}
	
	public static Boolean isAllEmptyStudentsForm(String cne,String nom,String prenom,ComboBoxItem item,String tele) {
		
		return nom.isEmpty() || prenom.isEmpty() || cne.isEmpty() || item.getCode()==0 ||  !verifyTele(tele);
	}
	
	public static Boolean isAllEmptyFilForm(String lib,ComboBoxItem item) {
		
		return lib.isEmpty() || item.getCode()==1;
	}
	
	public static Boolean isAllEmptyDepartForm(String lib) {
		
		return lib.isEmpty();
	}
	

}
