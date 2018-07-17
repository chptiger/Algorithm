package basicQuestions.String;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
	I love yahoo -> yahoo love I
 * @author eng_1
 *
 */
public class ReverseWordsInASentenceI_54 {
	public static void main(String[] args){
		String input = "I love yahoo";
		input = reverseStringRecursive(input.toCharArray(), 0, input.length() - 1);
		System.out.println(reverseWord(input));
		
	}
	
//	TODO update return String logic
	private static String reverseWord(String input) {
		String[] tmp = input.split(" ");
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < tmp.length) {
			tmp[i] = reverseStringRecursive(tmp[i].toCharArray(), 0, tmp[i].length() - 1); 
			sb.append(tmp[i] + " ");
			i++;
		}
		return sb.toString().substring(0, sb.length() - 1);				
	}


	private static String reverseStringRecursive(char[] input, int start, int end) {
		if(start >= end) {
			return new String(input);
		}
		swap(input, start, end);
		return reverseStringRecursive(input, start + 1, end - 1);
	}
	
	private static void swap(char[] input, int slow, int fast) {
		char tmp = input[slow];
		input[slow] = input[fast];
		input[fast] = tmp;
	}

}
