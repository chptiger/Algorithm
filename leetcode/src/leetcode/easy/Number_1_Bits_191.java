/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, 
the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/
// https://leetcode.com/discuss/30605/simple-java-solution-bit-shifting
package leetcode.easy;
public class Number_1_Bits_191{
	public static void main(String[] args){
		int n = 11;
		int m = hammingWeight(n);
		
		System.out.println(m);
	}
	
	public static int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }
}