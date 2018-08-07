package teacherX.mockInterview.String;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  
Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  
A group is extended if that group is length 3 or more, 
so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  
As another example, 
the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  
Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, 
and add some number of the same character c to it so that the length of the group is 3 or more.  

Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - 
all extensions must leave the group extended - ie., at least 3 characters long.
 
Given a list of query words, return the number of words that are stretchy. 
    
Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.

S and all words in words consist only of lowercase letters
 */
public class ExpressiveWords_809 {
	
	@Test
	public void test_expressiveWords() {
		String s = "heeellooo";
		String[] words = {"hello", "hi", "helo"};
		Assert.assertEquals(1, findExpressiveWords(s, words));
	}

	private int findExpressiveWords(String s, String[] words) {
		if(s == null || words.length < 1) {
			return -1;
		}
		
		
		return 0;
	}
}

/*
 *  Run Length Encoding
 *  
 *  save head of string in every group with count number in the RLE class
 */
class RLE {
	String key;
	List<Integer> count;
	
	public RLE(String s) {
		StringBuilder sb = new StringBuilder();
		count = new ArrayList<>();
		
		char[] input = s.toCharArray();
		for(int i = 0; i < input.length; i++) {
			if() {
				sb.append(input[i]);
				count.add( );
			}
		}
		key = sb.toString();
	}
}
