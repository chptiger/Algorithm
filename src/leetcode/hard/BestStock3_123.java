package leetcode.hard;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

http://blog.csdn.net/fightforyourdream/article/details/14503469 
*/
import java.util.Arrays;

public class BestStock3_123 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 4, 5 };
		int result = maxProfit_(prices);
		System.out.println(result);
	}

	/*
	 * binary method: split into two time segments
	 */
	public static int maxProfit_(int[] prices) {
		int len = prices.length;
		if (prices == null || len < 1)
			return 0;

		int[] left = new int[len];
		int[] right = new int[len];

		// left[0] = 0;
		// right[len - 1] = 0;
		int min = 0;
		int max = 0;

		for (int i = 1; i < len; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		System.out.println(Arrays.toString(left));
		for (int i = len - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}
		System.out.println(Arrays.toString(right));
		for (int i = 0; i < len; i++) {
			max = Math.max(max, left[i] + right[i]);
		}
		return max;
	}

	/*
	 * global[i][j]: the ith day j transactions, the best profit
	 * global[i][j]=max(local[i][j],global[i-1][j]) local[i][j]: the ith day j
	 * transactions, the best profit at last day
	 * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
	 */
	public static int maxProfit(int[] prices) {
		int k = 2;
		int res = k_maxProfit(prices, k);// k: k times transaction
		return res;
	}

	public static int k_maxProfit(int[] prices, int k) {
		int len = prices.length;
		if (prices == null || len < 1)
			return 0;

		int[][] local = new int[len][k + 1];
		int[][] global = new int[len][k + 1];
		int diff = 0;
		for (int i = 1; i < len; i++) {
			diff = prices[i] - prices[i - 1];
			for (int j = 1; j < k + 1; j++) {
				local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
				global[i][j] = Math.max(local[i][j], global[i - 1][j]);
			}
		}
		return global[len - 1][k];
	}
}