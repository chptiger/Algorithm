package basicQuestions.Recursion.II;

import org.junit.Assert;
import org.junit.Test;

public class SpiralOrderGenerator {
	
	private String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                sb.append(matrix[row][column]).append(" ");
            }
            sb.append("->");
        }
        return sb.toString();
    }

    @Test
    public void test_spiralGenerate() {
        Assert.assertEquals("1 2 3 ->8 9 4 ->7 6 5 ->", printMatrix(spiralGenerate(3, 3)));
        Assert.assertEquals("1 2 3 ->10 11 4 ->9 12 5 ->8 7 6 ->", printMatrix(spiralGenerate(4, 3)));
        Assert.assertEquals("1 2 3 4 ->10 11 12 5 ->9 8 7 6 ->", printMatrix(spiralGenerate(3, 4)));
    }

	private int[][] spiralGenerate(int m, int n) {
		int[][] matrix = new int[m][n];
		int num = 1, left = 0, right = n - 1, top = 0, bottom = m - 1;
		while(left < right && top < bottom) {
			for(int i = left; i < right; i++) {
				matrix[top][i] = num++;
			}
			for(int i = top; i < bottom; i++) {
				matrix[i][right] = num++;
			}
			for(int i = right; i > left; i--) {
				matrix[bottom][i] = num++;
			}
			for(int i = bottom; i > top; i--) {
				matrix[i][left] = num++;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
	/*	
	 both of m and n are even number, we do not need following check
		1 2   3  4 
		5 6   7  8
		9 10  11 12
		13 14 15 16
		
	 both m and n are odd number, we only need do one in the following if else logic
		1 2 3 
		4 5 6
		7 8 9
		
	 if m is odd and n is even number, we need consider the row of 6, 7
	 left = 1, right = 2, top = 1, bottom = 1
	 i = left; i <= right
	 matrix[top][i] = num++;
	 	1 2  3  4
	 	5 6  7  8
	 	9 10 11 12
	 	
	 if m is even and n is odd number, we need consider the column of 5, 8
	 left = 1, right = 1, top = 1, bottom 2;
	 i = top; i <= bottom
	 	matrix[left][i] = num++;
	 	1  2  3
	 	4  5  6
	 	7  8  9
	 	10 11 12
	 	
	 	Therefore, we only need consider one of the left == right || top == bottom
		*/
//		both m or n is even number
		if(left > right || top > bottom) {
			return matrix;
		}
//		we should use if else in this part. if both of them equal
//		m is odd number
		if(top == bottom) {
			for(int i = left; i <= right; i++) {
				matrix[top][i] = num++;
			}
		} else {
//		n is odd number
			if(left == right) {
				for(int i = top; i <= bottom; i++) {
					matrix[i][left] = num++;
				}
			}
		}
		return matrix;
	}
}
