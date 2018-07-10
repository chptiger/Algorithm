package basicQuestions.String;

import java.util.Arrays;

/*
Find the common numbers bewteen two Sorted arrraysw a[N], b[M], N, M
*/
public class commonNumbers_Q3 {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4 };
		int[] b = { 4, 5, 6 };
		int[] res = commonNumber(a, b);
		System.out.println(Arrays.toString(res));
	}

	public static int[] commonNumber(int[] a, int[] b) {
		int i = 0, j = 0, r = 0;
		int[] result = new int[Math.min(a.length, b.length)];
		while (i < a.length && j < b.length) {
			if(a[i] < b[j] ) {
				i++;
			} else if(a[i] > b[j] ) {
				j++;
			} else {
				result[r++] = a[i++];
			}
		}
		return result;
	}
}
