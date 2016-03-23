/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 = i < j < k = n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
[5,1,5,5,2,5,4]
true
[2,1,5,0,4,6]
true
*/
public class IncreasingTripletSubsequence_334{
	public static void main(String[] args){
		int[] nums = {2,1,5,0,4,6};
		boolean flag = increasingTriplet( nums );
		System.out.println( flag );
	}
	
	public static boolean increasingTriplet(int[] nums) {
        if( nums == null || nums.length <3 ) return false;
		int max1 = Integer.MAX_VALUE;
		int max2 = Integer.MAX_VALUE;
		for( int i = 0; i < nums.length; i++){
			if( nums[i] > max2) return true;
			else if( nums[i] > max1) max2 = Math.min(nums[i], max2);
			else {
				max1 = nums[i]; // [2,1,3,0,4,6] max1 = Math.min( max1, nums[i])
			}
		}
		2
		1
		1 3
		0 3
		0 4
		0 4 6
		return false;
    }
	
	// understand totally wronog, index of i j k do not need continus....
	public static boolean increasingTriplet_(int[] nums) {
        if( nums == null || nums.length <3 ) return false;
		int i = 0, j = 0;
		for( int m = 0; m < nums.length - 2; m++){
			i = m + 1;
			j = i + 1;
			System.out.println( nums[m] );
			System.out.println( nums[i] );
			System.out.println( nums[j] );
			if( nums[i] > nums[m] && nums[j] > nums[i]) {
				return true;
			}
		}
		return false;
    }
}