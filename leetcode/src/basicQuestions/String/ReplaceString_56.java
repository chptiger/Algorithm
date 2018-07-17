package basicQuestions.String;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
Assumptions
input, S and T are not null, S is not empty string

Examples
input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "https://www.google.com?q=thomas_test", S = "_", T = "20%", input becomes "https://www.google.com?q=thomas20%test"
 *
 */
public class ReplaceString_56 {
	public static void main(String[] args) {
		String input = "appledogapple";
		String src = "apple";
		String tar = "cat";
		System.out.println(replaceString(input, src, tar));
	}

	private static String replaceString(String input, String src, String tar) {
		if(input == null || src == null || tar == null || input.length() < src.length() ) {
			return input;
		}
		
		char[] tmp = input.toCharArray();
		if(src.length() >= tar.length()) {
			return replaceShorter(tmp, src, tar);
		} else {
			return replaceLonger(tmp, src, tar);
		}
	}

	private static String replaceShorter(char[] input, String src, String tar) {
		int slow = 0, fast = 0;
		while(fast < input.length) {
			if(fast <= (input.length - src.length()) && isSubString(input, fast, src.toCharArray())) {
				copySubString(input, slow, tar.toCharArray());
				slow += tar.length();
				fast += src.length();
			} else {
				input[slow++] = input[fast++];
			}
		}
		return new String(input, 0, slow);
	}

	private static void copySubString(char[] input, int slow, char[] tar) {
		int i = 0;
		while(i < tar.length) {
			input[slow++] = tar[i++];
		}
	}

	private static boolean isSubString(char[] input, int index, char[] src) {
		int i = 0;
		while(i < src.length) {
			if(input[index] != src[i]) {
				return false;
			}
			index++;
			i++;
		}
		return true;
	}

	private static String replaceLonger(char[] tmp, String src, String tar) {
		return null;
	}
}
