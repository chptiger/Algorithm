package basicQuestions.Recursion.II;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;
import utilities.StringUtil;

public class MergeSort_2_2 {

	@Test
	public void test_stringReverse() {
		int[] arr = { 1, 5, 7, 9, 2, 3, 4 };
		int[] expected = { 1, 5, 7, 9, 2, 3, 4 };
		mergeSort(arr, 0, arr.length - 1);
		assertTrue(Arrays.equals(expected, arr));
	}

	public static int[] mergeSort(int[] arr, int start, int end) {
		if (start == end) {
			return arr;
		}

		int middle = start + (end - start) / 2;
		int[] leftArray = mergeSort(arr, start, middle);
		int[] rightArray = mergeSort(arr, middle + 1, end);
		return combine(leftArray, rightArray);
	}

	private static int[] combine(int[] leftArray, int[] rightArray) {
		int i = 0, j = 0, r = 0, ll = leftArray.length, rl = rightArray.length;
		int[] result = new int[ll + rl];
		while (i < ll && j < rl) {
			if (leftArray[i] > rightArray[j]) {
				result[r++] = leftArray[i++];
			} else {
				result[r++] = rightArray[j++];
			}
		}
		while (i < ll) {
			result[r++] = leftArray[i++];
		}
		while (j < rl) {
			result[r++] = rightArray[j++];
		}
		return result;
	}
}
