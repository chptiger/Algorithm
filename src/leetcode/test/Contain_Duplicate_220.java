import java.util.TreeSet;

public class Contain_Duplicate_220 {
	public static void main(String[] args) {
		int[] nums = { 0, 10, 11, 13, 0, 5, 22, 12, 1, 5 };
		int k = 3;
		int t = 3;
		boolean flag = containsNearbyAlmostDuplicate(nums, k, t);
		// boolean flag = isDuplicate(nums, k, t);
		System.out.println(flag);
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Integer> values = new TreeSet<>();
		for (int ind = 0; ind < nums.length; ind++) {
			final Integer floor = values.floor(nums[ind] + t); // 1 12 13 15 16 17 floor( 13 ) return 13
			final Integer ceil = values.ceiling(nums[ind] - t);// 1 12 13 15 16 17 ceiling( 13 ) return 15
			if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
				return true;
			}

			values.add(nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind - k]);
			}
		}

		return false;
	}

}
