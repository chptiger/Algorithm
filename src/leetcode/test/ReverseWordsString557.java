package Leetcode;

import java.util.Arrays;

public class ReverseWordsString557 {
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		String[] tmp = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i]);
			tmp[i] = swap(tmp[i].toCharArray());
			System.out.println(tmp[i]);
			sb.append(tmp[i] + " ");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	public static String swap(char[] tmp) {
		int start = 0;
		int end = tmp.length - 1;
		int middle = end - (end - start) / 2;
		char tp;
		while (start < end) {
			tp = tmp[start];
			tmp[start] = tmp[end];
			tmp[end] = tp;
			start++;
			end--;
		}
		return new String(tmp);
	}

}
