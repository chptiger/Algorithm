package Algorithm.Sort;

/**
 *  Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.
	Assumptions
	There can be duplicate elements in the array, and we can return any of the indices with same value.
	Examples
	A = {1, 2, 3}, T = 2, return 1
	A = {1, 4, 6}, T = 3, return 1
	A = {1, 4, 6}, T = 5, return 1 or 2
	A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
	Corner Cases
	What if A is null or A is of zero length? We should return -1 in this case.
 * @author Thomas
 *
 */
public class ClosestInSortedArray_11 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 3, 4};
		System.out.println(closestInSortedArray(arr, 2));
	}
	
	public static int closestInSortedArray (int[] arr, int t) {
		if ( arr == null || arr.length < 1) return -1;
		int start = 0, end = arr.length - 1, result = -1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == t) {
				return mid;
			} else if (arr[mid] > t) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (Math.abs(t - arr[start]) < Math.abs(t - arr[end])) {
			return start;
		} else {
			return end;
		}
	}
}
