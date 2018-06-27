package leetcode.medium;

/**
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/
public class RemoveDuplicatesSortedArray_80{
	public static void main(String[] args){
		int[] nums = {1,1,1,1,3,3};
		int res = removeDuplicates( nums );
		System.out.println( res );
	}
	//[1,1,1,1,3,3]  output:[1,1,3,1]
	
	 public static int removeDuplicates(int[] nums) {
        if( nums == null && nums.length < 1) return 0;
		int count = 1;
		int i = 0;
		int j = 1;
		while( i < nums.length && j < nums.length){
			if( nums[i] == nums[j] && count== 1){
				count++;
				j++;
				i++;
			} else if( nums[i] == nums[j] && count >= 2){
				j++;
				count++;
			} else if( nums[i] == nums[j] && count ==1 && j>i+1){
				i++;
				nums[i] = nums[j];
				j++;
				count++;
			}else{
				i++;
				nums[i] = nums[j];
				j++;
				count=1;
			}
		
		}
		return i+1;
	 }	
}