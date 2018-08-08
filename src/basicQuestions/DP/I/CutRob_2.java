package basicQuestions.DP.I;

import org.junit.Assert;
import org.junit.Test;

public class CutRob_2 {

	@Test
	public void test_cutRob() {
		int n = 10;
		Assert.assertEquals(36, cutRobDP(n)); // 3, 3 4
	}
//	O(n^2)
	public static int cutRobDP(int n) {
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
}
