package basicQuestions.DP.II;

import org.junit.Assert;
import org.junit.Test;

/*
Description

	Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.
	
Assumptions

Both strings are not null

Examples

string one: “sigh”, string two : “asith”

the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).

https://github.com/cliu0571/MyCodePractice/blob/master/DynamicProgrammingII/src/com/myCodePractice/Class13/EditDistance.java 

*/

public class EditDistance_3 {
	
	@Test
    public void test_distance() {
        Assert.assertEquals(4, editDistance("asdf", "sghj"));
        Assert.assertEquals(5, editDistance("", "asith"));
        Assert.assertEquals(2, editDistance("sigh", "asith"));
    }
	
/**
 * input: first i letters -> how to convert to 
 * target: first j letters
 * M[i][j]
 * @param target
 * @param input
 * @return
 */
	private static int editDistance_wrong( String input, String target) {
		if (target == null || target.length() == 0) {
			return input.length();
		}
		if (input == null || input.length() == 0) {
			return target.length();
		}
		int len = Math.max(target.length(), input.length());
		int[][] M = new int[len][len];
		M[0][0] = input.charAt(0) == target.charAt(0) ? 0 : 1; // How many steps to transfer the first letter from input to target.
		for(int i = 1; i < len; i++) {
			for(int j = 1; j < len; j++) {
				if(input.charAt(i - 1) == target.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else {
					int min1 = Math.min(1 + M[i - 1][j - 1], 1 + M[i - 1][j]);
					int min2 = Math.min(1 + M[i][j - 1], 1 + M[i - 1][j]);
					M[i][j] = Math.min(min1, min2);
				}
			}
		}
		return M[len - 1][len - 1];
	}
	
	/**
	 * input: first i letters -> how to convert to 
	 * target: first j letters
	 * M[i][j]
	 * @param target
	 * @param input
	 * @return
	 */
	private static int editDistance(String input, String target) {
		if (target == null || target.length() == 0) {
			return input.length();
		}
		if (input == null || input.length() == 0) {
			return target.length();
		}

		int[][] M = new int[input.length() + 1][target.length() + 1];
		
		for(int i = 0; i <= input.length(); i++) {
			for(int j = 0; j <= target.length(); j++) {
				if(i == 0) {
					M[i][j] = j;
				} else if(j == 0) {
					M[i][j] = i;
				} else if(input.charAt(i - 1) == target.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else {
					M[i][j] = 1 + Math.min(M[i - 1][j - 1], Math.min(M[i][j - 1], M[i - 1][j]));
				}
			}
		}
		return M[input.length()][target.length()];
	}
	
}
