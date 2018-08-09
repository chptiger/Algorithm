package basicQuestions.DP.I;

import org.junit.Assert;
import org.junit.Test;

/*
Description
Jump Game
Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
Determine if you are able to reach the last index.
Assumptions
The given array is not null and has length of at least 1.
Examples
{1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
{2, 1, 1, 0, 2}, we are not able to reach the end of array
*/

public class ArrayHopperI_4 {
	
	@Test
	public void test_arrayHopper() {
		int[] a1 = {2, 1, 0, 3, 4};
		int[] a2 = {2, 3, 0, 3, 4};
		
		Assert.assertEquals(false, isArrayHopper(a1));
		Assert.assertEquals(true, isArrayHopper(a1));
	}
	
	private static boolean isArrayHopper(int[] input) {
		
		boolean[] M = new boolean[input.length];
		
		M[input.length - 1] = input[input.length - 1] > 0 ? true : false;
		
		int i = input.length - 2;
		for(; i >= 0; i--) {
			int j = i + 1;
			for(; j <= input.length - 1; j++) {
				if(M[j] && i + input[i] >= j) {
					M[i] = true;
				} 
			}
		}
		return M[0];
	}
}
