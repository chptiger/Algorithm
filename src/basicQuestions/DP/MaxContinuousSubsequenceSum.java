package DP;

// status exchange equation:
//d[j] = max (d[j - 1] + S[j]; S[j]) ;  1 <= j <= n
//target = max d[j] ; 					1 <= j <= n
public class MaxContinuousSubsequenceSum {
	public static void main(String[] args) {
		int[] a = { -1, -2 };
		int[] b = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int sum1 = sum(a);
		int sum2 = sum(b);
		System.out.println(sum1);
		System.out.println(sum2);
	}

	public static int sum(int[] arry) {
		if (arry == null || arry.length < 1)
			return 0;

		if (arry.length == 1)
			return arry[0];

		int[] max = new int[arry.length];
		max[0] = arry[0];
		int las = max[0];

		for (int i = 1; i < arry.length; i++) {
			max[i] = Math.max(max[i - 1] + arry[i], arry[i]);
			if (las < max[i]) {
				las = max[i];
			}
		}
		return las;
	}
}
