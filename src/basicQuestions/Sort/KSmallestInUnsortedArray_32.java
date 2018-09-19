package Algorithm.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray_32 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(kthSmallestInUnSortedArray(arr, 3)));
	}

	public static int[] kthSmallestInUnSortedArray(int[] arr, int index) {
		if (arr == null || arr.length < index) {
			return new int[0];
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}

		int[] result = new int[index];
		for (int i = 0; i < index; i++) {
			result[i] = pq.poll();
		}
		return result;
	}
}
