package basicQuestions.DP.I;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
Assumptions
The given array is not null
Examples
{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
*/
public class LongestAscendingSubarray_2 {
	
	@Test
	public void test_longestAscendingSubarray() {
		int[] input = {7, 3, 2, 3, 5, 7, 9, 10, 7, 9};
		Assert.assertEquals(6, findLongestAscendingSubarrayDP(input));
		int[] result = new int[2];
		Assert.assertEquals(6, findLongestAscendingSubarrayRecursive(input, 1, result));
	}
	
	
//	DP
	private int findLongestAscendingSubarrayDP(int[] input) {
		if(input.length <= 1) {
			return 1;
		}
		
		int count = 0, max = 0;
		for(int i = 1; i < input.length; i++) {
			if(input[i] > input[i - 1]) {
				count++;
			} else {
				count = 1;
			}
			max = Math.max(count, max);
		}
		return max;
	}
	
	
//	Recursive
	private int findLongestAscendingSubarrayRecursive(int[] input, int index, int[] result) {
		if(input.length <= 1) {
			return 1;
		}
		if(index == input.length) {
			return result[1];
		}
		if(input[index] > input[index - 1]) {
			result[0] = result[0] + 1;
		} else {
			result[0] = 1;
		}
		result[1] = Math.max(result[1], result[0]);
		return findLongestAscendingSubarrayRecursive(input, index + 1, result);
	}
}
