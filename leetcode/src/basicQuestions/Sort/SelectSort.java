package sort;

// for element less than 1000
import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = { 5, 4, 2, 3, 6, 8 };
		int low = 0;
		int high = arr.length - 1;

		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;
		}
	}
}
