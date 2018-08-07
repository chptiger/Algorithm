/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/
package leetcode.easy;
public class Add_Digits_258 {
	public static void main(String[] args) {
		int n = 33;
		int m = Add_Digits(n);
		// System.out.println(100/3); 33
		// System.out.println(100%24); 4
		System.out.println(m);
	}

	public static int Add_Digits(int n) {
		// if( n <=0 ) return n;
		if (n < 10)
			return n;

		int l = get_digits(n);

		int tmp = 0;
		int m = 0;
		while (m <= l) {
			tmp += n % 10;
			n = n / 10;
			m++;
		}
		return Add_Digits(tmp);
	}

	public static int get_digits(int n) {
		int m = n / 10;
		int l = 1;
		while (m != 0) {
			m = m / 10;
			l++;
		}
		System.out.println("the digits number is " + l);
		return l;
	}
}