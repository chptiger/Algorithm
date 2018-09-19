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
package leetcode.easy;

import java.util.*;

public class Valid_Anagram_242 {
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		boolean l = Valid_Anagram(s, t);
		System.out.println("check anagram " + l);
	}

	public static boolean Valid_Anagram(String s, String t) {
		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();
		// System.out.println(Arrays.toString(s1));
		// System.out.println(Arrays.toString(s2));
		if (s.length() != t.length())
			return false;
		int l = s2.length;
		// System.out.println(s2.length);
		for (int m = 0; m < l; m++) {
			for (int i = 0; i < l; i++) {
				// System.out.println(s1[i]);
				if (s1[i] == s2[m]) {
					s1[i] = '\u0000';
					s2[m] = '\u0000';
					System.out.println(s1[i]);
					System.out.println(s2[m]);
					break;
				}
				// System.out.println(s1[i]);
			}
		}

		System.out.println(Arrays.toString(s1));
		System.out.println(Arrays.toString(s2));
		for (int i = 0; i < l; i++) {
			if (s1[i] != '\u0000')
				return false;
		}

		for (int i = 0; i < l; i++) {
			if (s2[i] != '\u0000')
				return false;
		}
		return true;
	}
}