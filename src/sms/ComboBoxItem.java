package sms;

class ComboBoxItem{
	private int code;
	private String libString;
	
	public ComboBoxItem(int code,String liString) {
		this.code=code;
		this.libString=liString;
		
		
	}
	
	public int getCode() {
		
		
		return code;
	}
	public String getLib() {
		
		return libString;
	}
	public String toString() {
		
		return libString;
	}
}