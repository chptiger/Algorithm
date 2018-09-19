package leetcode.easy;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] m = new int[8];
		int n = 9;
		find_index(m, n);
		System.out.println(Arrays.toString(m));
	}

	public static void find_index(int[] m, int n) {

		if (n == 0)
			return;

		if (n == 1)
			m[0] = 1;

		int z = n;
		int i = 0;
		while (z != 1) {
			z = z / 2;
			i++;
			// count = count*2;
			// System.out.println("count " + count);
		}

		m[i] = 1;
		System.out.println(Arrays.toString(m));
		n -= Math.pow(2, i);
		System.out.println("n " + n);

		find_index(m, n);
	}

}