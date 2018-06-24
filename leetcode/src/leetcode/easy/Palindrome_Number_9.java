package leetcode.easy;
/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. 
However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
How would you handle such case?

There is a more generic way of solving this problem.
*/
public class Palindrome_Number_9{
	public static void main(String[] args){
		int n = 9369;
		boolean flag = isPalindrome(n);
		System.out.println(flag);
	}
	
	public static boolean isPalindrome(int n){
		if(n < 0) return false;
		int val = 0;
		int s = n;
		while( s != 0){
			val = val*10 + s%10;
			s = s/10;
			//System.out.println(n);
			//System.out.println(val);
		}
		
		return (val == n);
	}
}