/*
Given an array nums, write a function to move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
package leetcode.easy;
import java.util.Arrays;
public class Move_Zeros_283{
	public static void main(String [] args){
		int[] num = {0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(num));
		int [] arr =Move_Zeros(num);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] Move_Zeros(int[] num){
		int[] arr = new int[num.length];
		System.out.println(Arrays.toString(arr));
		int j = num.length -1;
		int m = 0;
		for(int i = 0; i< num.length;i++){
			if(num[i] != 0){
					arr[m] = num[i];
					m++;
			}
			
			if(num[i] == 0){
					arr[j] = num[i];
					j--;
			}
	
		}
		return arr;
		
	}
}