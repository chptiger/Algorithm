package Algorithm.Sort;
/**
 *  Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.
	Assumptions
	There can be duplicate elements in the array.
	Examples
	A = {1, 2, 3}, T = 2, return 1
	A = {1, 2, 3}, T = 4, return -1
	A = {1, 2, 2, 2, 3}, T = 2, return 1
	Corner Cases
	What if A is null or A of zero length? We should return -1 in this case.

 * @author Thomas
 *
 */
public class FirstOccurrence_9 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 2, 3};
		System.out.println(binarySearchClassical(arr,2));
	}
	
	public static int binarySearchClassical (int[] arr, int t) {
		if (arr == null || arr.length < 1) return -1;
		int start = 0, end = arr.length - 1, result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (t == arr[mid]) {
				result = mid;
				end = mid - 1;
			} else if (t < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
}
