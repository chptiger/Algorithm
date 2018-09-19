package Algorithm.Sort;

/**
 * Given an array of integers, sort the elements in the array in ascending
 * order. The selection sort algorithm should be used to solve this problem.
 * 
 * Examples
 * 
 * {1} is sorted to {1} {1, 2, 3} is sorted to {1, 2, 3} {3, 2, 1} is sorted to
 * {1, 2, 3} {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6} Corner Cases
 * 
 * What if the given array is null? In this case, we do not need to do anything.
 * What if the given array is of length zero? In this case, we do not need to do
 * anything.
 * 
 * @author Thomas
 *
 *         �ӵ�һ��Ԫ�ؿ�ʼ���ҵ����˵�һ��Ԫ��֮�����СԪ�أ����һ��Ԫ�ػ�����
 *         �ӵڶ���Ԫ�ؿ�ʼ���ҵ����˵�һ�����ڶ���Ԫ��֮�����СԪ�أ���ڶ���Ԫ�ػ����� O(time) =
 *         n^2 Space = 1
 */
public class SelectionSort_1 {

	public static void main(String[] args) {
		int[] arr = { 6, 8, 9, 0, 1, 2, 4, 6 };
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			int global = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[global] > arr[j]) {
					global = j;
				}
			}
			int tmp = arr[global];
			arr[global] = arr[i];
			arr[i] = tmp;
		}
	}
}
