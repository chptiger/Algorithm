package basicQuestions.String;

import org.junit.Assert;
import org.junit.Test;

import utilities.ConstantsUtil;

/**
 * Description Given a 0 - 1 array, you can flip at most k 0 to 1, Please find
 * the longest subarray that consist of all 1
 * 
 * sliding window: the window can contain At Most k 0
 * 
 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit
 * 
 * @author xx65
 *
 */
public class LongestSubarrayContains1_Advanced4_3 {

	@Test
	public void test_UniqueSubstring() {
		String input = "0001010101000";
		int k = 4;
		Assert.assertEquals(ConstantsUtil.FAIL, 8, longestSubarray(input.toCharArray(), k));
	}

	// keep there are max k 0 in the slide window.
	private static int longestSubarray(char[] input, int k) {
		if (input == null || input.length < k) {
			return -1;
		}
		int result = 0, slow = 0, fast = 0, max = 0;

		/*
		 * there are two cases for right-hand side and left-hand side. fast pointer:
		 * 
		 * if (input[fast] == '0') { // next is 0 k--; result++; } else { // next is 1
		 * result++; } fast++; result++;
		 * 
		 * merge the code to make it more concise.
		 */
		while (fast < input.length) {
			// right-hand side. add new 1 or 0 and count it.
			if (input[fast] == '0') {
				k--;
			}
			fast++;
			result++;

			// left-hand side. need to move, until removing the last 0
			while (k < 0) { // the index of slow could be 1 or 0, we need keep moving until removing last 0,
							// to keep the fixed 0 length in the sliding window
				if (input[slow] == '0') {
					k++;
				}
				result--;
				slow++;
			}
			max = Math.max(max, result);
		}
		return max;
	}
}
