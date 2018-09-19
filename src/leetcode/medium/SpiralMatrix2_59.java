package leetcode.medium;
/*
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SpiralMatrix2_59 {
	public static void main(String[] args) {
		int n = 3;
		int[][] res = generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(res[i][j]);
			}
		}
	}

	public static int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		if (n <= 0)
			return ans;
		int colStart = 0;
		int colEnd = n - 1;
		int rowStart = 0;
		int rowEnd = n - 1;
		int num = 1;
		while (colStart <= colEnd && rowStart <= rowEnd) {

			for (; colStart <= colEnd; colStart++) {
				ans[rowStart][colStart] = num++; // rowStart = 0;colStart = 2;
				System.out.println(rowStart + " " + colStart + " " + ans[rowStart][colStart]);
			}

			colStart--;
			for (rowStart++; rowStart <= rowEnd; rowStart++) {
				ans[rowStart][colStart] = num++; // rowStart = 3;colStart = 2;
				System.out.println(rowStart + " " + colStart + " " + ans[rowStart][colStart]);
			}

			rowStart--; // rowStart = 2;colStart = 2;
			for (colStart--; colStart >= 0; colStart--) {
				ans[rowStart][colStart] = num++; // rowStart = 2;colStart = -1;
				System.out.println(rowStart + " " + colStart + " " + ans[rowStart][colStart]);
			}
			colStart++; // rowStart = 2;colStart = 0;
			for (rowStart--; rowStart > 0; rowStart--) {
				ans[rowStart][colStart] = num++; // colStart = 1;rowStart = 0;
				System.out.println(rowStart + " " + colStart + " " + ans[rowStart][colStart]);
			}

		}
		return ans;
	}
}
