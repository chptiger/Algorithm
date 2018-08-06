package teacherX.mockInterview.String;

import org.junit.Assert;
import org.junit.Test;

/*

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. 
We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.

An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].

 */
public class ValidParenthesisString_678 {
	
	@Test
	public void test_validParenthesisIsString() {
		String input_1 = "()";
		String input_2 = "(*)";
		String input_3 = "(*))";
		
		Assert.assertEquals(true, validParenthesisIsString(input_1.toCharArray(), 0, 0));
		Assert.assertEquals(true, validParenthesisIsString(input_2.toCharArray(), 0, 0));
		Assert.assertEquals(true, validParenthesisIsString(input_3.toCharArray(), 0, 0));
	}
	
//	base case, if all the character is '*', O(n^3). It's too bad
	public static boolean validParenthesisIsString(char[] input, int start, int count) {
		if (count < 0) {
			return false;
		}
		for (int i = start; i < input.length; i++) {
			char c = input[i];
			switch (c) {
			case '(':
				count++;
				break;
			case ')':
				if (count <= 0) {
					return false;
				}
				count--;
				break;
			default:
				return validParenthesisIsString(input, start + 1, count + 1)
						|| validParenthesisIsString(input, start + 1, count - 1)
						|| validParenthesisIsString(input, start + 1, count);
			}
		}
		return count == 0;
	}
}
