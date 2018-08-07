package Algorithm.Sort;

import java.util.Arrays;

/**
 * Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
	Examples
	{0} is sorted to {0}
	{1, 0} is sorted to {0, 1}
	{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
	Assumptions
	The input array is not null.
	Corner Cases
	What if the input array is of length zero? In this case, we should not do anything as well.
 * @author Thomas
 *
 */
public class RainbowSort_5 {
	public static void main(String[] args) {
		int[] arr = {1, 0, 1, -1, 0};
		rainbowSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void rainbowSort (int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		
		rainbowSortHelper(arr, 0, 0, arr.length-1 );
	}
	
	public static void rainbowSortHelper(int[] arr, int i, int j, int length) {
		int negativeIndex = 0;
		int zeroIndex = 0;
		int activeIndex = length;
		while (zeroIndex <= activeIndex) {
			if (arr[zeroIndex] == 0) {
				zeroIndex++;
			} else if (arr[zeroIndex] == -1) {
				swap(arr, zeroIndex++, negativeIndex++);
			} else {
				swap(arr, zeroIndex, activeIndex--);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
