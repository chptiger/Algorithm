package DP;

import java.util.LinkedList;

public class Triangle_minimum_total {

	public static void main(String[] args) {
		LinkedList<LinkedList<Integer>> triangle = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> m1 = new LinkedList<Integer>();
		LinkedList<Integer> m2 = new LinkedList<Integer>();
		LinkedList<Integer> m3 = new LinkedList<Integer>();
		LinkedList<Integer> m4 = new LinkedList<Integer>();
		m1.add(-1);
		triangle.add(m1);
		// System.out.println(triangle);

		m2.add(2);
		m2.add(3);
		triangle.add(m2);
		// System.out.println(triangle);

		m3.add(1);
		m3.add(-1);
		m3.add(-3);
		triangle.add(m3);
		// System.out.println(triangle);

		// m4.add(4);
		// m4.add(1);
		// m4.add(8);
		// m4.add(3);
		// triangle.add(m4);
		System.out.println(triangle);

		int result = minimumTotal(triangle);
		System.out.println(result);
	}

	// from top to down. always keep an array that keep minimum value: sums[j] =
	// (sums[j]<sums[j-1]?sums[j]:sums[j-1]) + triangle.get(i).get(j);
	/*
	 * ways to keep adjacent:
	 * 
	 * 1 0 0 1 1 3 4
	 * 
	 */
	public static int minimumTotal_(LinkedList<LinkedList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		int[] sums = new int[triangle.size()];
		sums[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			sums[i] = sums[i - 1] + triangle.get(i).get(i); // last one of every row
			for (int j = i - 1; j >= 1; j--) {
				sums[j] = (sums[j] < sums[j - 1] ? sums[j] : sums[j - 1]) + triangle.get(i).get(j); // between first and
																									// last one of every
																									// row.
			}
			sums[0] = sums[0] + triangle.get(i).get(0); // first one of every row

		}
		int minimum = sums[0];
		for (int i = 1; i < sums.length; i++) {
			if (sums[i] < minimum) {
				minimum = sums[i];
			}
		}
		return minimum;
	}

	// from bottom to top
	public static int minimumTotal(LinkedList<LinkedList<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; i--)
			for (int j = 0; j <= i; j++)
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
		return triangle.get(0).get(0);
	}
}
