package leetcode.medium;

/**
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/
import java.util.List;
import java.util.LinkedList;

public class Pemutations_46 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}

	// solution; 1. add 1
	// 2. add 2: 2,1 1,2
	// 3. add 3: 3,2,1 2,3,1 2,1,3 3,1,2 1,3,2 1,2,3
	public static List<List<Integer>> permute(int[] nums) {
		List<Integer> tmp = new LinkedList<Integer>();
		tmp.add(nums[0]);

		List<List<Integer>> re = new LinkedList<List<Integer>>();
		re.add(tmp);

		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> new_re = new LinkedList<List<Integer>>();
			for (int j = 0; j <= i; j++) {
				for (List<Integer> l : re) {
					List<Integer> new_l = new LinkedList<Integer>(l);
					new_l.add(j, nums[i]);
					new_re.add(new_l);
				}
			}
			re = new_re;
		}
		return re;
	}
}