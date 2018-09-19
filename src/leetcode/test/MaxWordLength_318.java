import java.util.Arrays;
import java.util.Comparator;

//<<      :     左移运算符，num << 1,相当于num乘以2
//
//>>      :     右移运算符，num >> 1,相当于num除以2
//
//>>>    :     无符号右移，忽略符号位，空位都以0补齐
public class MaxWordLength_318 {

	public static void main(String[] args) {
		String[] arr = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		int res = maxProduct(arr);
		System.out.println(res);
	}

	public static int maxProduct(String[] words) {
		int max = 0;

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				return b.length() - a.length();
			}
		});

		System.out.println(Arrays.toString(words));
		int[] masks = new int[words.length]; // alphabet masks

		for (int i = 0; i < masks.length; i++) {
			for (char c : words[i].toCharArray()) {
				masks[i] |= 1 << (c - 'a');
			}
			System.out.println(masks[i]);
		}

		for (int i = 0; i < masks.length; i++) {
			if (words[i].length() * words[i].length() <= max)
				break; // prunning
			for (int j = i + 1; j < masks.length; j++) {
				if ((masks[i] & masks[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
					break; // prunning
				}
			}
		}

		return max;
	}
}
