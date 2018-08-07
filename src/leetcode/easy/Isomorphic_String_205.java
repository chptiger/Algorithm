package leetcode.easy;
/*

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

2 condition:
1. s1.length() == s2.length();
2. same copy positions 

solution:
1. double for circle
2. not the same character position is same, copy position will be the same.
*/
import java.util.HashMap;
public class Isomorphic_String_205{
	public static void main(String[] args){
		String s1 = "papers";
		String s2 = "tittle";
		//boolean flag = isIsmorphic(s1, s2);
		boolean flag =isIsomorphic_int(s1, s2);
		System.out.println(flag);
	}
	
	public static boolean isIsmorphic(String s1, String s2){
		if(s1 == null || s2 == null || s1.length()!= s2.length()) return false;
		HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
		
		for(int i = 0; i < s1.length(); i++){
			if(!m1.containsKey(s1.charAt(i))) m1.put(s1.charAt(i), i);
			if(!m2.containsKey(s2.charAt(i))) m2.put(s2.charAt(i), i);
			if(m1.get(s1.charAt(i)) != m2.get(s2.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/*
	The main idea is to store the last seen positions of current (i-th) characters in both strings. 
	
	If previously stored positions are different then we know that 
	the fact they're occuring in the current i-th position simultaneously is a mistake. 
	
	We could use a map for storing but as we deal with chars 
	which are basically ints and can be used as indices we can do the whole thing with an array.
	*/
	 public static boolean isIsomorphic_int(String s1, String s2) {
        int[] m = new int[512];// default value is 0
        for (int i = 0; i < s1.length(); i++) {
            //if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;// i == 0, default value is 0 == 0
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
			//System.out.println(m[s1.charAt(i)]);
        }
		
		for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;// i == 0, default value is 0 == 0
            //m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
			//System.out.println(m[s1.charAt(i)]);
        }
        return true;
    }
	
	
	
	/*
	Time Limit Exceeded
	
	public static boolean isIsmophic(String s1, String s2){
		if(s1 == null || s2 == null || s1.length()!= s2.length()) return false;
		
		for(int i = 0; i< s1.length(); i++){
			for(int j = i+1; j< s2.length(); j++){
				if(s1.charAt(i) == s1.charAt(j) && s2.charAt(i) == s2.charAt(j)) continue;
				else if(s1.charAt(i) != s1.charAt(j) && s2.charAt(i) != s2.charAt(j)) continue;
				else return false;
			}
		}
		return true;
	}
	
	*/
}