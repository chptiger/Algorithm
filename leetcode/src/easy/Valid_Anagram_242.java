/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
package easy;
import java.util.*;
public class Valid_Anagram_242{
	public static void main(String[] args){
		String s = "anagram";
		String t = "nagaram";
		boolean l = Valid_Anagram(s, t);
		System.out.println("check anagram " + l);
	}
	
	public static boolean Valid_Anagram(String s, String t){
		String[] s1 = s.split("");
		String[] s2 = t.split("");
	//	System.out.println(Arrays.toString(s1));
	//	System.out.println(Arrays.toString(s2));
		if(s.length() != t.length()) return false;
		
		//System.out.println(s2.length);
			for(int m = 0;m<s2.length;m++){
				for(int i=0; i< s1.length; i++){
					//System.out.println(s1[i]);
					if(s1[i] == s2[m]){
						s1[i] = null;
						s2[m] = null;
						System.out.println(s1[i]);
						System.out.println(s2[m]);
						break;
					}
				//System.out.println(s1[i]);
				}
			}
		
		System.out.println(Arrays.toString(s1));
		System.out.println(Arrays.toString(s2));
		for(int i = 0; i< s1.length;i++){
			if(s1[i] != null)return false;
		}
		
		for(int i = 0; i< s2.length;i++){
			if(s2[i] != null)return false;
		}
		return true;
	}
}