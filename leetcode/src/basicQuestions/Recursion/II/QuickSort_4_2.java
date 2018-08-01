package basicQuestions.Recursion.II;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;
import utilities.StringUtil;

public class QuickSort_4_2 {

	@Test
	public void test_stringReverse() {
		int[] arr = { 1, 5, 7, 9, 2, 3, 4 };
		int[] expected = { 1, 5, 7, 9, 2, 3, 4 };
		quickSort(arr, 0, arr.length - 1);
		assertTrue(Arrays.equals(expected, arr));
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start == end) {
			return;
		}
		int i = start, j = end;
		int middle = start + (end - start) / 2;
		while (start < end) {
			while (arr[start] < arr[middle]) {
				start++;
			}
			while (arr[middle] < arr[end]) {
				end--;
			}
			if (start <= end) {
				int tmp = start;
				start = end;
				end = start;
				start++;
				end--;
			}
		}

		if (i < end) {
			quickSort(arr, i, end);
		}
		if (start < j) {
			quickSort(arr, start, j);
		}
	}
}
