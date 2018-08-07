/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
*/
package leetcode.easy;
import java.util.Arrays;
public class Remove_Dup_SL_26{
	public static void main(String[] args){
		int[] a = {1,1,3,3,3,7,7};
		//Remove_Dup_SL(a);
		
		Remove_Dup_SL_1(a);
	}
	
	public static void Remove_Dup_SL_1(int[] a){
		int i = a.length>0? 1:0;
		
		for(int n:a){
			if(n > a[i-1]){
				a[i++] = n;
			}
		}
		System.out.println(i);
		System.out.println(Arrays.toString(a));
	}
	
	public static void Remove_Dup_SL(int[] a){
		int index = 0;
		int tmp = 0;
		if(a == null) return ;
		if(a.length == 1) index = 1;
		else{
			for(int i = 0; i< a.length-1; i++){
				if(a[i] == a[i+1]){
					tmp+=1;
				}
				if(a[i]!=a[i+1]){
					a[i-tmp+1] = a[i+1];
				}
				
			}
			
			for(int i:a){
				if(a[i] > a[i+1]){
					index = i+1;
					break;
				}
			}
			
		}
		System.out.println(index);
		System.out.println(Arrays.toString(a));
	}
}