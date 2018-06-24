package leetcode.medium;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/
public class BestStock_121{
	public static void main(String[] args){
		int[] nums = { 1, 2, 3, 4};
		int res = maxProfit_( nums );
		System.out.println( res );
	}
	
	// every day get maximum profit, the last day is the maximum profit;
	// Kadane's Algorithm
	public static int maxProfit(int[] prices) {
		if( prices == null || prices.length <= 1 ) return 0;
		int localMax = 0;
		int globalMax = 0;
		for( int i = 1; i < prices.length; i++ ){
			localMax = Math.max( 0, localMax += prices[ i ] - prices[ i - 1 ] );
			globalMax = Math.max( localMax, globalMax );
		}
		return globalMax;
	}
	// find minum value, the maximum profit = current - minum value
	public static int maxProfit_(int[] prices) {
		if( prices == null || prices.length <= 1 ) return 0;
		int sofarMax = prices[0];
		int globalMax = 0;
		for( int i = 1; i < prices.length; i++ ){
			if( sofarMax < prices[i] ){
				globalMax = Math.max( globalMax, prices[i] - sofarMax);
			}else{
				sofarMax = prices[ i ];
			}
		}
		return globalMax;
	}
	
}