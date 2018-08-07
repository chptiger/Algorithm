/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) 
with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
dp：


https://leetcode.com/discuss/71354/share-my-thinking-process
buy[i] means before day i what is the maxProfit for any sequence end with buy.

sell[i] means before day i what is the maxProfit for any sequence end with sell.

rest[i] means before day i what is the maxProfit for any sequence end with rest.

Then we want to deduce the transition functions for buy sell and rest. By definition we have:

buy[i]  = max(rest[i-1]-price, buy[i-1])  //(1) We have to `rest` before we `buy`  
sell[i] = max(buy[i-1]+price, sell[i-1])  //(2) we have to `buy` before we `sell`
rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
Where price is the price of day i. All of these are very straightforward. They simply represents :

(1) We have to `rest` before we `buy` and 
(2) we have to `buy` before we `sell`

One tricky point is how do you make sure you sell before you buy, 
	since from the equations it seems that [buy, rest, buy] is entirely possible.

Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). 
That made sure [buy, rest, buy] is never occurred.

A further observation is that and rest[i] <= sell[i] is also true therefore

rest[i] = sell[i-1]
Substitute this in to buy[i] we now have 2 functions instead of 3:

buy[i] = max(sell[i-2]-price, buy[i-1])
sell[i] = max(buy[i-1]+price, sell[i-1])
This is better than 3, but

we can do even better

Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). 
And here we are at our final solution:

public int maxProfit(int[] prices) {
    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    for (int price : prices) {
        prev_buy = buy;
        buy = Math.max(prev_sell - price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
    }
    return sell;
}


https://leetcode.com/discuss/71391/easiest-java-solution-with-explanations
we can do even better:
3. Optimize to O(1) Space

	DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.

	Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
	Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
	Then arrays turn into Fibonacci like recursion:

	b0 = Math.max(b1, s2 - prices[i]);
	s0 = Math.max(s1, b1 + prices[i]);
	
4. Write Code in 5 Minutes

	First we define the initial states at i = 0:

	We can buy. The max profit at i = 0 ending with a buy is -prices[0].
	We cannot sell. The max profit at i = 0 ending with a sell is 0.
	Here is my solution. Hope it helps!

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) return 0;

		int b0 = -prices[0], b1 = b0;
		int s0 = 0, s1 = 0, s2 = 0;

		for(int i = 1; i < prices.length; i++) {
			b0 = Math.max(b1, s2 - prices[i]);
			s0 = Math.max(s1, b1 + prices[i]);
			b1 = b0; s2 = s1; s1 = s0; 
		}
		return s0;
	}
*/
package leetcode.medium;

public class BestStockCoolDown_309{
	public static void main(String[] args){
		int[] nums = { 1, 2, 3, 0, 2};
		int res = maxProfit( nums );
		System.out.println( res );
	}
	public static int maxProfit(int[] prices) {
        if( prices == null || prices.length <=1) return 0;
		
		int s0 = 0; int s1 = 0; int s2 =0;
		int b0 = -prices[0]; int b1 = b0;
		for( int i = 0; i < prices.length; i++){
			b0 = Math.max( b1, s2 - prices[i]);
			s0 = Math.max( s1, b1 + prices[i]);
			b1 = b0; s2 = s1; s1 = s0;
		}
		return s0;
    }
}