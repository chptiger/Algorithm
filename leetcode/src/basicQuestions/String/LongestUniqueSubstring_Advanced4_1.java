package basicQuestions.String;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import utilities.ConstantsUtil;

/**
Description
        Given a string, find the longest substring without any repeating characters and return the length of it.
 The input string is guaranteed to be not null.

        For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
 
 When we move the R border(fast), we add information to the set.
 When we move the L border(slow), we delete information from the set.

 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 
 * @author xx65
 *
 */
public class LongestUniqueSubstring_Advanced4_1 {

	@Test
	public void test_UniqueSubstring() {
		String input = "bcdfbd";
		Assert.assertEquals(ConstantsUtil.FAIL, 4, uniqueSubstring(input.toCharArray()));
	}

	public static int uniqueSubstring(char[] input) {
		if (input == null || input.length <= 1) {
			return input.length;
		}

		Set<Character> container = new HashSet<>();
		int slow = 0, fast = 0, max_lenth = 0;
		while (fast < input.length) {
			if (container.contains(input[fast])) {
				// removing from the first letter, until the duplicated char was removed, to do the next one.
				while(container.contains(input[fast])) {
					container.remove(input[slow++]);
				}
			} else {
				container.add(input[fast++]);
				max_lenth = Math.max(max_lenth, fast - slow);
			}
		}
		return max_lenth;
	}
}
