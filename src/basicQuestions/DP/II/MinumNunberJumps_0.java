package basicQuestions.DP.II;

import org.junit.Assert;
import org.junit.Test;

/*
Description:
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.

A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).

Determine the minimum number of jumps you need to reach the end of array.

If you can not reach the end of the array, return -1.

Assumptions
The given array is not null and has length of at least 1.

Examples
	{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
M[i] 2  1 -1 -1  0

	{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
M[i]-1 -1 -1  -1 0 
*/
public class MinumNunberJumps_0 {
	@Test
	public void test_minumNunberJumps() {
		Assert.assertEquals(2, minJump(new int[] { 3, 3, 1, 0, 4 }));
		Assert.assertEquals(-1, minJump(new int[] { 2, 1, 1, 0, 2 }));
		Assert.assertEquals(2, minJump(new int[] { 3, 3, 1, 0, 4 }));
//		Assert.assertEquals(-1, minJump2(new int[] { 2, 1, 1, 0, 2 }));
	}
	
	private static int minJump(int[] input) {
		int[] min = new int[input.length];
		min[input.length - 1] = input[input.length - 1] > 0 ? 0 : -1;
		
		for(int i = input.length - 2; i >= 0; i--) {
			int minStep = -1;
			for(int j = i + 1; j <= input.length - 1; j++) {
				if(min[j] >= 0 && i + input[i] >= j) {
					minStep = minStep < 0 ? Math.max(minStep, 1 + min[j]) : Math.min(minStep, 1 + min[j]);
				}
			}
			min[i] = minStep;
		}
		return min[0];
	}
}
