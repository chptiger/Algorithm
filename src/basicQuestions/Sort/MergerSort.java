package Sort;

import java.util.Arrays;

public class MergerSort {
	public static void main(String[] args) {
		Integer[] a = { 1, 3, 5, 7, 9, 8, 6, 2, 4, 0 };
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(Integer[] a) {
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp, 0, a.length - 1);
	}

	private static void mergeSort(Integer[] a, Comparable[] tmp, int left, int right) {
		if (left < right) {
			int middle = left + (right - left) / 2;

			mergeSort(a, tmp, left, middle);
			mergeSort(a, tmp, middle + 1, right);
			merge(a, tmp, left, middle, right);
		}
	}

	private static void merge(Comparable[] a, Comparable[] tmp, int left, int leftEnd, int rightEnd) {
		Integer right = leftEnd + 1;
		Integer k = left;
		int num = rightEnd - left + 1;
		while (left <= leftEnd && right <= rightEnd) {
			if (a[left].compareTo(a[right]) <= 0) {
				tmp[k++] = a[left++];
			} else {
				tmp[k++] = a[right++];
			}
		}

		while (left <= leftEnd) {
			tmp[k++] = a[left++];
		}

		while (right <= rightEnd) {
			tmp[k++] = a[right++];
		}

		for (int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = tmp[rightEnd];
		}
	}

}