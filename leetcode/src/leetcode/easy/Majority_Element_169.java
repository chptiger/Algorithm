/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
package leetcode.easy;
import java.util.Arrays;
public class Majority_Element_169{
	public static void main(String[] args){
		int[] a = {1,2,1,1};
		//int i = Majority_Element_1(a);
		
		Majority_Element(a);
	}
	
	public static void Majority_Element(int[] a){
		Arrays.sort(a);
		System.out.println( a[a.length/2]);
	}
	/*
	public static int Majority_Element_1(int[] a){
		int[] b = new int[a.length];
		Arrays.sort(a);
		int m = 0;
		for(int i=0; i<a.length-1; i++){
			if(a[i] == a[i+1]){
				b[m] = a[i];
				System.out.println(b[m]);
				m++;
			}
		}
		
		if(b[1] == 0){
			return b[0];
		}
	
		return Majority_Element(b);
	}
	*/
}