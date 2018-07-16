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
public class subStringFinding {
	public static void main(String[] args){
		String input = "abcde";
		String target = "f";
		
		System.out.println(subStringFinding(input.toCharArray(), target.toCharArray()));
	}
	
	
	public static boolean subStringFinding(char[] input, char[] target) {
		if(input.length < 1 || target.length < 1 || input.length < target.length) {
			return false;
		}
		int slow = 0, fast = 0, count = 0;
		boolean res = false;
		while(fast < input.length) {
			if(input[fast] != target[slow]) {
				fast++;
				count = 0;
			} else {
				while(fast < input.length) {
					if(input[fast] != target[slow]) {
						break;
					}
					fast++;
					slow++;
					count++;
					if(count == target.length) {
						return true;
					}
				}
			}
		}
		return res;
	}
}
