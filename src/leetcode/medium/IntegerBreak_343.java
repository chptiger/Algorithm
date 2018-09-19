package leetcode.medium;

/*
Given a positive integer n, break it into the sum of at least two positive integers 
and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: you may assume that n is not less than 2.

I saw many solutions were referring factors of 2 and 3. But why these two magic numbers? Why other factors do not work? 
Let's study the math behind it.

For convenience, say n is sufficiently large and can be broken into any smaller real positive numbers. 
We now try to calculate which real number generates the largest product. 
Assume we break n into (n / x) x's, then the product will be xn/x, and we want to maximize it.

Taking its derivative gives us n * xn/x-2 * (1 - ln(x)). 
The derivative is positive when 0 < x < e, and equal to 0 when x = e, then becomes negative when x > e, 
which indicates that the product increases as x increases, then reaches its maximum when x = e, then starts dropping.

This reveals the fact that if n is sufficiently large and we are allowed to break n into real numbers, 
the best idea is to break it into nearly all e's. 
On the other hand, if n is sufficiently large and we can only break n into integers, 
we should choose integers that are closer to e. 
The only potential candidates are 2 and 3 since 2 < e < 3, but we will generally prefer 3 to 2. Why?

Of course, one can prove it based on the formula above, but there is a more natural way shown as follows.

6 = 2 + 2 + 2 = 3 + 3. But 2 * 2 * 2 < 3 * 3. 
Therefore, if there are three 2's in the decomposition, we can replace them by two 3's to gain a larger product.

All the analysis above assumes n is significantly large. 
When n is small (say n <= 10), it may contain flaws. 
For instance, when n = 4, we have 2 * 2 > 3 * 1. 
To fix it, we keep breaking n into 3's until n gets smaller than 10, then solve the problem by brute-force.
f(n) = max(2f(n-2),3f(n-3));
*/
public class IntegerBreak_343 {
	public static void main(String[] args) {
		int n = 10;
		int res = integerBreak(n);
		System.out.println(res);
	}

	public static int integerBreak(int n) {

		if (n <= 3)
			return n - 1;
		if (n == 4)
			return 4;
		if (n == 5)
			return 6;
		int[] p = new int[n];
		p[2] = 2;
		p[3] = 4;
		p[4] = 6;
		p[5] = 9;
		for (int i = 6; i < n; i++) {
			p[i] = 3 * p[i - 3];
		}
		int res = p[n - 1];
		return res;
	}
}
