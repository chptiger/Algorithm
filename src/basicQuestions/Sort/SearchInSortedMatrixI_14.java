package Algorithm.Sort;

import java.util.Arrays;

/**
 * Given a 2D matrix that contains integers only, which each row is sorted in an
 * ascending order. The first element of next row is larger than (or equal to)
 * the last element of previous row. Given a target number, returning the
 * position that the target locates within the matrix. If the target number does
 * not exist in the matrix, return {-1, -1}.
 * 
 * Assumptions: The given matrix is not null, and has size of N * M, where N >=
 * 0 and M >= 0.
 * 
 * Examples: matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} } target = 7, return
 * {1, 2} target = 6, return {-1, -1} to represent the target number does not
 * exist in the matrix.
 * 
 * @author Thomas
 *
 */
public class SearchInSortedMatrixI_14 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 7 }, { 8, 9, 10 } };
		System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 7)));
	}

	public static int[] searchInSortedMatrix(int[][] matrix, int Target) {
		if (matrix == null || matrix.length == 0)
			return new int[] { -1, -1 };
		int start = 0;
		int end = matrix.length * matrix[0].length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid / matrix.length][mid % matrix.length] == Target) {
				return new int[] { mid / matrix.length, mid % matrix.length };
			} else if (matrix[mid / matrix.length][mid % matrix.length] > Target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return new int[] { -1, -1 };
	}
}
