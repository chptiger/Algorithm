package Algorithm.Sort;

import java.util.Arrays;

/**
 * Given a target integer T, a non-negative integer K and an integer array A
 * sorted in ascending order, find the K closest numbers to T in A. Assumptions
 * A is not null K is guranteed to be >= 0 and K is guranteed to be <= A.length
 * Return A size K integer array containing the K closest numbers(not indices)
 * in A, sorted in ascending order by the difference between the number and T.
 * Examples A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1} A = {1,
 * 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 * 
 * @author Thomas
 *
 */
public class KClosetInSortedArray_12 {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 6, 8 };
		int[] result = findKClosestNumbers(arr, 3, 3);
		System.out.println(Arrays.toString(result));
	}

	public static int[] findKClosestNumbers(int[] arr, int T, int K) {
		if (arr == null || arr.length == 0 || K == 0 || K > arr.length) {
			return new int[] {};
		}
		if (K == arr.length) {
			return arr;
		}
		int start = 0, end = arr.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == T) {
				start = mid;
				end = mid + 1;
			} else if (arr[mid] > T) {
				end = mid;
			} else {
				start = mid;
			}
		}

		int[] result = new int[K];
		for (int i = 0; i < K; i++) {
			if (end == arr.length - 1 || start >= 0 && Math.abs(arr[start] - T) < Math.abs(arr[end] - T)) {
				result[i] = arr[start--];
			} else {
				result[i] = arr[end++];
			}
		}
		return result;
	}
}
