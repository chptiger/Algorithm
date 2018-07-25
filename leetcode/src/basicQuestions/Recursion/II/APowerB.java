package basicQuestions.Recursion.II;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. 0 as the denominator
 * 2. 1/3 as an integer? or float
 * 3. 0^0
 * @author xx65
 *
 */
public class APowerB {

	@Test
	public void test_aPowerB() {
		int a = 2;
		int b = 3;
		Assert.assertEquals(8, power(a, b));
	}

	public static int power(int a, int b) {
		if (a == 0) {// vs a == 0 && b <= 0 ? which one is better?
			return 0;
		} else if (b == 0) {
			return 1;
		} else if (b < 0) {
			return 1 / powerHelper(a, -b);
		} else {
			return a * powerHelper(a, b - 1);
		}
	}

	public static int powerHelper(int a, int b) {
		if (b == 0) {
			return 1;
		}

		int half_result = powerHelper(a, b / 2);
		return b % 2 == 0 ? half_result * half_result : a * half_result * half_result;
	}
}
