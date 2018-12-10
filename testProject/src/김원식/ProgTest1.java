package ±è¿ø½Ä;

public class ProgTest1 {
	
	public static int cVar = 0;
	String[] iStr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	double iDouble;
	boolean iBool = false;
	char iChar = 'a';
	
	String getGugudan(int dan) {
		String rs = dan + "´Ü : \n" ;
		for(int i = 1; i < 10; i++) {
			rs += dan + "*" + i + ":" + (dan*i) + "\t"; 
		}
		return rs.substring(0, rs.length() -1);
	}
}
