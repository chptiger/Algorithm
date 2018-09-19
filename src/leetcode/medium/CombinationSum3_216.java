/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
package leetcode.medium;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum3_216 {
	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		List<List<Integer>> res = combinationSum3(k, n);
		System.out.println(res);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		combinationSum3_help(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	// https://leetcode.com/discuss/62421/simple-and-clean-java-code-backtracking
	public static void combinationSum3_help(List<List<Integer>> ans, List<Integer> tmp, int k, int start, int n) {
		if (tmp.size() > k || n < 0)
			return;
		if (tmp.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(tmp);// tmp will continue being modified. I want to put a tmp of
															// comb in result instead
			ans.add(li);
			return;
		}

		for (int i = start; i <= 9; i++) {
			// if( n >= i){
			tmp.add(i);
			combinationSum3_help(ans, tmp, k, i + 1, n - i);
			tmp.remove(tmp.size() - 1);
			// }

		}
	}
}