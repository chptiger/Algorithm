package basicQuestions.String;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Determine if a small string is a substring of another large string.
 * 
 * Return the index of the first occurrence of the small string in the large
 * string.
 * 
 * Return -1 if the small string is not a substring of the large string.
 * 
 * Assumptions Both large and small are not null
 * 
 * If small is empty string, return 0
 * 
 * Examples “ab” is a substring of “bcabc”, return 2 “bcd” is not a substring of
 * “bcabc”, return -1 "" is substring of "abc", return 0
 *
 */
public class IfOneStringIsAnotherSubstring_52 {
	public static void main(String[] args) {
		String input = "abcde";
		String target = "bd";

		System.out.println(subStringFinding(input.toCharArray(), target.toCharArray()));
	}

	public static int subStringFinding(char[] input, char[] target) {
		if (input.length < 1 || input.length < target.length) {
			return -1;
		}
		if (target.length < 1) {
			return 0;
		}
		int slow = 0, fast = 0;
		while (fast < input.length) {
			if (input[fast] != target[slow]) {
				fast++;
			} else {
				while (fast < input.length) {
					if (input[fast] != target[slow]) {
						slow = 0;
						break;
					}
					fast++;
					slow++;
					if (slow == target.length) {
						return fast - slow;
					}
				}
			}
		}
		return -1;
	}
}
