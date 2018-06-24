package leetcode.medium;
/*
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
import java.util.Hashtable;
import java.util.Set;
import java.util.Map;
public class SingleNumber_136{
	public static void main(String[] args){
		int[] nums = {1,1,2,2,3,4,4};
		int n = singleNumber(nums);
		System.out.println(n);
	}
	/* use ^ xor no extra space and linear runtime complexity
		Logic: XOR will return 1 only on two different bits. So if two numbers are the same, XOR will return 0. 
		Finally only one number left. A ^ A = 0 and A ^ B ^ A = B.
		int singleNumber(int A[], int n) {
			int result = 0;
			for (int i = 0; i<n; i++)
			{
				result ^=A[i];
			}
			return result;
		}
	*/
	
	public static int singleNumber(int[] nums) {
        if( nums == null || nums.length == 0) return 0; //?
		if( nums.length == 1 ) return nums[0];
		
		Hashtable<Integer , Integer> tmp = new Hashtable<Integer , Integer>();
		for( int i = 0 ; i < nums.length; i++){
			if( !tmp.containsKey( nums[i] )){
				tmp.put( nums[i] , 1 );
			}else{
				tmp.put( nums[i] , 2 );
			}
		}
		
		int n = 0;
		
		Set< Map.Entry < Integer , Integer > > re = tmp.entrySet();
		for( Map.Entry < Integer , Integer > i : re){
			if( i.getValue() == 1) n = i.getKey();
		}
		
		
		return n;
    }
}