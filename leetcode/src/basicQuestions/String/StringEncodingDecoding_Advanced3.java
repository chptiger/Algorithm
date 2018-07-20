package basicQuestions.String;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
* 
 * explanation:
 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 
 * 
 * @author xx65
 *
 */
public class StringEncodingDecoding_Advanced3 {

	@Test
	public void test_decompressingString() {
		Assert.assertEquals("aaabbccc", decompressing("a3b2c3".toCharArray()));
	}

	private String decompressing(char[] input) {
		if (input == null || input.length <= 1 || input.length % 2 != 0) {
			return new String(input);
		}
		Map<Character, Integer> tmp = new HashMap<>();
		int length = input.length;
		for (int i = 0; i < input.length; i += 2) {
			tmp.put(input[i], Integer.valueOf(input[i + 1]));
			length += Integer.valueOf(input[i + 1]) - 1;
		}
		
		char[] result = new char[length];
		int fast = length, slow = input.length;
		while(fast >= 0) {
			
		}
		return null;
	}
}