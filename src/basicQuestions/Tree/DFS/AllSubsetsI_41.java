package Algorithm.Tree.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing
 * all subsets of the characters. Assumptions There are no duplicate characters
 * in the original set. Examples Set = "abc", all the subsets are [“”, “a”,
 * “ab”, “abc”, “ac”, “b”, “bc”, “c”] Set = "", all the subsets are [""] Set =
 * null, all the subsets are []
 *
 */
public class AllSubsetsI_41 {

	public static void main(String[] args) {
		String set = "abc";
		List<String> result = findSubSet(set);
		System.out.println(result.toString());
	}

	public static List<String> findSubSet(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] input = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		findSubSetHelper(input, sb, 0, result);
		return result;
	}

	public static void findSubSetHelper(char[] input, StringBuilder sb, int index, List<String> result) {
		if (index == input.length) {
			result.add(sb.toString());
			return;
		}

		findSubSetHelper(input, sb.append(input[index]), index + 1, result);// we add character to the string
		findSubSetHelper(input, sb, index + 1, result); // we do not add chracter to the string
		sb.deleteCharAt(sb.length() - 1);// get to the parent level for brother's nodes
	}
}
