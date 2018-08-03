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
	public void test_abbreviation() {
		String input = "sophisticatedarfg";
		String pattern = "s11da3";
		Assert.assertEquals(true, abbreviation(pattern.toCharArray(), input.toCharArray(), 0, 0));
	}

	private boolean abbreviation(char[] pattern, char[] input, int p, int i) {
		if(input.length == i && p == pattern.length) {	// only when they run out of input and pattern at the same time, there is a match.
			return true;
		} 
		if(p > pattern.length || i > input.length) {
			return false;
		}
		
//		the char is not number
		while((p < pattern.length && (pattern[p] < '0' || pattern[p] > '9'))) {
//			if(input[i] == pattern[p]) {
//				return abbreviation(pattern, input, p + 1, i + 1);
//			}
//			return false;
			if(input[i] != pattern[p]) {
				return false;
			}
			i++;
			p++;
		}
		
//		the char is number
		int count = 0;
		while(p < pattern.length && pattern[p] >= '0' && pattern[p] <= '9') {
			count = count * 10 + Integer.valueOf(pattern[p] - '0');
			p++;
		}
		
		return abbreviation(pattern, input, p, i + count);
	}
	
}
