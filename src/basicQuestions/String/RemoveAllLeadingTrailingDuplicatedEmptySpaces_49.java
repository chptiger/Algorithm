package basicQuestions.String;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * remove all leading/trailing and duplicate empty spaces(only have one empty space if duplicated spaces happen) from the input string
 * 
 * 
 * _ _ _abc _ _ ed_ _ ef_ _
 * abc_ed_ef
 * @author eng_1
 *
 */
public class RemoveAllLeadingTrailingDuplicatedEmptySpaces_49 {
	public static void main(String[] args){
	
		System.out.println(removeLeadingTrailingSpace("___abc__ed__ef__".toCharArray()));
	}
		
	public static String removeLeadingTrailingSpace(char[] input) {
		int slow = 0, fast = 0, count = 0;
		 
		while (true) {
			// leading/trailing spaces
			while(fast < input.length && input[fast] == '_') {
				fast++;
			}
			if(fast == input.length) {
				break;
			}
			// middle spaces
			if(count > 0) {
				input[slow++] = '_';
			}
			while(fast < input.length && input[fast] != '_') {
				input[slow++] = input[fast++];
			}
			count++;
		}
		return new String(input).substring(0, slow - 1);
	}
}
