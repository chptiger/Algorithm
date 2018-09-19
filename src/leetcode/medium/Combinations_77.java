/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
package leetcode.medium;

import java.util.*;

public class Combinations_77 {
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		List<List<Integer>> res = combine(n, k);
		System.out.println(res);
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		combin_help(ans, new ArrayList<Integer>(), 1, n, k);
		return ans;
	}

	public static void combin_help(List<List<Integer>> ans, List<Integer> tmp, int start, int n, int k) {
		if (k == 0) {
			ans.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = start; i <= n; i++) {
			tmp.add(i);
			combin_help(ans, tmp, i + 1, n, k - 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}

/*
 * public static List<List<Integer>> combine(int n, int k) { List<List<Integer>>
 * combs = new ArrayList<List<Integer>>(); combine(combs, new
 * ArrayList<Integer>(), 1, n, k); return combs; } public static void
 * combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int
 * k) { if(k==0) { combs.add(new ArrayList<Integer>(comb)); return; } for(int
 * i=start;i<=n;i++) { comb.add(i); combine(combs, comb, i+1, n, k-1);
 * comb.remove(comb.size()-1); } }
 */
