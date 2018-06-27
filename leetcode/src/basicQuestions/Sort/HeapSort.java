package sort;

import java.util.Arrays;

public class HeapSort {
	public static int length;
	private static void heapSort(int[] arr) {
		build_heap(arr);
		for (int i = arr.length - 1; i >= 2; i--) {
			int tmp = arr[1];
			arr[1] = arr[i];
			arr[i] = tmp;
			length--;
			build_modify_max_heap(arr, 1);
		}
	}

	private static void build_heap(int[] arr) {
		for (int i = arr.length / 2; i >= 1; i--) {
			build_modify_max_heap(arr, i);
		}
	}

	private static void build_modify_max_heap(int[] arr, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = 0;

		if (left < length && arr[i] < arr[left]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < length && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest == i) {
			return;
		}else{

			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;

			build_modify_max_heap(arr, largest);
		}
	}
	public static void main(String[] args) {
		int[] arr = { 4, 7, 8, 1, 9, 10 };
		length = arr.length;

		heapSort(arr);
		System.out.println("after sorted" + Arrays.toString(arr));
	}

	
}
