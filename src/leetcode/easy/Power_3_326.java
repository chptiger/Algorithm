/*
Given an integer, 
write a function to determine if it is a power of three.
*/
package leetcode.easy;
public class Power_3_326{
	public static void main(String[] args){
		int n = 27;
		boolean flag = Power_3(n);
		System.out.println(flag);
	}
	
	public static boolean Power_3(int n){
		if(n%3 !=0 || n==0) return false;
		if(n/3 == 1) return true;
		return Power_3(n/3);
	}
}