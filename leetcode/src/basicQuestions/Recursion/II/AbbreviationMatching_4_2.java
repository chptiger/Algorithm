package basicQuestions.Recursion.II;

import org.junit.Test;

import junit.framework.Assert;
import utilities.StringUtil;

/*
Word "book" can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation,
return if the string matches the abbreviation.
        Assumptions:
        The original string only contains alphabetic characters.
        Both input and pattern are not null.
        Examples:
        pattern "s11d" matches input "sophisticated" since "11" matches eleven chars "ophisticate".
        Medium
        Recursion
        String
 */
public class AbbreviationMatching_4_2 {
	
	@Test
	public void test_stringReverse() {
		String input = "abcd";
		Assert.assertEquals("dcba", reverseString(input.toCharArray()));
	}
	
	public static String reverseString(char[] input) {
		if(input == null || input.length <= 1) {
			return new String(input);
		}
		 recursionHelper(input, 0, input.length - 1);
		 return new String(input);
	}
	
	public static void recursionHelper(char[] input, int start, int end) {
		if(start >= end) {
			return;
		}
		
		StringUtil.swap(input, start++, end--);
		recursionHelper(input, start, end);
	}
}
