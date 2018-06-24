/*

Given an array of integers, 
find out whether there are two distinct indices i and j in the array 
such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

*/

package leetcode.medium;
import java.util.HashMap;
import java.util.Map;
public class Contain_Duplicate_220{
	public static void main(String[] args){
		int[] nums = {};
		int k = 1;
		int t = 1;
		//boolean flag = Contain_Duplicate(a , n);
		boolean flag = isDuplicate(nums, k, t);
		System.out.println(flag);
	}
	
	public static boolean isDuplicate(int[] nums, int k, int t){
		Map<Integer,Integer> tmp = new HashMap<Integer,Integer>();
		int s = nums.length;
		
		// TODO why dead code
		if( s == 0) return false;
		
		tmp.put(0, nums[0]);
		
		for(int i = 1; i < s; i++){
			
			//if( i > k) tmp.remove(i-k-1);
			
			tmp.put(i, nums[i]);
			
			for(int j = i-1; j > 0 ; j--){
				if( Math.abs(tmp.get(i) - tmp.get(j)) <= t && Math.abs(i - j) <= k){
					return true;
				}
			}
		}
		return false;
	}
}	