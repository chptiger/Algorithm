package basicQuestions.Recursion.II;

import org.junit.Test;

import junit.framework.Assert;
import utilities.StringUtil;

/**
 reverse a string using recursion
		abcd -> dcba


 * @author xx65
 *
 */
public class StringReverse_RecursionII_4_1 {
	
	@Test
	public void test_stringReverse() {
		String input = "abcd";
		Assert.assertEquals("dcba", reverseString(input.toCharArray()));
	}
	
	public static String reverseString(char[] input) {
		if(input == null || input.length <= 1) {
			return new String(input);
		}
		return recursionHelper(input, 0, input.length - 1);
	}
	
	public static String recursionHelper(char[] input, int start, int end) {
		if(start >= end) {
			return new String(input);
		}
		
		StringUtil.swap(input, start++, end--);
		recursionHelper(input, start, end);
		return new String(input);
	}
}
