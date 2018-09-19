package basicQuestions.String;

/**
 * Remove adjacent, repeated characters in a given string, leaving only one
 * character for each group of such characters. Assumptions Try to do it in
 * place. Examples “aaaabbbc” is transferred to “abc” Corner Cases If the given
 * string is null, we do not need to do anything.
 * 
 * Try to do it in place: we could not use Set. because Set interface doesn't
 * provide any ordering guarantees.
 * 
 * @author xx65
 *
 */
public class RemoveAdjacentRepeatedCharactersI_51 {

	public static void main(String[] args) {
		char[] input = { 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c' };
		System.out.println(removeAdjacentRepeatedChar(input));
	}

	/*
	 * O(n) fast is the fast/current index to scan the string(from left to right)
	 * slow is the slow/index, all letters to the left of slow including(slow)
	 * should be in the final answer
	 */
	private static String removeAdjacentRepeatedChar(char[] input) {
		if (input == null || input.length <= 1) {
			return new String(input);
		}
		int slow = 0, fast = 1;
		while (fast < input.length) {
			if (input[slow] == (input[fast])) {
				fast++;
			} else {
				input[++slow] = input[fast++];
				// slow++;
				// input[slow] = input[fast++];
			}
		}
		return new String(input).substring(0, slow + 1);
	}

}
