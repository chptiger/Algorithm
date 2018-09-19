package DP;

import java.util.Scanner;

// status exchange equation:
//d[j] = max (d[j - 1] + S[j]; S[j]) ;  1 <= j <= n
//target = max d[j] ; 					1 <= j <= n

public class MaxContinuousSubsequenceSum_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			if (n == 0)
				break;
			int a[] = new int[n]; // 开一个数组用来存储给定序列
			for (int i = 0; i < n; i++) {
				a[i] = input.nextInt();
			}
			int sum, max, start, end, cnt = 0; // sum存当前和，max存当前最大和,start为起始元素点，end为结束元素点
			int temp = 0; // 用来临时存起始点，也就是下一个start，cnt记录负数个数.
			sum = start = end = 0;
			max = a[0];
			for (int i = 0; i < n; i++) {
				sum += a[i];
				if (sum > max) // 如果sum比最大值大，i为最后标记点end,最大值为sum.
				{
					end = i;
					max = sum;
					start = temp;
				} else if (sum < 0) // 如果当前sum<0并且sum<=max，即当前sum肯定不是最大值
				{
					temp = i + 1; // 起始位置应为下一个数的下标
					sum = 0;
					cnt++; // 记录负数个数
				}
			}
			if (cnt == n) // cnt==n则所有的数为负数
			{
				System.out.println("0" + " " + a[0] + " " + a[n - 1]);
			} else {
				System.out.println(max + " " + a[start] + " " + a[end]);
			}
		}
	}

}