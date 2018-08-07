package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class nextGreatElement1 {
	
	public static void main(String[] args) {
		int[] findNums = {2,4};
		int[] nums = {1,2,3,4};
		int[] result = nextGreaterElement(findNums, nums);
		System.out.println(Arrays.toString(result));
	}
	
	static int[] nextGreaterElement(int[] findNums, int[] nums) {
      int[] result = new int[findNums.length];
      Map<Integer, Integer> inums = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
          inums.put(nums[i] , i);
      }
        
      for(int i = 0; i < findNums.length; i++){
          int index = inums.get(findNums[i]);
          int j = index;
          while(j < (inums.size()-1)) {
        	  if(nums[j+1] > nums[index]){
        		  result[i] = nums[j+1];
        		  break;
        	  }
        	  j++;
          }
          result[i] = (result[i] == 0)? -1:result[i];
      }
      
      return result;
    }
}
