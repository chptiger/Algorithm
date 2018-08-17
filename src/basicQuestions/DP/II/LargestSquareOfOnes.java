package basicQuestions.DP.II;

import org.junit.Assert;
import org.junit.Test;

/*
Description
	Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
Assumptions
	The given matrix is not null and guaranteed to be of size N * N, N >= 0
Examples
{ {0, 0, 0, 0},
  {1, 1, 1, 1},
  {0, 1, 1, 1},
  {1, 0, 1, 1}}
  
the largest square of 1s has length of 2
*/
public class LargestSquareOfOnes {
	
	@Test
    public void test_largestSquare() {
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}}));
        Assert.assertEquals(2, largest(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 1, 1}, {0, 0, 1, 1}}));
        Assert.assertEquals(4, largest(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
        Assert.assertEquals(0, largest(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}));
    }

	private static int largest(int[][] input) {
		int[][] M = new int[input.length][input.length];
		int max = 0;
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input.length; j++) {
				if(i == 0 || j == 0) {
					M[i][j] = input[i][j] == 1 ? 1 : 0;
				} else if(input[i][j] == 0) {
					M[i][j] = 0;
				} else {
					M[i][j] = 1 + Math.min(M[i - 1][j - 1], Math.min(M[i - 1][j], M[i][j - 1]));
					max = Math.max(max, M[i][j]);
				}
			}
		}
		return max;
	}
}
