/*
Given an Integereger n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
http://blog.csdn.net/pistolove/article/details/42437049
*/

package leetcode.easy;
public class FactorialTrailingZeros_172{
	public static void main(String[] args){
		int n = 100;
		int m =FactorialTrailingZeros(n);
		System.out.println(m);
	}
	
	public static int FactorialTrailingZeros(int n){
		 return n == 0? 0:n/5+FactorialTrailingZeros(n/5);
		
	}
	/*
	Timie limit exceeded
	public static void FactorialTrailingZeros(int n){
		int count = 0;
		if(n%5 == 0){
			count = n/5;
		}
		
		while(n%25 == 0){
			n = n/25;
			count--;
		}
		
		System.out.println(count);
	}
	*/
	
	/*
	int （-2147483648~2147483647）
	public static void FactorialTrailingZeros(int n){
		Integer m = factorial(n);
		System.out.println(m);
		Integer count = 0;
		while(m%10 == 0){
			count++;
			m = m/10;
		}
		
		System.out.println(count);
		
	}
	
	public static Integer factorial(int n){
		if(n == 1) return 1;
		return n*factorial(n-1);
	}
	*/
}

