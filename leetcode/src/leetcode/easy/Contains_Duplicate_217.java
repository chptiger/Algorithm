/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

Subscribe to see which companies asked this question
*/
package leetcode.easy;
import java.util.Arrays;
public class Contains_Duplicate_217{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,7,8,9};
		boolean flag = Contains_Duplicate(arr);
		System.out.println(flag);
	}
	
	public static boolean Contains_Duplicate(int[] arr){
		if( arr == null || arr.length == 1) return false;
		
		Arrays.sort(arr);
		for(int i=0; i<arr.length-1;i++){
			if(arr[i] == arr[i+1]){
				return false;
			}
		}
		return true;
	}
}