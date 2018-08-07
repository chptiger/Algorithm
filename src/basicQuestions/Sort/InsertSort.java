package sort;

//http://mathbits.com/MathBits/Java/arrays/InsertionSort.htm
import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 9, 10, 6, 8 };
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void insertSort(int[] arr) {
		int i = 0;
		int key = 0;
		int j = 0;

		for (j = 1; j < arr.length; j++) {
			key = arr[j];
			for (i = j - 1; (i >= 0) && (arr[i] < key); i--) {
				arr[i+1]= arr[i];
//				arr[i] = key;
			}
			arr[i+1] =key ;
		}
	}
}
