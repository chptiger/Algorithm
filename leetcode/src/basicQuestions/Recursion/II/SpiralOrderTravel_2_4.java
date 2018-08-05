package basicQuestions.Recursion.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
Traverse an N N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

Assumptions

The 2D array is not null and has size of N N where N >= 0

Examples
{ 
  {1,  2,  3},
  {4,  5,  6},
  {7,  8,  9}
}

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]

the 2 D Array m = n matrix[m][m]

*/
public class SpiralOrderTravel_2_4 {
	
	@Test
    public void test_Spiral() {
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), spiral(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 2, 9, 8)), spiral(new int[][]{{1, 2}, {8, 9}}));
    }

	private List<Integer> spiral(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		helper(matrix, 0, matrix.length - 1, result);
		return result;
	}
	
	/*
  		offset: the current level of recursion, from 0 to matrix.size / 2
  		size: size = size - 2, the first one and last one for every row and column separately. the spiral order traverse
   */
	private void helper(int[][] matrix, int offset, int size, List<Integer> result) {
//		the size of matrix is even
		if(size == 0) {
			return;
		}
		
//		the size of matrix is odd
		if(size == 1) {
			result.add(matrix[offset][offset]);// the last in the middle of the array
			return;
		}
		
//		top row
		for(int i = 0; i < size; i++) {
			result.add(matrix[offset][offset + i]);
		}
		
//		right column
		for(int i = 0; i < size; i++) { 
			result.add(matrix[offset + i][offset + size]);
		}
		
//		bottom row
		for(int i = size + 1; i > 0; i--) {
			result.add(matrix[offset + size][offset + i]);
		}
		
//		left column
		for(int i = size + 1; i > 0; i--) {
			result.add(matrix[offset + i][offset + size]);
		}
		helper(matrix, offset + 1, size - 2, result);
	}
	 
	 
}
