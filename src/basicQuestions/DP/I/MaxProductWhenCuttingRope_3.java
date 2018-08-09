package basicQuestions.DP.I;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]p[1] ... p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
Assumptions
n >= 2
Examples
n = 12, the max product is 3 3 3 3 = 81(cut the rope into 4 pieces with length of each is 3).
*/
public class MaxProductWhenCuttingRope_3 {
	
	@Test
	public void test_maxProductWhenCuttingRope() {
		int n = 10;
		Assert.assertEquals(36, ropeCut(n));
		Assert.assertEquals(36, cutRobDPLR(n));
	}
	
//	O(n^2) left to right
	public static int cutRobDPLR(int n) {
		if(n <= 1) {
			return 0;
		}
		int[] M = new int[n + 1];
		int global = 0;
		for(int i = 2; i <= n; i++) { // the length of rob, increasing by 1 meter every time
			for(int j = 1; j <= i/2; j++) {// how to cut the rob, from start to the middle, one by one; 左大段的所有可能性
				M[i] = Math.max(j, M[j]) * Math.max((i - j), M[i - j]);
			}
			global = Math.max(global, M[i]);
		} 
		return global;
	}
	
//	O(n^2) right to left
	public static int cutRobDPRL(int n) {
		if(n <= 1) {
			return 0;
		}
		int[] M = new int[n + 1];
		int global = 0;
		for(int i = 2; i <= n; i++) { // the length of rob, increasing by 1 meter every time
			for(int j = 1; j < i; j++) {// how to cut the rob, from right to left, one by one; 右小段的所有可能性
				M[i] = j * Math.max((i - j), M[i - j]); // j 是右小段的长度，固定的，不在切割
			}
			global = Math.max(global, M[i]);
		} 
		return global;
	}
	
//	Recursion
	public static int ropeCut(int n) {
		if(n == 1) {
			return 0;
		}
		
		int max = 0;
		for(int i = 1; i < n ; i++) {							// right fix cutted rop
			int maxProduct = Math.max(n - i, ropeCut(n - i));   //left part largest count 
			max = Math.max(max, i * maxProduct);
		}
		return max;
	}
}
