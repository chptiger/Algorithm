/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Integer2Roman_12{
	public static void main(String[] args){
		int a = 200;
		String res = intToRoman( a );
		System.out.println( res );
	}
	
	public static String intToRoman(int num) {
        Hashtable<String, Integer> rule = new Hashtable<String, Integer>();
		if( num <= 0) return rule;		
		rule.put( "I" , 1);
		rule.put( "V" , 5);
		rule.put( "X" , 10);
		rule.put( "L" , 50);
		rule.put( "C" , 100);
		rule.put( "D" , 500);
		rule.put( "M" , 1000);
		
		
    }
}