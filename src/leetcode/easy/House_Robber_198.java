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

public class House_Robber_198 {
	public static void main(String[] args) {
		int[] a = { 6, 8, 9, 1, 7, 3, 4 };
		max_Robber(a); // 26

		max_Robber_DP(a); // 26
	}

	public static void max_Robber_DP(int[] a) {
		int take = 0;
		int nonTake = 0;
		int maxProfit = 0;

		for (int i = 0; i < a.length; i++) {
			take = nonTake + a[i];
			System.out.println("take " + take);
			nonTake = maxProfit;
			System.out.println("nonTake " + nonTake);
			maxProfit = Math.max(take, nonTake);
			System.out.println("maxProfit " + maxProfit);
		}
		System.out.println(maxProfit);
	}

	public static void max_Robber(int[] a) {
		int n = 0;
		for (int i = 0; i < a.length; i += 2) {
			n += a[i];
		}

		int m = 0;
		for (int i = 1; i < a.length; i += 2) {
			m += a[i];
		}
		System.out.println(Math.max(m, n));
	}
}

/*
 * 
 * ��ʵ������ĳ������������һ�����У� ���������ÿһ��Ԫ�ض��������ڣ�Ȼ����������
 * 
 * ������������dp��˼�������ǣ� ���ڵ�n���������������е�ѡ����͵�Ͳ�͵:
 * 
 * ��ô�������������͵ ����һ�������ǲ�͵ ��ô ��һ���ľ��� dp[N] = num[i -1 ] +
 * dpNonTake[N -1] , ����dp[N] ��ʾ������N��Ԫ��ʱ������ֵ״̬��
 * 
 * ����ǲ�͵�� ��ô��һ��������ν�ǲ����Ѿ�͵�������Ծ�copyΪ dp[N] = dp[N -1 ]���ɣ�
 * 
 * �����ܶ���֮Ϊ dp[N] = Math.max(dpNontake[N-1 ] + num��i��, dp[N-1] );
 * 
 * ��Ϊÿһ�ֵ���ֻ��Ҫ������dp ����������ѡ�� ���Կ��Կռ�ѹ��Ϊ ����Ԫ�ؼ��ɡ�һ�� Ϊtake һ��Ϊ
 * nontake �� ����ǰ�����ֵ�� ��ô����Ϊ��
 * 
 * take = nonTake + num��i��; ͵ nonTake = maxProfit; ��͵ maxProfit =
 * Math.max(take,nonTake); ���������
 * 
 * ʱ�临�Ӷ�ΪO(n) �ռ�ΪO(1) �����еĴ���Ϊ��
 * 
 */