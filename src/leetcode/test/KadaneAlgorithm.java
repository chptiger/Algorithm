public class KadaneAlgorithm {

	public static void main(String[] args) {
		int[] prices = { 1, -10, -13, 4 };
		// int res = maxProfit(prices);
		// System.out.println(res);
		int res = maxProfit_(prices);
		System.out.println(res);
	}

	public static int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			System.out.println(" maxCur " + maxCur);
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			System.out.println(" maxCur " + maxCur);
			System.out.println(" maxSoFar " + maxSoFar);
			maxSoFar = Math.max(maxCur, maxSoFar);
			System.out.println(" maxSoFar " + maxSoFar);
		}
		return maxSoFar;
	}

	public static int maxProfit_(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		int sofarMin = prices[0];
		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] > sofarMin) {
				max = Math.max(max, prices[i] - sofarMin);
			} else {
				sofarMin = prices[i];
			}
		}
		return max;
	}

}
