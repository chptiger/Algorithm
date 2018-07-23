package basicQuestions.String;

import org.junit.Assert;
import org.junit.Test;

import utilities.ConstantsUtil;

/**
Description
        Given a 0 - 1 array, you can flip at most k 0 to 1, Please find the longest subarray that consist of all 1

sliding window: the window can contain At Most k 0 

 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 
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

	private static int longestSubarray(char[] input, int k) {
		if(input == null || input.length < k) {
			return -1;
		}
		int result = 0, slow = 0, fast = 0, count = k;
		while(fast < input.length) {
//			 right-hand side
				if(input[fast] == 0) {
					if(count > 0) {// still inside the sliding window, we only consider the right-hand side of the sliding window
						count--;
						result++;
					} else { // need to move left-hand side of the sliding window
						if(input[slow] == 0) {
							result--;
							count++;
						} else {
							result--;
						}
					}
				} else {
					result++;
				}
//			result = Math.max(result, arg1);
//			left-hand side
			fast++;
		}
		return result;
	}
}
