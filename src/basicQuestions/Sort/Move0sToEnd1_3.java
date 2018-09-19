package Algorithm.Sort;

import java.util.Arrays;

/**
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array does not need to be
 * maintained. Assumptions: The given array is not null. Examples: {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 * 
 * O() -> n space -> 1
 * 
 * @author Thomas
 *
 */
public class Move0sToEnd1_3 {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 3, 0, 1 };
		move0sToEnd1(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void move0sToEnd1(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int global = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[global++] = arr[i];
			}
		}
		while (global <= arr.length - 1) {
			arr[global++] = 0;
		}

	}
}
