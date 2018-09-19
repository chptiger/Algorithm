package leetcode.easy;

/*
Reverse bits of a given 32 bits unsigned integer.

For example, 
given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
import java.util.Arrays;

public class Reverse_Bits_190 {
	public static void main(String[] args) {
		int n = 43261596;
		int val = Reverse_Bits(n);
		System.out.println(val);
	}

	// Time limited exceeded
	public static int Reverse_Bits(int n) {
		int[] m = Int_2_Bits(n);
		System.out.println("Reverse_Bits ");
		System.out.println(Arrays.toString(m));
		Reverrse_tmp_Bits(m);
		return Bits_2_Int(m);
	}

	public static int[] Int_2_Bits(int n) {
		int[] m = new int[32];
		find_index(m, n);
		System.out.println("Int_2_Bits ");
		System.out.println(Arrays.toString(m));
		return m;
	}

	public static void find_index(int[] m, int n) {

		if (n == 0)
			return;

		if (n == 1)
			m[0] = 1;

		int z = n;
		int i = 0;

		while (z != 1) {
			z = z / 2;
			i++;
		}

		m[31 - i] = 1;
		n -= Math.pow(2, i);

		find_index(m, n);
	}

	public static void Reverrse_tmp_Bits(int[] m) {
		int[] n = new int[32];
		int s = 31;
		for (int i = 0; i < 32; i++) {
			n[s] = m[i];
			s--;
		}

		m = n;
		System.out.println("Reverrse_tmp_Bits ");
		System.out.println(Arrays.toString(m));
	}

	public static int Bits_2_Int(int[] m) {
		int val = 0;
		for (int i = 0; i < 32; i++) {
			if (m[i] == 1) {
				val += Math.pow(2, i);
				System.out.println(val);
			}
		}

		return val;
	}
}