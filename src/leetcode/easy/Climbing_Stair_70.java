/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
*/
package leetcode.easy;
public class Climbing_Stair_70{
	public static void main(String[] args){
		int n = 5;
		int m = Climbing_Stair(n);
		System.out.println(m);
	}
	
	public static int Climbing_Stair(int n){
		if(n==0 || n==1 || n==2) return n;
		
		int[] a = new int[n];
		a[0] = 1;
		a[1] = 2;
		
		for(int i=2; i<n; i++){
			a[i] = a[i-1] + a[i-2];
		}
		
		return a[n-1];
	}
}
