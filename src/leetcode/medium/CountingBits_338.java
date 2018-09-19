/*
Given a non negative integer number num. 
For every numbers i in the range 0 = i = num calculate the number of 1's in their binary representation 
and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
package leetcode.medium;

import java.util.Arrays;

public class CountingBits_338 {
	public static void main(String[] args) {
		int num = 5;
		int[] res = countBits_(num);
		System.out.println(Arrays.toString(res));
	}

	public static int[] countBits(int num) {
		int[] tmp = new int[num + 1];
		String[] tmp_str = new String[num + 1];
		for (int i = 0; i <= num; i++) {
			tmp[i] = i;
			tmp_str[i] = Integer.toBinaryString(tmp[i]);
			// System.out.println(tmp_str[i]);
			int count = 0;
			for (int j = 0; j < tmp_str[i].length(); j++) {

				if (Integer.parseInt(String.valueOf(tmp_str[i].charAt(j))) == 1) {
					count++;
				}
			}
			// System.out.println(count);
			tmp[i] = count;
			count = 0;
		}
		return tmp;
	}

	// dp
	public static int[] countBits_(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			f[i] = i;
			// System.out.println(f[i]);
			System.out.println(f[i >> 1]);// change int to binary bits, and right shift 1;
			System.out.println(i & 1);
			f[i] = f[i >> 1] + (i & 1);
			System.out.println(f[i]);
		}

		return f;
	}

}