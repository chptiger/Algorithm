package basicQuestions.String;

/**
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

Assumptions
The given input string is not null.
The characters to be removed is given by another string, it is guranteed to be not null.

Examples
input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd”.

two pointer run in the same direction

Initialization (2个挡板，3个区域，同向而行)
slow = 0; all letters to the left-hand side of slow(not including fast) are all processed letters that should not be removed;
fast = 0; fast is the current index to move. all letters in [slow, fast] are all area that we do not care
(fast, size - 1] unknown area to explore

 * @author xx65
 *
 */
public class RemoveCertainCharacters_48 {
	public static void main(String[] args) {
		String input = "abcd";
		String t = "ab";

		System.out.println(removeChar(input, t));
	}

	// TODO how to avoid transfer from String to char[] ??
	public static String removeChar(String input, String t) {
		if (input == null || t == null) {
			return input;
		}
		int slow = 0, fast = 0, target = 0;
		char[] ori = input.toCharArray();
		char[] tar = t.toCharArray();
		while (fast < ori.length ) {
			if (target < tar.length && ori[fast] == tar[target]) {
				fast++;
				target++;
			} else {
				ori[slow++] = ori[fast++];
			}
		}
		
		return new String(ori).substring(0, slow); // substring: index, endIndex - 1
	}
}
