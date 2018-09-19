package basicQuestions.String;

import java.util.Stack;

/**
 * Repeatedly remove all adjacent, repeated characters in a given string from
 * left to right.
 * 
 * No adjacent characters should be identified in the final string.
 * 
 * Examples
 * 
 * "abbbaaccz" → "aaaccz" → "ccz" → "z" "aabccdc" → "bccdc" → "bdc"
 * 
 * Consider Stack: when we need look back.
 * 
 * @author xx65
 *
 */
public class RemoveAdjacentRepeatedCharactersIV_50 {

	public static void main(String[] args) {
		char[] input = { 'a', 'b', 'b', 'b', 'a', 'a', 'c', 'c', 'z' };
		System.out.println(removeDeDupStack(input));
	}

	private static String removeDeDupStack(char[] input) {
		if (input == null || input.length <= 1) {
			return new String(input);
		}

		int i = 0;
		Stack<Character> st = new Stack<Character>();
		while (i < input.length) {
			char c = input[i];
			if (st.size() > 0 && st.peek() == c) {
				while (i < input.length && c == input[i]) {
					i++;
				}
				st.pop();
			} else {
				st.push(input[i++]);
			}
		}

		return stackToString(st);
	}

	// TODO find better method convert stack to String
	private static String stackToString(Stack st) {
		if (st == null || st.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}

}
