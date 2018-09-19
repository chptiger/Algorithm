/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/
package leetcode.easy;

public class Excel_Sheet_Column_Number_171 {
	public static void main(String[] args) {
		String s = "AB";
		int l = Excel_Sheet_Column_Number(s);
		System.out.println(s + " corresponding column number is " + l);
	}

	public static int Excel_Sheet_Column_Number(String s) {
		char[] a = s.toCharArray();
		int m = 0;
		for (int i = 0; i < a.length; i++) {
			m += 26 * i + (int) (a[i] - 'A' + 1);
		}
		return m;
	}
}