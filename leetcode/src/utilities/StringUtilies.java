package utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtilies {
	public static void swap(char[] input, int s, int e) {
		char tmp = input[s];
		input[s] = input[e];
		input[e] = tmp;
	}
	
	public static boolean isDuplicate(char[] input) {
		Map<Character, Integer> dupMap = new HashMap<>();
		for(int i = 0; i < input.length; i++) {
			dupMap.put(input[i], dupMap.getOrDefault(input[i], 0) + 1);
			if(dupMap.get(input[i]) > 1) {
				return true;
			}
		}
		return false;
	}
}
