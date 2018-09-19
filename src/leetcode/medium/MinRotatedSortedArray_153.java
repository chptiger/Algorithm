package leetcode.medium;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class MinRotatedSortedArray_153 {
	public static void main(String[] args) {
		int[] nums = { 3, 2 };
		int res = findMin(nums);
		System.out.println(res);
	}

	// solution: this is a sorted array, if nums[middle] > nums[end] , the minum
	// element is in the right;
	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				start = mid + 1;// why + 1?
			}
		}
		return nums[end];
	}
}