package Algorithm.Sort;

/**
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
	Examples
	0th fibonacci number is 0
	1st fibonacci number is 1
	2nd fibonacci number is 1
	3rd fibonacci number is 2
	6th fibonacci number is 8
	Corner Cases
	What if K < 0? in this case, we should always return 0.
	Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed when we solve this problem on this online judge, but we should also know that it is possible to get an overflowed number, and sometimes we will need to use something like BigInteger.

 * @author Thomas
 *
 */
public class FibonacciNumber_6 {

	public static void main(String[] args) {
		int k = 5;
		System.out.println(fibonacciNumber(k));
	}

	public static int fibonacciNumber(int k) {
		int a = 0;
		int b = 1;
		if ( k <= 0) {
			return 0;
		}
		
		while (k > 1) {
			int tmp = a + b;
			a = b;
			b = tmp;
			k--;
		}
		return b;
	}
}
