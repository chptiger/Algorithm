package basicQuestions.String;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import utilities.ConstantsUtil;
import utilities.StringUtil;

/**
Description
    Find all anagrams of a substring S2 in a long String S1
 	String s2 = "aabc";
 	String s1 = "zzzzcdebcaabcyywwww";

anagrams
Anagrams don't necessarily have to use all the letters, but they normally do.
"rail safety" = "fairy tales"
"roast beef" = "eat for BSE"

An anagram which means the opposite of its subject is called an "antigram". For example:
"restful" = "fluster"
"funeral" = "real fun"
"adultery" = "true lady"

 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 
 * @author xx65
 *
 */
public class allAnagramSubstringLongString_Advanced4_2 {

	@Test
	public void test_UniqueSubstring() {
		String target = "aabc";
		String input = "zzzzcdebcaabcyywwww";
		int[] expected = {7, 9};
		Assert.assertArrayEquals(ConstantsUtil.FAIL, expected, uniqueSubstring(input.toCharArray(), target.toCharArray()));
	}

	private int[] uniqueSubstring(char[] input, char[] target) {
		if(input == null || target == null || input.length < target.length) {
			return null;
		}
		Map<Character, Integer> container = new HashMap<>();
		StringUtil.addStringToMap(container, target);
		int slow = 0, fast = 0, type_of_letters_to_match = container.size();
		while(fast < input.length) {
			if(container.containsKey(input[fast])) {
				
			} else {
				fast++;
			}
		}
		return null;
	}

	
}
