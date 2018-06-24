package leetcode.medium;
/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 
Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant space complexity?
*/
import java.util.Hashtable;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
public class SingleNumber3_260{
	public static void main(String[] args){
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int[] res = isSingle(nums);
		res = SingleNumber(nums);
		System.out.println( Arrays.toString(res));
	}
	//x^x^y = y
	// a^a^b^b^c = c
	public static int[] SingleNumber(int[] nums){
		int a = 0, j = 0;
		int[] res = new int[2];
		for( int i = 0; i < nums.length; i++){
			j = j ^ nums[i];
			System.out.println( j  +  " j ");
		}
		
		for( int i = 0; i < nums.length; i++){
			a = a & nums[i];
			System.out.println( a + " a ");
		}
		return res;
	}
	//general solution Hashtable
	public static int[] isSingle(int[] nums){
		if( nums == null || nums.length <= 1 ) return nums;
		Hashtable<Integer,Integer> tmp = new Hashtable<Integer,Integer>();
		int[] las = new int[2];
		for( int i =0; i < nums.length; i++){
			if( !tmp.containsKey( nums[i] )){
				tmp.put( nums[i], 1 );
			}else{
				tmp.put( nums[i], 2 );
			}
		}
		int j = 0;
		Set<Map.Entry<Integer, Integer>> la = tmp.entrySet();
		for( Map.Entry i : la){
			if( i.getValue() == 1){
				las[j]=(int)i.getKey(); 
				j++;
			} 
		}
		
		return las;
	}
}