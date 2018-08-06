package basicQuestions.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import utilities.StringUtil;

/**
 * Shuffling 
 * 
 * e.g.
 * abc 
 * ->
 * abc acb bac, bca, cab, cba
 * 
 * explanation:
 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 
 * 
 * @author xx65
 *
 */
public class StringPermutation_Advanced2 {

	@Test
	public void test_allPermutations() {
		Assert.assertEquals(new ArrayList<>(Arrays.asList("aba", "aab", "baa")), permutations("aba"));
        Assert.assertEquals(new ArrayList<>(Arrays.asList("abc", "acb", "bac","bca","cba","cab")), permutations("abc"));
	}

	private static ArrayList<String> permutations(String input) {
		ArrayList<String> result = new ArrayList<>();
		if (input == null || input.length() <= 1) {
			result.add(input);
			return result;
		}
		if(StringUtil.isDuplicate(input.toCharArray())) {
			permutationHelperDuplicateInPlace(input.toCharArray(), 0, result);
		} else {
			permutationHelperInPlace(input.toCharArray(), 0, result);
/*			StringBuilder sb = new StringBuilder();
			permutationHelper(input.toCharArray(), new boolean[input.length()], 0, result, sb);
*/		
			}
		
		return result;
	}

	/**
	 * sb.deleteCharAt(sb.length()-1); // remove the appended char
	   Q: If we remove it in result.add(new String(sb)), what will happen?
	   A: sb is only removed in the last level operation. It's the recursion function, in the backtracking process, sb is not changed.
	   
	   Q: why we need remove it?
	   A: sb will add new character everytime. we need only keep size is input.length;
	      append new char gradually and finally put it into the result
	      in the backtracking, gradually removed it and add other char.
	   
	 */
	private static void permutationHelper(char[] input, boolean[] used, int level, ArrayList<String> result, StringBuilder sb) {
		if(level == input.length) {
			result.add(new String(sb));
			return;
		}
		
		for(int i = 0; i < input.length; i++) {
			if(!used[i]) {
				used[i] = true;
				sb.append(input[i]);
				permutationHelper(input, used, level + 1, result, sb);
				used[i] = false;
				sb.deleteCharAt(sb.length()-1); // remove the appended char
			}
		}
	}
	
	private static void permutationHelperInPlace(char[] input, int index, ArrayList<String> result) {
		if(index == input.length) {
			result.add(new String(input));
			return;
		}
		
		for(int i = index; i < input.length; i++) {
				StringUtil.swap(input, index, i); // "abc" -> "cba"
				permutationHelperInPlace(input, index + 1, result);
				StringUtil.swap(input, index, i); // "cba" -> "abc"
		}
	}
	
	private static void permutationHelperDuplicateInPlace(char[] input, int index, ArrayList<String> result) {
		if(index == input.length) {
			result.add(new String(input));
			return;
		}
		
		HashSet<Character> set = new HashSet<>();
		for(int i = index; i < input.length; i++) {
			if(set.add(input[i])) {
				StringUtil.swap(input, index, i); // "abc" -> "cba"
				permutationHelperDuplicateInPlace(input, index + 1, result);
				StringUtil.swap(input, index, i); // "cba" -> "abc"
			}
		}
	}
}