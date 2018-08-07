/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
package leetcode.easy;
import java.util.Arrays;
public class Remove_Element_27{
	public static void main(String[] args){
		int[] num = {1,1,2,3,3,4,5,6,3};
		System.out.println(Arrays.toString(num));
		int length = Remove_Element(num, 3);
		
		System.out.println(length);
		System.out.println(Arrays.toString(num));
	}

	public static int Remove_Element(int[] a, int n){
		int index = 0;
		for(int i=0; i<a.length; i++){
			if(a[i] != n){
				a[index++] = a[i];
			}
		}
		return index;
	}
	
}

/*
public class Solution {
    public int removeElement(int[] A, int elem) {
       int index=0;
       for(int i=0;i<A.length;i++){
           if(A[i]!=elem){
               A[index++]=A[i];
           }
       }
       return index;
    }
}
*/