package Algorithm.Sort;
/**
 * Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.
	Assumptions
	There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
	Examples
	A = {1, 2, 3, 4, 5}, T = 3, return 2
	A = {1, 2, 3, 4, 5}, T = 6, return -1
	A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
	Corner Cases
	What if A is null or A is of zero length? We should return -1 in this case.

 * @author Thomas
 *
 */
public class BinarySearchClassical_8 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(binarySearchClassical(arr,2));
	}
	
	public static int binarySearchClassical (int[] arr, int t) {
		if (arr == null || arr.length < 1) return -1;
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (t == arr[mid]) {
				return mid;
			} else if (t < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
}
