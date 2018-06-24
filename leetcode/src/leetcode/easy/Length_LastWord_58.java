package leetcode.easy;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

String s = â€œâ€?; 	 String[] tmp = s.split(" ");			//	s.length() = 0;	tmp.length =1	[]
String s = â€œ â€?; 	String[] tmp = s.split(" ");		//	s.length() = 1;	tmp.length =0 	[]
String s = â€œ     â€?; 	String[] tmp = s.split(" ");	//	s.length() = 5;	tmp.length =0	[]

*/
import java.util.Arrays;
public class Length_LastWord_58{
	public static void main(String[] args){
		String s = "    ";//"dfd "   " dfd"
		System.out.println("s length " + s.length());
		int i = Length_LastWord(s);
		
		//System.out.println("last length of word is " + i);
	}
	
	public static int Length_LastWord(String s){
		if( s == null) return 0;

		String[] tmp = s.split(" ");
	
		int i = tmp.length;
		if( i == 0) return 0;
		String last = tmp[i - 1];
		return last.length();
	}
}