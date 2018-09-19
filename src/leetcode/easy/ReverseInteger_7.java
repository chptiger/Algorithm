package leetcode.easy;
/*

Reverse digits of an integer.

Example1: x = 123, return 321

Example2: x = -123, return -321


How do we handle the overflow case? return 0;

*/

public class ReverseInteger_7 {
	public static void main(String[] args) {
		int n = 1534236469;
		System.out.println(n);
		int m = ReverseInteger(n);
		m = ReverseInteger_math(n);
		m = m = ReverseInteger_ac(n);
		System.out.println(m);
	}

	public static int ReverseInteger_ac(int x) {
		int result = 0;
		while (x != 0) {
			int tmp = x % 10;
			int newResult = tmp + result * 10;
			if ((newResult - tmp) / 10 != result)
				return 0;
			result = newResult;
			x = x / 10;
		}
		return result;
	}

	// 1534236469 reverse 9646324351
	// solution 1 try catch 2 use /
	public static int ReverseInteger_math(int x) {
		int result = 0;
		int count = 0;
		int cur;
		int tmp = x;
		while (tmp != 0) {
			tmp = tmp / 10;
			count++;
		}

		while (x != 0 && count > 0) {
			cur = x % 10;
			result = cur * (int) Math.pow(10, count - 1) + result;
			x = x / 10;
			count--;
		}
		return result;
	}

	// int max value 2^31 - 1 = 2,147,483,647
	// 1,534,236,469 input
	// runtime error Line 13: java.lang.NumberFormatException: For input string:
	// "9,646,324,351" output
	// if overflow return 0;
	// 1230 0321? 321?
	public static int ReverseInteger(int x) {
		int m = Math.abs(x);
		// if( x > 2147483647 || x < -21474836478) return 0;
		String tmp = String.valueOf(m);
		char[] nor = tmp.toCharArray();
		char[] rev = new char[nor.length];
		int j = rev.length - 1;
		for (int i = 0; i < rev.length; i++) {
			rev[j] = nor[i];
			j--;
		}
		// 1230 0321? 321
		int k = 0;
		while (rev[k] == 0) {
			k++;
		}

		String last = String.valueOf(rev);
		String result = last.substring(k);
		if (m >= 0)
			return Integer.parseInt(result);// Line 21: java.lang.NumberFormatException: For input string:
											// "9,646,324,351"
		else
			return Integer.parseInt("-1" + result);
	}
}