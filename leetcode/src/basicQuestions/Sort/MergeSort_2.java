package Algorithm.Sort;

import java.util.Arrays;

/**
 * Given an array of integers, sort the elements in the array in ascending
 * order. The merge sort algorithm should be used to solve this problem.
 * Examples {1} is sorted to {1} {1, 2, 3} is sorted to {1, 2, 3} {3, 2, 1} is
 * sorted to {1, 2, 3} {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6} Corner
 * Cases What if the given array is null? In this case, we do not need to do
 * anything. What if the given array is of length zero? In this case, we do not
 * need to do anything.
 * 
 * O(n) - > nlogn
 * Space - >n
 * 
 * @author Thomas
 *
 */
public class MergeSort_2 {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 1, 6, 8 };
		arr = mergeSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid); // not include to
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);// not include to
		left = mergeSort(left);
		right = mergeSort(right);
		arr = combine(left, right);
		return arr;
	}

	public static int[] combine(int[] left, int[] right) {
		int leftIndex = 0;
		int rightIndex = 0;
		int combineIndex = 0;
		int[] combine = new int[left.length + right.length];
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				combine[combineIndex++] = left[leftIndex++];
			} else {
				combine[combineIndex++] = right[rightIndex++];
			}

			if (leftIndex == left.length) {
				while (rightIndex < right.length) {
					combine[combineIndex++] = right[rightIndex++];
				}
			} else if (rightIndex == right.length) {
				while (leftIndex < left.length) {
					combine[combineIndex++] = left[leftIndex++];
				}
			}
		}
		return combine;

	}

}
