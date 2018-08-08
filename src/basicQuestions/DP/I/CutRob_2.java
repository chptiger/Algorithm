package basicQuestions.DP.I;

import org.junit.Assert;
import org.junit.Test;

public class CutRob_2 {

	@Test
	public void test_cutRob() {
		int n = 10;
		Assert.assertEquals(36, cutRobDP(n)); // 3, 3 4
	}
	// 1 0
	// 2 1    3 1,0 1; 2, 1 = 2
	// 4 1 3
	public static int cutRobDP(int n) {
		if(n <= 1) {
			return 0;
		}
		int[] M = new int[n + 1];
		int global = 0;
		for(int i = 2; i <= n; i++) { // the length of rob
			for(int j = 1; j <= i/2; j++) {// how to cut the rob, from start to the middle, one by one
				M[i] = Math.max(j, M[j]) * Math.max((i - j), M[i - j]);
			}
			global = Math.max(global, M[i]);
		} 
		return global;
	}
}
