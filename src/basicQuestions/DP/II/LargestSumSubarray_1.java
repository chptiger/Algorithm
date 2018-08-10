package test;

import org.junit.Assert;
import org.junit.Test;

/*
Description

Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions
The given array is not null and has length of at least 1.

Examples
	{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
	
	{-2, -1, -3}, the largest subarray sum is -1
*/

public class LargestSumSubarray_1 {
	
	@Test
	public void test_largestSumSubarry() {
		Assert.assertEquals(0, largestSum(new int[]{0, -1, -2, -3}));
        Assert.assertEquals(10, largestSum(new int[]{1, 2, 3, 4, -1}));
        Assert.assertEquals(109, largestSum(new int[]{1, 2, 3, 4, -1, 100}));
        Assert.assertEquals(5, largestSum(new int[]{2, -1, 4, -2, 1}));
        Assert.assertEquals(-1, largestSum(new int[]{-2, -1, -3}));
	}
	
//	TODO to check it again
	private static int largestSum(int[] input) {
		int[] result = new int[input.length];
		result[0] = input[0];
		int max = Integer.MIN_VALUE;
		int tmp = Integer.MIN_VALUE;
		for (int i = 1; i < input.length; i++) {
			if (input[i] > 0) {
				result[i] = result[i - 1] + input[i];
			} else if (result[i - 1] + input[i] > 0) {
				result[i] = result[i - 1] + input[i];
			} else {//result[i - 1] + input[i] <= 0
				result[i] = Math.max(Math.max(result[i - 1], input[i]), //0, -1, -2, -3
						Math.max(result[i - 1] + input[i], input[i]));  //-2, -1, -3
			}
			max = Math.max(max, result[i]);
		}
		return max;
	}
}
