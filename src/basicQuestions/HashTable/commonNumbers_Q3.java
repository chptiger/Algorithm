package basicQuestions.HashTable;

import java.util.Arrays;
import java.util.Hashtable;

/*
Find the common numbers bewteen two Sorted arrraysw a[N], b[M], N, M

*/
public class commonNumbers_Q3 {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 6 };
		int[] b = { 4, 5, 6 };
		int[] res = commonNumber(a, b);
		// System.out.println(Arrays.toString(res));
		System.out.println(commonNumberBinarySearch(a, b));
	}

	// O(m + n)
	// TODO Question: how to change [4, 0, 0] to [4]?
	public static int[] commonNumber(int[] a, int[] b) {
		int i = 0, j = 0, r = 0;
		int[] result = new int[Math.min(a.length, b.length)];
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				result[r++] = a[i++];
			}
		}
		return result;
	}

	/*
	 * TODO Hashtable vs HashMap
	 * https://stackoverflow.com/questions/40471/differences-between-hashmap-and-
	 * hashtable O(m + n)
	 */
	public static String commonNumberHashtable(int[] a, int[] b) {
		Hashtable<Integer, Integer> res = new Hashtable<>();
		int al = a.length, bl = b.length;
		StringBuilder sb = new StringBuilder();
		int[] shortArray = a.length > b.length ? b : a;
		int[] longArray = a.length > b.length ? a : b;
		;

		addToHash(shortArray, res);

		Arrays.stream(longArray).forEach(ele -> {
			if (res.containsKey(ele)) {
				sb.append(ele);
				// consider duplicate elements in both array
				if (res.get(ele) >= 2) {
					res.replace(ele, res.get(ele) - 1);
				} else {
					res.remove(ele);
				}
			}
		});
		return sb.toString();
	}

	public static Hashtable addToHash(int[] a, Hashtable res) {
		Arrays.stream(a).forEach(e -> res.put(e, ((int) res.getOrDefault(e, 0)) + 1));
		return res;
	}

	/*
	 * m << n O(mlog(n))
	 */
	public static String commonNumberBinarySearch(int[] a, int[] b) {
		StringBuilder sb = new StringBuilder();
		int al = a.length, bl = b.length;
		int[] shortArray = a.length > b.length ? b : a;
		int[] longArray = a.length > b.length ? a : b;
		;

		Arrays.stream(shortArray).forEach(ele -> {
			// binary search
			if (binarySearchArray(longArray, ele) != -1) {
				sb.append(ele);
			}
		});
		return sb.toString();
	}

	public static int binarySearchArray(int[] arr, int t) {
		if (arr == null || arr.length < 1) {
			return -1;
		}
		int start = 0, end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > t) {
				end = mid - 1;
			} else if (arr[mid] < t) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
