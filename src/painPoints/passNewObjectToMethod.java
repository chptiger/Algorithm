package painPoints;

import org.junit.Assert;
import org.junit.Test;

/**
 * When I use the method input.toCharArray() to pass the char[] to the swap method.
 * 
 * The updated is only in the swap(), and could not get the updated input in the reverse().
 * 
 * Reason:
 * A new character array was created by this method. 
 * The updating is for the new character array, not for the original String. 
 * 	toCharArray()
 * 			Converts this string to a new character array.
		    
			Returns:
			
			a newly allocated character array whose length is the length of this string 
			and whose contents are initialized to contain the character sequence represented by this string.
 * @author xx65
 *
 */
public class passNewObjectToMethod {
	
	@Test
	public void test_reverseString() {
		String input = "abc";
		Assert.assertEquals("cba", reverse(input.toCharArray(), 0, input.length() - 1));
	}
	
	private static String reverse(char[] input, int start, int end) {
		if(start >= end) {
			return new String(input);
		}
		
		utilities.StringUtil.swap(input, start, end);
		return reverse(input, start + 1, end - 1);
	}
}
