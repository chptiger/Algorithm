package util;

//http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
public class isPrime {
	public static void main(String[] args) {
		int n = 21;
		boolean flag = isPrime(n);
	}

	public static boolean isPrime(int n) {

		for (int i = 2; 2 * i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
