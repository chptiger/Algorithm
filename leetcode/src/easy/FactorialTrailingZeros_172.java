/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/
package easy;
public class FactorialTrailingZeros{
	public static void main(){
		int n = 99;
		FactorialTrailingZeros(n);
	}
	
	public static void FactorialTrailingZeros(n){
		for(int i = 1; i<=n i++){
			n *= (n-1);
		}
		
	}
}