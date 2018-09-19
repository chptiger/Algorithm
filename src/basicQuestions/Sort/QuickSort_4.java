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
 * O(n) - > nlogn Space - >nlogn
 * 
 * https://en.wikipedia.org/wiki/Quicksort
 * 
 * Worst-case analysis The most unbalanced partition occurs when the
 * partitioning routine returns one of sublists of size n − 1.[27] This may
 * occur if the pivot happens to be the smallest or largest element in the list,
 * or in some implementations (e.g., the Lomuto partition scheme as described
 * above) when all the elements are equal.
 * 
 * If this happens repeatedly in every partition, then each recursive call
 * processes a list of size one less than the previous list. Consequently, we
 * can make n − 1 nested calls before we reach a list of size 1. This means that
 * the call tree is a linear chain of n − 1 nested calls. The ith call does O(n
 * − i) work to do the partition, and {\displaystyle \textstyle \sum
 * _{i=0}^{n}(n-i)=O(n^{2})} \textstyle \sum _{i=0}^{n}(n-i)=O(n^{2}), so in
 * that case Quicksort takes O(n²) time.
 * 
 * Best-case analysis In the most balanced case, each time we perform a
 * partition we divide the list into two nearly equal pieces. This means each
 * recursive call processes a list of half the size. Consequently, we can make
 * only log2 n nested calls before we reach a list of size 1. This means that
 * the depth of the call tree is log2 n. But no two calls at the same level of
 * the call tree process the same part of the original list; thus, each level of
 * calls needs only O(n) time all together (each call has some constant
 * overhead, but since there are only O(n) calls at each level, this is subsumed
 * in the O(n) factor). The result is that the algorithm uses only O(n log n)
 * time
 * 
 * @author Thomas
 *
 */
public class QuickSort_4 {
	public static void main(String[] args) {
		int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		if (left >= right)
			return;
		int low = left, high = right, mid = left + (right - left) / 2;
		while (low < high) {
			while (arr[low] < arr[mid]) {
				low++;
			}
			while (arr[high] > arr[mid]) {
				high--;
			}
			if (low <= high) {
				int tmp = arr[high];
				arr[high] = arr[low];
				arr[low] = tmp;
				low++;
				high--;
			}
		}

		if (left < high) {
			quickSort(arr, left, high);
		}
		if (right > low) {
			quickSort(arr, low, right);
		}
	}
}
