package basicQuestions.String;

import java.util.ArrayList;
import java.util.List;

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
		String input = "https://www.google.com?q=thomas_test";
		String src = "_";
		String tar = "20%";
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

	/*
	    "a" replaced by "cat"
		In this case, we need from right-hand side to left-hand side by two pointers method
		If we do it from left-hand side to right-hand side, when we replace the first short string to longer string, the fast pointer will be overwritten.
		If we do it from right-hand side to left-hand side, we have new declared space to save the longer string and the original string will not be overwritten
		
		copy from input to result
	*/
	private static String replaceLonger(char[] input, String src, String tar) {
//		get final count number of the matched string
		List<Integer> matches = getAllMathcesIndex(input, src.toCharArray());
//		declare new char[] array with updated size
		char[] result = new char[input.length + matches.size() * (tar.length() - src.length())];
//		replace subString
		int slow = input.length - 1, fast = result.length - 1, matchIndex = matches.size() - 1;
		while(slow >= 0) {
			if(matchIndex >= 0 && slow == matches.get(matchIndex)) {
				copySubString(result, fast - (tar.length() - 1), tar.toCharArray());
				fast -= tar.length();
				slow -= src.length();
				matchIndex--;
			} else {
				result[fast--] = input[slow--];
			}
		}
		
		return new String(result);
	}

	private static List<Integer> getAllMathcesIndex(char[] input, char[] src) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		while(i < input.length) {
			if(isSubString(input, i, src)) {
				res.add(i + src.length - 1);
				i += src.length;
			} else {
				i++;
			}
		}
		return res;
	}
}
