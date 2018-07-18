package basicQuestions.String;

/**
 * Shuffling 
 * 
 * e.g.
 * ABCDEFG1234567 -> A1B2C3D4E5F6G7
 * 
 * explanation:
 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 
 * 
 * @author xx65
 *
 */
public class StringShuffling_Advanced1 {

	public static void main(String[] args) {
		String input = "ABCDEFG1234567";
		stringShuffling(input, 0, input.length() - 1);
		System.out.println(input);
	}

	private static void stringShuffling(String input, int left, int right) {
		if ((right - left) <= 1) {
			return;
		}

		int size = input.length();
		int mid = left + size / 2;
		int lm = left + size / 4;
		int rm = left + (size * 3) / 4;

		char[] tmp = input.toCharArray();
		// I love yahoo -> yahoo love I
		reverse(tmp, lm, rm - 1);
		reverse(tmp, lm, mid - 1);
		reverse(tmp, mid, rm - 1);

		stringShuffling(input, left, left + 2 * (lm - left) - 1);
		stringShuffling(input, left + 2 * (lm - left), right);
	}

	public static void reverse(char[] input, int start, int end) {
		while (start <= end) {
			char tmp = input[start];
			input[start] = input[end];
			input[end] = tmp;
			end--;
			start++;
		}
	}

}
