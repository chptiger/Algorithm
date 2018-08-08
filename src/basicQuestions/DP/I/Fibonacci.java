package basicQuestions.DP.I;

import org.junit.Assert;
import org.junit.Test;

public class Fibonacci {
	
	@Test
	public void test_fibonacci() {
		int n = 5;
		Assert.assertEquals(5, fibonacciRecursion(5));// 0 1 1 2 3 5
		Assert.assertEquals(5, fibonacciDP(6));
	}
	
//	time: 2^n   space: 1
	public static int fibonacciRecursion(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
	}
	
//	time: n space:n
	public static int fibonacciDP(int n) {
		int[] result = new int[n];
		result[0] = 0;
		result[1] = 1;
		for(int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n - 1];
	}
}
