/*
Given an integer, write a function to determine if it is a power of two.
*/
package easy;
public class isPower2_231{
	public static void main(String[] args){
		int n =32;
		boolean flag = isPower2(n);
		System.out.println(flag);
	}
	
	public static boolean isPower2(int n){
		return (Math.log10(n)/Math.log10(2))%1 == 0;
	}
}