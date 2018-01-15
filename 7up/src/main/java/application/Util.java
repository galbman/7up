package application;

public class Util {

	public static String convertCardNumber(int val) {
		if (val > 0 && val < 11) {
			return Integer.toString(val);
		}
		if (val == 11) 
			return "J";
		if (val == 12) 
			return "Q";
		if (val == 13) 
			return "K";
		else 
			throw new IllegalArgumentException("Card val must be between 1 and 13");
	}
	
	public static boolean isEmpty(String str) {
		return (str == null || str.isEmpty());
	}
	
}
