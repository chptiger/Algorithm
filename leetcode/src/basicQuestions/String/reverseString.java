import java.math.BigDecimal;
import java.math.RoundingMode;

public class reverseString {
	public static void main(String[] args){
		String input = "applee";
		System.out.println(reverseString(input.toCharArray()));
		
		input = "yahoo";
		System.out.println(reverseStringRecursive(input.toCharArray(), 0, input.length() - 1));
		
	}
	
	
	private static String reverseStringRecursive(char[] input, int start, int end) {
		if(start >= end) {
			return new String(input);
		}
		swap(input, start, end);
		return reverseStringRecursive(input, start + 1, end - 1);
	}


	public static String reverseString(char[] input) {
		int slow = 0, fast = input.length - 1;
		while(fast > slow) {
			swap(input, slow, fast);
			slow++;
			fast--;
		}
		return new String(input);
	}
	
	private static void swap(char[] input, int slow, int fast) {
		char tmp = input[slow];
		input[slow] = input[fast];
		input[fast] = tmp;
	}

}
