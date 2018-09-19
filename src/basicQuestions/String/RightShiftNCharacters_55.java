package basicQuestions.String;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Right shift a given string by n characters. Assumptions The given string is
 * not null. n >= 0.
 * 
 * abcdef n = 2
 * 
 * efabcd
 *
 */
public class RightShiftNCharacters_55 {
	public static void main(String[] args) {
		String input = "abcdef";
		System.out.println(rightShiftNCharacters(input, 2));
	}

	private static String rightShiftNCharacters(String input, int n) {
		if (input == null || input.length() <= 1 || input.length() == n) {
			return input;
		}

		if (input.length() < n) {
			n = n % input.length();
		}

		char[] tmp = input.toCharArray();
		reverse(tmp, 0, input.length() - 1);
		reverse(tmp, 0, n - 1);
		reverse(tmp, n, input.length() - 1);
		return new String(tmp);
	}

	private static void reverse(char[] input, int slow, int fast) {
		while (slow <= fast) {
			char tmp = input[slow];
			input[slow] = input[fast];
			input[fast] = tmp;
			slow++;
			fast--;
		}
	}

}
