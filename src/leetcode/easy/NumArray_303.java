package leetcode.easy;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i = j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.


public class NumArray {

    public NumArray(int[] nums) {
        
    }

    public int sumRange(int i, int j) {
        
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

http://my.oschina.net/Tsybius2014/blog/528708 
*/

public class NumArray_303 {
	static int[] sum;

	public static void main(String[] args) {

		int[] tmp = { -2, 0, 3, -5, 2, -1 };

		int i = 2;
		int j = 5;
		NumArray_303(tmp);
		NumArray_303 numArray = new NumArray_303();

		int re = NumArray_303.sumRange(i, j);
		System.out.println(re);
	}

	static void NumArray_303(int[] nums) {
		sum = new int[nums.length];
		if (nums.length > 0)
			sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}

	}

	public static int sumRange(int i, int j) {
		if (i == 0)
			return sum[j];
		return sum[j] - sum[i - 1];
	}
}
