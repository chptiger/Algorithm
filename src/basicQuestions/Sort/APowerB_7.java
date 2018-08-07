package Algorithm.Sort;

/**
 * 	Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 
	Examples
	power(2, 0) = 1
	power(2, 3) = 8
	power(0, 10) = 0
	power(-2, 5) = -32
	Corner Cases
	What if the result is overflowed? We can assume the result will not be overflowed when we solve this problem on this online judge.
 * 
 * O() -> nlogn
 * 
 * https://stackoverflow.com/questions/26689929/power-function-using-recursion 
 * 
 * @author Thomas
 *
 */
public class APowerB_7 {
	public static void main(String[] args) {
		System.out.println(powerLogN(2,-3));
	}
	
	/*public static long powerN (int a, int b) {
		if ( b == 0) return 1;
		return a*powerN(a, b-1);
	}*/
	
	// something like a⁹ will be a4.5⨯a4.5. But we are talking about integer powers here. Handling fractions is a whole different thing. Luckily, we can just formulate that as a⨯a⁴⨯a⁴.
	private static double powerLogN(int a, int b) {
		if (b == 0)
			return 1;
		if (b < 0) {
			return 1 / powerLogN(a, -b);
		} else {
			double half = powerLogN(a, b / 2);
			return (b % 2 == 1) ? a * half * half : half * half;
		}
		
	}
}
