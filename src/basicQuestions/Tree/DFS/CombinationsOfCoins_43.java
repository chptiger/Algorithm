package Algorithm.Tree.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10
 * cents, 25 cents), get all the possible ways to pay a target number of cents.
 * Arguments
 * 
 * coins - an array of positive integers representing the different
 * denominations of coins, there are no duplicate numbers and the numbers are
 * sorted by descending order, eg. {25, 10, 5, 2, 1}
 * 
 * target - a non-negative integer representing the target number of cents, eg.
 * 99
 * 
 * Assumptions coins is not null and is not empty, all the numbers in coins are
 * positive target >= 0 You have infinite number of coins for each of the
 * denominations, you can pick any number of the coins. Return a list of ways of
 * combinations of coins to sum up to be target. each way of combinations is
 * represented by list of integer, the number at each index means the number of
 * coins used for the denomination at corresponding index. Examples coins = {2,
 * 1}, target = 4, the return should be [ [0, 4], (4 cents can be conducted by 0
 * * 2 cents + 4 * 1 cents) [1, 2], (4 cents can be conducted by 1 * 2 cents + 2
 * * 1 cents) [2, 0] (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents) ]
 *
 */
public class CombinationsOfCoins_43 {

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
