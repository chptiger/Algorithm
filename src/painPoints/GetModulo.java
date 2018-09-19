package painPoints;

import org.junit.Assert;
import org.junit.Test;

/**
 * the get remainder / Modulo operation "%" is to get the remainder of the
 * number.
 * 
 * the num should do divide operation untill num less than count; while(num >
 * count) { num = num / count; } return num;
 * 
 * @author xx65
 *
 */
public class GetModulo {

	private static final int count = 10;

	@Test
	public void test_getModulo() {
		Assert.assertEquals(9, getModulo(99999));
	}

	private static int getModulo(int num) {
		return num % count;
	}
}
