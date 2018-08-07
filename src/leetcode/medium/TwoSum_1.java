package leetcode.medium;
/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
import java.util.Hashtable;
import java.util.Arrays;
public class TwoSum_1{
	public static void main(String[] args){
		int[] nums = {0,4,3,0};
		int target = 0;
		int[] res = twoSum( nums, target);
		System.out.println(Arrays.toString(res));
	}
	//  {0,4,3,0} Hashtable and HashMap the duplicate key will replace the prior one and update the key.
	// in that case element 0 in the Hashtable is ( 0 , 5 )
	public static int[] twoSum(int[] nums, int target) {
		if( nums == null || nums.length == 1) return nums;
        int[] res = new int[ 2 ];
		
		Hashtable<Integer , Integer> tmp = new Hashtable<Integer , Integer>();
		int j = 0 ;
		for( int i = 0; i < nums.length ; i++){
			if( tmp.containsKey( target - nums[i] )){
				if( nums [ i ] == ( target - nums[i] ) ) {  //  {0,4,3,0} Hashtable and HashMap the duplicate key will replace the prior one and update the key.
															// in that case element 0 in the Hashtable is ( 0 , 5 )
					res[ 0 ] = tmp.get( target - nums[ i ] );
				}else{
					tmp.put( nums[i] , i + 1 );
					res[ 0 ] = tmp.get( target - nums[ i ] );
				}
				res[ 1 ] = i + 1;
				break;
			}
			tmp.put( nums[ i ] , i + 1 );
		}
		return res;
    }
}