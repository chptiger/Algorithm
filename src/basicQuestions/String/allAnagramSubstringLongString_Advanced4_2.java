package basicQuestions.String;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import utilities.ConstantsUtil;
import utilities.StringUtil;

/**
 * Description Find all anagrams of a substring S2 in a long String S1 String s2
 * = "aabc"; String s1 = "zzzzcdebcaabcyywwww";
 * 
 * anagrams Anagrams don't necessarily have to use all the letters, but they
 * normally do. "rail safety" = "fairy tales" "roast beef" = "eat for BSE"
 * 
 * An anagram which means the opposite of its subject is called an "antigram".
 * For example: "restful" = "fluster" "funeral" = "real fun" "adultery" = "true
 * lady"
 * 
 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit
 * 
 * @author xx65
 * 
 *         TODO: rewrite this question 2 times
 *
 */
public class allAnagramSubstringLongString_Advanced4_2 {

	@Test
	public void test_UniqueSubstring() {
		String target = "aabc";
		// String input = "zzdebcaabcyyw";
		String input = "zccebcaabcyyw";
		Assert.assertEquals(ConstantsUtil.FAIL, "456", anagramSubstring(input.toCharArray(), target.toCharArray()));
	}

	/*
	 * Using fix length slide window with size target.length() to solve this
	 * question Minus method was used in the solution. I could use 0 to identify the
	 * substring(all characters in the array). fast pointer is the right-hand side
	 * of window, slow pointer is the left-hand side window At the beginning, the
	 * fast pointer <= target.length(); fast++ and do not need to consider the
	 * left-hand side When the fast pointer > target.length(), we need consider both
	 * side of the window. For fast pointer(right-hand side of the slide widow):
	 * check if the next character is in target and how many count number of that
	 * character we have. For slow pointer(left-hand side of the slide window):
	 * check the current index character is in the target and how many count number
	 * of that character we have.
	 * 
	 * initial value container a:2, b:1, c:1; type_of_letters_to_match = 3(no
	 * duplicate character)
	 * 
	 * 
	 */

	private String anagramSubstring(char[] input, char[] target) {
		StringBuilder sb = new StringBuilder();
		if (input == null || target == null || input.length < target.length) {
			return new String(sb);
		}
		Map<Character, Integer> container = new HashMap<>();
		StringUtil.addStringToMap(container, target);

		int slow = 0, fast = 0, type_of_letters_to_match = StringUtil.getUniqueCharacterLength(target);

		while (fast < input.length) {
			// right side; to treat the new element if the element was contained in the
			// target string, removing counting number both in HashMap and
			// type_of_letters_to_match
			if (container.containsKey(input[fast])) {
				container.replace(input[fast], container.get(input[fast]) - 1);
				if (container.get(input[fast]) == 0) {
					type_of_letters_to_match--;
					if (type_of_letters_to_match == 0) {
						sb.append(slow);
					}
				}
			}

			// left side; to treat the left side element if the element was contained in the
			// target string, adding counting number both in HashMap and
			// type_of_letters_to_match
			if ((fast - slow) == (target.length - 1)) { // initialize the fixed sliding window
				if (container.containsKey(input[slow])) {
					if (container.get(input[slow]) == 0) {
						type_of_letters_to_match++;
					}
					container.replace(input[slow], container.get(input[slow]) + 1);
				}
				slow++;
			}
			// checking next character
			fast++;
		}
		return new String(sb);
	}
}
