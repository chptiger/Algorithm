/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/
package leetcode.easy;

public class Ugly_Num_263 {
	public static void main(String[] args) {
		int n = 6;
		boolean flag = Ugly_Num(n);
		if (flag == true)
			System.out.println("ugly number");
		else
			System.out.println("Not ugly number");
	}

	public static boolean Ugly_Num(int n) {

		boolean flag;
		for (int i = 2; i < n; i++) {
			int l = n / i;
			int m = n % i;
			if (m == 0) {
				flag = isPrime(m);
				if (flag && l != 2 && l != 3 && l != 5) {
					return false;
				}

			}
		}
		return true;
	}

	public static boolean isPrime(int n) {
		if (n == 1)
			return true;
		for (int i = 2; 2 * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}