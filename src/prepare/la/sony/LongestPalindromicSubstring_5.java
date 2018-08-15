package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

/**
 * A palindrome is a string which reads the same in both directions. For example, SS = "aba" is a palindrome, SS = "abc" is not.
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

	Example 1:
		Input: "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
		
	Example 2:
		Input: "cbbd"
		Output: "bb"

Solution:
	https://leetcode.com/problems/longest-palindromic-substring/solution/
	http://www.cnblogs.com/grandyang/p/4464476.html
	https://www.cnblogs.com/yuzhangcmu/p/4189068.html
	
 * @author xx65
 *
 */
public class LongestPalindromicSubstring_5 {
	
	@Test
	public void test_longestPalindromicSubsring() {
		String input = "babad";
		Assert.assertEquals("bab", longestPalindromicSubsring(input.toCharArray()));
	}
	
	private static String longestPalindromicSubsring(char[] input) {
		if(input == null) {
			return null;
		}
		boolean[][] isP = new boolean[input.length][input.length];
		String result = "";
		
	}
}
