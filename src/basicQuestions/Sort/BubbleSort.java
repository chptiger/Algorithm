package sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String args[]) {
		int[] arr = { 4, 7, 2, 1, 9, 3 };
		bubblesort(arr);
		System.out.println(Arrays.toString(arr));

		int[] arr_1 = { 4, 7, 2, 3, 9, 1 };
		bubblesort_flag(arr_1);
		System.out.println(Arrays.toString(arr_1));
	}

	private static void bubblesort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}

	private static void bubblesort_flag(int[] arr) {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					flag = true;
				}
			}
		}
	}
}
