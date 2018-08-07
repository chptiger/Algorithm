package leetcode.easy;
/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/
import java.util.Arrays;
public class LongestCommonPrefix_14{
	public static void main(String[] args){
		String[] st = {"" , " " , " "};
		String res = longestCommonPrefix(st);
		res = longestCommonPrefix_sort(st);
		System.out.println(res);
	}
	
	public static String longestCommonPrefix_sort(String[] strs) {
		StringBuilder sb = new StringBuilder();
		if(strs == null || strs.length == 0) 
			return sb.toString();
		
		Arrays.sort(strs);
		char[] start = strs[0].toCharArray();
		
		char[] end = strs[strs.length - 1].toCharArray();
		
		int j = 0;
		int m = Math.min(start.length , end.length);
		if(start.length == 0){
			return sb.toString();
		}else if( start[j] == end[j]){
			sb.append(start[j]);
			j++;
			while(j < m ){
				if(start[j] == end[j]){
						sb.append(start[j]);
						j++;
				}else {
					return sb.toString();
				}
			}			
		}else{
			return sb.toString();
		}	
		
		return sb.toString();
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return null;
		String tmp = strs[0];
		int i = 1;
		while( i < strs.length ){
			while(strs[i].indexOf(tmp) != 0){
				tmp = tmp.substring(0 , tmp.length() - 1);
			}
			i++;
		}
		
		return tmp.toString();
    }
}