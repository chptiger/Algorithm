package DP;
/*http://wenku.baidu.com/link?url=Sw_J3knEsFsz5AP6vvCtR5EmJOicAY9ZviEH313fqPYIfZyeGcRHdUhRuRu01nCl2TDh0haADaSGcoPBYUc3J6C5bGi4iRCLvluzM5ZIZ8G 
 * 
  assume d[i,j] segments i, last element j, include j.
   d[i, j] = max{d[i, j - 1] + S[j], max d[i - 1, t] + S[j]} ; i<= j <= n; i-1 <= t < j
   d[i, j - 1] + S[j]:      segments i include S[j];
   max d[i - 1; t] + S[j]:  segments i not include S[j];
   target = max{d[m,j]}      m <= j <=n
*/

public class Maximum_M_Segments_Sum {

	public static void main(String[] args) {
		int[] arr = { 2, 3, -7, 6, 4, -5 };

		int m = 3;
		int n = 6;

		int result = MaxSubSum(m, n, arr);
		System.out.println(result);
	}

	public static int MaxSubSum(int m, int n, int[] arr) {
		int[][] tmp = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			tmp[i][0] = 0;
		}

		for (int i = 1; i < n; i++) {
			tmp[0][i] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = i; j <= n; j++) {// n-m+i 保证后面元素可以分成 m-i 段
				if (j > i) {// segments i, elements j;
					// 第i段包含arr[j]
					tmp[i][j] = tmp[i][j - 1] + arr[j - 1];// last segments includes arr[j]; array starts from index 0,
															// arr[j-1] is the jth element
					// 第i段不包含 arr[j] for循环求解所有 i-1 段中 最大值(i-1,j)
					for (int k = i - 1; k < j; k++) {// i-1个segments里面，i-1 <= k < j, 找到钱i-1个segments里面的最大值。
						int s = tmp[i - 1][k];
						if (tmp[i][j] < (tmp[i - 1][k] + arr[j - 1])) {
							tmp[i][j] = tmp[i - 1][k] + arr[j - 1]; // last segments not includes arr[j];
						}
					}
				} else
					tmp[i][j] = tmp[i - 1][j - 1] + arr[j - 1];// when i==j, all elements add together as result. every
																// element is a segment
			}
		}

		int sum = 0;
		for (int j = m; j <= n; j++) {
			if (sum < tmp[m][j])
				sum = tmp[m][j];
		}

		return sum;
	}

}
