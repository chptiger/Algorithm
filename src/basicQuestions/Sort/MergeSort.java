package sort;

//divide and conquer
import java.util.Arrays;

public class MergeSort {
	static int Number = 0;
	public static void main(String[] args) {
		int[] arr = { 4, 7, 2, 1, 9, 3 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println("after sorted" + Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int middle = left + (right - left) / 2;
		mergeSort(arr, left, middle);
		mergeSort(arr, middle + 1, right);
		merge(arr, left, middle, right);
	}

	private static void merge(int[] arr, int left, int middle, int right) {
		int[] tmp = new int[arr.length];
		int m = middle + 1;
		int index = left;
		int cindex = left;

		while (left <= middle && m <= right) {
			if (arr[left] < arr[m]) {
				tmp[index++] = arr[left++];
			} else {
				tmp[index++] = arr[m++];
			}
		}

		while (left <= middle) {
			tmp[index++] = arr[left++];
		}

		while (m <= right) {
			tmp[index++] = arr[m++];
		}

		Number++;
		System.out.println("This is the " + (Number) + " sort");
		while (cindex <= right) {
			arr[cindex] = tmp[cindex];
			System.out.print(arr[cindex] + " ");
			cindex++;
		}
		System.out.println();
	}

}
