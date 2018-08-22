package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 * @author xx65
 *
 */
public class RegularExpressionMatching_10 {
	
	@Test
	public void test_regualreExpressionMatching() {
		Assert.assertEquals(false, regulareExpressionMatching("mississippi", "mis*is*p*."));
		Assert.assertEquals(true, regulareExpressionMatching("aab", "c*a*b"));
		Assert.assertEquals(true, regulareExpressionMatching("ab", ".*"));
		
		Assert.assertEquals(false, regulareExpressionMatching_recursion("mississippi", "mis*is*p*."));
		Assert.assertEquals(true, regulareExpressionMatching_recursion("aab", "c*a*b"));
		Assert.assertEquals(true, regulareExpressionMatching_recursion("ab", ".*"));
	}
	
//	https://www.youtube.com/watch?v=l3hda49XcDE&list=PLrmLmBdmIlpuE5GEMDXWf0PWbBD9Ga1lO
	private static boolean regulareExpressionMatching(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		
		dp[0][0] = true;
//		matching a*, a*b*, a*b*c*......
		for(int i = 1; i < p.length(); i++) {
			if(p.charAt(i) == '*') {
				dp[0][i + 1] = dp[0][i - 1]; // 2D start from 1 - string.length()
			}
		}
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < p.length(); j++) {
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ) {
					dp[i + 1][j + 1] = dp[i][j];// abc ab./abc  c == c
				} else if(j >= 1 && p.charAt(j) == '*') {// abc ab*
					dp[i + 1][j + 1] = dp[i + 1][j - 1];
					if(s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
						dp[i + 1][j + 1] = dp[i + 1][j + 1] || dp[i][j + 1];
					}
				} else {
					dp[i + 1][j + 1] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	
	// s.substring(): n 
//	bad case: binary tree: (s + p) * 2 ^ (s + p/2)
//	 https://leetcode.com/problems/regular-expression-matching/solution/
//	https://www.jianshu.com/p/85f3e5a9fcda
	private static boolean regulareExpressionMatching_recursion(String s, String p) {
		if(p == null || p.length() == 0) {
			return (s == null || s.length() == 0);
		}
		
		boolean firstMatch = s.length() > 0 && s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
		
		if(p.length() >= 2 && p.charAt(1) == '*') {
			return regulareExpressionMatching(s, p.substring(2))|| firstMatch && regulareExpressionMatching(s.substring(1), p);
		} else {
			return firstMatch && regulareExpressionMatching(s.substring(1), p.substring(1));
		}
	}
}
