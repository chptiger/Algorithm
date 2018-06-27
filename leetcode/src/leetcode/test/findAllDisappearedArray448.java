package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class findAllDisappearedArray448 {

	public static void main(String[] args) {
		int[] nums = new int[]{3,2,2,1};
		System.out.println(findDisappearedNumbers(nums));
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) { 
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
