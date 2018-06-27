package Algorithm.Tree.DFS;

import java.util.ArrayList;
import java.util.List;

/**
Given N pairs of parentheses “()”, return a list with all the valid permutations.
Assumptions
N >= 0
Examples
N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
N = 0, all valid permutations are [""]

 *
 */
public class AllValidPermutationsParenthesesI_42 {

	public static void main(String[] args) {
		int n = 3;
		List<String> result = findAllValidParenthses(n);
		System.out.println(result.toString());
	}

	public static List<String> findAllValidParenthses(int n) {
		List<String> result = new ArrayList<String>();
		if (n == 0) {
			return result;
		}
		StringBuilder sb = new StringBuilder();
		findAllValidParenthsesHelper(n, 0, 0, sb, result);
		return result;
	}

	public static void findAllValidParenthsesHelper(int n, int left, int right, StringBuilder sb, List<String> result) {
		if (left == n && right == n) {
			result.add(sb.toString());
			return;
		}
		if(left < n ) {
			findAllValidParenthsesHelper(n, left+1, right, sb.append("("), result);
		}
		if(left > right) {
			findAllValidParenthsesHelper(n, left, right+1, sb.append(")"), result);
		}
		sb.deleteCharAt(sb.length()-1);
	}
}
