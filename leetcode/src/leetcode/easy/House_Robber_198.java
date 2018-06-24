/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

http://www.meetqun.com/thread-8777-1-1.html

*/
package leetcode.easy;
public class House_Robber_198{
	public static void main(String[] args){
		int[] a = {6,8,9,1,7,3,4};
		max_Robber(a); 		// 26
		
		max_Robber_DP(a);	//26
	}
	
	public static void max_Robber_DP(int[] a){
		int take = 0;
		int nonTake = 0;
		int maxProfit = 0;
		
		for(int i = 0; i< a.length; i++){
			take = nonTake + a[i];
			System.out.println("take " + take);
			nonTake = maxProfit;
			System.out.println("nonTake " + nonTake);
			maxProfit = Math.max(take, nonTake);
			System.out.println("maxProfit " + maxProfit);
		}
		System.out.println( maxProfit);
	}
	
	public static void max_Robber(int[] a){
		int n = 0;
		for(int i = 0; i<a.length; i+=2){
			n +=a[i];
		}
		
		int m = 0;
		for(int i = 1; i<a.length; i+=2){
			m +=a[i];
		}
		System.out.println(Math.max(m,n));
	}
}

/*

其实就是在某个数组里面找一个序列， 序列里面的每一个元素都不能相邻，然后求其最大和 

这个问题可以用dp的思想来考虑， 对于第n个房间我们所能有的选择是偷和不偷:
 
那么如果是做决定是偷 则上一步必须是不偷 那么 这一步的就是 dp[N] = num[i -1 ] + dpNonTake[N -1] , 假设dp[N] 表示的是有N个元素时候的最大值状态。 

如果是不偷， 那么上一步就无所谓是不是已经偷过，所以就copy为 dp[N] = dp[N -1 ]即可，
 
所以总而言之为 dp[N] = Math.max(dpNontake[N-1 ] + num【i】, dp[N-1] ); 

因为每一轮迭代只需要触碰到dp 的相邻两个选项 所以可以空间压缩为 两个元素即可。一个 为take 一个为 nontake 和 到当前的最大值。 那么迭代为：

take = nonTake + num【i】;  偷
nonTake = maxProfit;    不偷 
maxProfit = Math.max(take,nonTake); 求最大利润

时间复杂度为O(n) 空间为O(1) 能运行的代码为：

*/