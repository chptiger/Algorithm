package leetcode.easy;
/*

Given an array of integers and an integer k, 

find out whether there are two distinct indices i and j in the array 

such that nums[i] = nums[j] and the difference between i and j is at most k.

*/
import java.util.Hashtable;
public class Contain_Duplicate_219{
	public static void main(String[] args){
		int[] nums = {1,2,3,2,5,6,7};
		int k = 1;
		//boolean flag = Contain_Duplicate(a , n);
		boolean flag = isDuplicate(nums, k);
		System.out.println(flag);
	}
	
	public static boolean isDuplicate(int[] nums, int k){
		Hashtable<Integer, Integer> tmp = new Hashtable<Integer, Integer>();
		int s = nums.length;
		for(int i = 0; i < s; i++){
			if( tmp.containsKey(nums[i])&& Math.abs(tmp.get(nums[i])-i) <= k){
				return true;
			}
			tmp.put(nums[i] , i);
		}
		return false;
	}
	
	/*
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
	}
 	*/
	
	/*
	time limited O(n) = n^2;
	public static boolean Contain_Duplicate(int[] a, int n){
		int[] b = a;
		int s = a.length;
		
		for(int i = 0; i<s; i++ ){
			for(int j = 0; j < s; j++){
				if(a[i] == b[j] && i != j && Math.abs(i - j) <= n ){
					return true;
				}
			}
		}
		return false;
	}
	*/
}