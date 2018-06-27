package Algorithm.Tree.DFS;

import java.util.ArrayList;
import java.util.List;

/**
Given a string with no duplicate characters, return a list with all permutations of the characters.
Examples
Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "", all permutations are [""]
Set = null, all permutations are []
 *
 */
public class AllPermutationsI_44 {

	public static void main(String[] args) {
		String set = "abc";
		List<String> result = findSubSet(set);
		System.out.println(result.toString());
	}
	
	public static List<String> findSubSet(String set) {
		List<String> result = new ArrayList<String>();
		if(set == null) {
			return result;
		}
		char[] input = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		 findSubSetHelper(input, sb, 0, result);
		 return result;
	}
	
	public static void findSubSetHelper(char[] input, StringBuilder sb, int index, List<String> result) {
		if(index == input.length) {
			result.add(sb.toString());
			return;
		}
	
	}
}
