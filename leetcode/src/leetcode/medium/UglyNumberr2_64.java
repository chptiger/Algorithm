package leetcode.medium;
/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

*/

public class UglyNumberr2_64{
	public static void main(String[] args){
		int n = 10;
		int res = nthUglyNumber( n );
		System.out.println( res );
	}
	
	public static int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
	}
}

/*
The idea of this solution is from this page:http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

Every step we choose the smallest one, and move one step after,including nums with same value.

Thanks for this author about this brilliant idea. Here is my java solution

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}



public int nthUglyNumber(int n) {
    int[] a = new int[n];
    a[0] = 1;
    int p2 = 0, p3 = 0, p5 = 0;
    for (int i = 1; i < n; i++) {
        while (2 * a[p2] <= a[i - 1]) {
            p2++;
        }
        while (3 * a[p3] <= a[i - 1]) {
            p3++;
        }
        while (5 * a[p5] <= a[i - 1]) {
            p5++;
        }
        a[i] = Math.min(2 * a[p2], Math.min(3 * a[p3], 5 * a[p5]));
    }
    return a[n - 1];
}


The basic idea of this problem is to compute all the ugly numbers in sequence and count to the given number of k ugly numbers. The way I approached this problem is first I have a arraylist to store the ugly numbers in sequence. Then I declared three counter variables: a,b,and c which represent the corresponding index in the arraylist for the multiplier of 2,3,and 5. Since each previous ugly number times one of the multiplier will produce a new ugly number, I start from the starting index 0 and multiply the ugly number at that index with each multiplier and get the smallest product which is the next ugly number from the three. The corresponding multipliers' index will be incremented by one and we do this recursively until we have K ugly numbers. Here is the code implementation in Java:

public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int a=0,b=0,c=0;
        List<Integer> table = new ArrayList<Integer>();
        table.add(1);
        while(table.size()<n)
        {
            int next_val = Math.min(table.get(a)*2,Math.min(table.get(b)*3,table.get(c)*5));
            table.add(next_val);
            if(table.get(a)*2==next_val) a++;
            if(table.get(b)*3==next_val) b++;
            if(table.get(c)*5==next_val) c++;
        }
        return table.get(table.size()-1);
    }
}

*/